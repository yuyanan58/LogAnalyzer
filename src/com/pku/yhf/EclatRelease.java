package com.pku.yhf;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class EclatRelease {

	
	private float limitValue=0.1f;
	private int transNum=0;
	private ArrayList<HeadNode> array=new ArrayList<HeadNode>();
	private HashHeadNode[] hashTable;//存放临时生成的频繁项集，作为重复查询的备选集合
	public long newItemNum=0;
	
	private File tempFile=null;
	private BufferedWriter bw=null;
	
	public static long modSum=0;
	/**
	 * 第一遍扫描数据库，确定Itemset,根据阈值计算出支持度数
	 */
	public void init(File file)
	{
		Set itemSet=new TreeSet();
		MyMap<Integer,Integer> itemMap=new MyMap<Integer,Integer>();
		
		int itemNum=0;
		Set[][] a;
		try {
			FileInputStream fis=new FileInputStream(file);
			BufferedReader br=new BufferedReader(new InputStreamReader(fis));
			String str=null;
			
			//第一次扫描数据集合
			while((str=br.readLine()) != null)
			{
				transNum++;
				String[] line=str.split(" ");
				for(String item:line)
				{
					itemSet.add(Integer.parseInt(item));
					itemMap.add(Integer.parseInt((item)));
				}
			}
			br.close();
		//	System.out.println("itemMap lastKey:"+itemMap.lastKey());
		//	System.out.println("itemsize:"+itemSet.size());
		//	System.out.println("trans: "+transNum);
			//ItemSet.limitSupport=(int)Math.ceil(transNum*limitValue);//上取整
			ItemSet.limitSupport=(int)Math.floor(transNum*limitValue);//下取整
			ItemSet.ItemSize=(Integer)itemMap.lastKey();
			ItemSet.TransSize=transNum;
			hashTable=new HashHeadNode[ItemSet.ItemSize*3];//生成项集hash表
			for(int i=0;i<hashTable.length;i++)
			{
				hashTable[i]=new HashHeadNode();
			}
			
		//	System.out.println("limitSupport:"+ItemSet.limitSupport);
			
			
			tempFile=new File("mushroom.dat.txt.dat");
			if(tempFile.exists())
			{
				tempFile.delete();
			}
			tempFile.createNewFile();
			
			
			bw=new BufferedWriter(new FileWriter(tempFile));
			
			
			
			Set oneItem=itemMap.keySet();
			int countOneItem=0;
			for(Iterator it=oneItem.iterator();it.hasNext();)
			{
				int key=(Integer)it.next();
				int value=(Integer)itemMap.get(key);
				if(value >= ItemSet.limitSupport)
				{
					bw.write(key+" "+":"+" "+value);
					bw.write("\r\n");
					countOneItem++;
				}
			}
			bw.flush();
			modSum+=countOneItem;
			
			itemNum=(Integer)itemMap.lastKey();
			
			a=new TreeSet[itemNum+1][itemNum+1];
			array.add(new HeadNode());//空项
			
			for(short i=1;i<=itemNum;i++)
			{
				HeadNode hn=new HeadNode();
			//	hn.item=i;
				array.add(hn);
			}
			
			BufferedReader br2=new BufferedReader(new FileReader(file));
			
			//第二次扫描数据集合,形成2-项候选集
			int counter=0;//事务
			int max=0;
			while((str=br2.readLine()) != null)
			{max++;
				String[] line=str.split(" ");
				counter++;
				for(int i=0;i<line.length;i++)
				{
					int sOne=Integer.parseInt(line[i]);
					for(int j=i+1;j<line.length;j++)
					{
						int sTwo=Integer.parseInt(line[j]);
						if(a[sOne][sTwo] == null)
						{
							Set set=new TreeSet();
							set.add(counter);
							a[sOne][sTwo]=set;
						}
						else{
							a[sOne][sTwo].add(counter);
													
						}
					}
				}
			}
			//将数组集合转换为链表集合
			
			for(int i=1;i<=itemNum;i++)
			{
				HeadNode hn=array.get(i);
				for(int j=i+1;j<=itemNum;j++)
				{
					if(a[i][j] != null && a[i][j].size() >= ItemSet.limitSupport)
					{
						hn.items++;
						ItemSet is=new ItemSet(true);
						is.item=2;
						is.items.set(i);
						is.items.set(j);
						is.supports=a[i][j].size();
						bw.write(i+" "+j+" "+": "+is.supports);
						bw.write("\r\n");
						//统计频繁2-项集的个数
						modSum++;
						for(Iterator it=a[i][j].iterator();it.hasNext();)
						{
							int value=(Integer)it.next();
							is.trans.set(value);
						}
						if( hn.first== null)
						{
							hn.first=is;
							hn.last=is;
						}
						else{
							hn.last.next=is;
							hn.last=is;
						}
					}
				}
			}
			bw.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void start()
	{
		boolean flag=true;
		//TreeSet ts=new TreeSet();//临时存储项目集合，防止重复项集出现，节省空间
		
		int count=0;
		
		ItemSet shareFirst=new ItemSet(false);
		
		while(flag)
		{
			flag=false;
			//System.out.println(++count);
			for(int i=1;i<array.size();i++)
			{
				HeadNode hn=array.get(i);
				
				
				if(hn.items > 1 )//项集个数大于1
				{	
					generateLargeItemSet(hn,shareFirst);
					flag=true;
					
				}
				clear(hashTable);
			}
			
		}try {
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void generateLargeItemSet(HeadNode hn,ItemSet shareFirst){
		
		
		BitSet bsItems=new BitSet(ItemSet.ItemSize);//存放链两个k-1频繁项集的ItemSet交
		BitSet bsTrans=new BitSet(ItemSet.TransSize);//存放两个k-1频繁项集的Trans交
		BitSet containItems=new BitSet(ItemSet.ItemSize);//存放两个k-1频繁项集的ItemSet的并
		BitSet bsItems2=new BitSet(ItemSet.ItemSize);//临时存放容器BitSet
		
		ItemSet oldCurrent=null,oldNext=null;
		oldCurrent=hn.first;
		long countItems=0;
		
		ItemSet newFirst=new ItemSet(false),newLast=newFirst;
		while(oldCurrent != null)
		{
			oldNext=oldCurrent.next;
			while(oldNext != null)
			{
				//生成k—项候选集，由两个k-1项频繁集生成
				bsItems.clear();
				bsItems.or(oldCurrent.items);
				bsItems.and(oldNext.items);
				
				if(bsItems.cardinality() < oldCurrent.item-1)
				{
					break;
				}
				//新合并的项集是否已经存在
				
				containItems.clear();
				containItems.or(oldCurrent.items);//将k-1项集合并
				containItems.or(oldNext.items);
				
				if(!containItems(containItems,bsItems2,newFirst)){
					
					bsTrans.clear();
					bsTrans.or(oldCurrent.trans);
					bsTrans.and(oldNext.trans);
					if(bsTrans.cardinality() >= ItemSet.limitSupport)
					{
						ItemSet is=null;
						
						if(shareFirst.next == null)//没有共享ItemSet链表
						{
							is=new ItemSet(true);
							newItemNum++;
						}
						else
						{
							is=shareFirst.next;
							shareFirst.next=shareFirst.next.next;
							
							is.items.clear();
							is.trans.clear();
							is.next=null;
							
						}
						is.item=(oldCurrent.item+1);//生成k—项候选集，由两个k-1项频繁集生成
						
						is.items.or(oldCurrent.items);//将k-1项集合并
						is.items.or(oldNext.items);//将k-1项集合并
						
						is.trans.or(oldCurrent.trans);//将bs1的值复制到bs中
						is.trans.and(oldNext.trans);
						
						is.supports=is.trans.cardinality();
						
						writeToFile(is.items,is.supports);//将频繁项集及其支持度写入文件
						countItems++;
						
						modSum++;
						newLast.next=is;
						newLast=is;
						
					}
				}
				oldNext=oldNext.next;
			}
			oldCurrent=oldCurrent.next;
		}
		
		ItemSet temp1=hn.first;
		ItemSet temp2=hn.last;
		
		temp2.next=shareFirst.next;
		shareFirst.next=temp1;
		
		hn.first=newFirst.next;
		hn.last=newLast;
		hn.items=countItems;
		
	}
	
	public boolean containItems(BitSet containItems,BitSet bsItems2,ItemSet first)
	{
		long size=containItems.cardinality();//项集数目
		
		int itemSum=0;
		int temp=containItems.nextSetBit(0);
		while(true)
		{
			itemSum+=temp;
			temp=containItems.nextSetBit(temp+1);
			if(temp == -1)
			{
				break;
			}
		}
		
		int hash=itemSum%(ItemSet.ItemSize*3);
		
		HashNode hn=hashTable[hash].next;
		Node pre=hashTable[hash];
		while(true)
		{
			if(hn == null)//不包含containItems
			{
				HashNode node=new HashNode();
				node.bs.or(containItems);
				
				pre.next=node;
				
				return false;
			}
			if(hn.bs.isEmpty())
			{
				hn.bs.or(containItems);
				
				return false;
			}
			
			bsItems2.clear();
			bsItems2.or(containItems);
			bsItems2.and(hn.bs);
			
			if(bsItems2.cardinality() == size)
			{
				return true;
			}
			pre=hn;
			hn=hn.next;
		}
		
	}
	
	public void clear(HashHeadNode[] hashTable)
	{
		for(int i=0;i<hashTable.length;i++)
		{
			HashNode node=hashTable[i].next;
			while(node != null)
			{
				node.bs.clear();
				node=node.next;
			}
		}
	}
	
	public void writeToFile(BitSet items,int supports)
	{
		StringBuilder sb=new StringBuilder();
		//sb.append("<");
		int temp=items.nextSetBit(0);
		sb.append(temp);
		while(true)
		{
			temp=items.nextSetBit(temp+1);
			if(temp == -1)
			{
				break;
			}
			//sb.append(",");
			sb.append(" ");
			sb.append(temp);
		}
		sb.append(" :"+" "+supports);
		try {
			bw.write(sb.toString());
			bw.write("\r\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void eclat(File file) {
		EclatRelease e=new EclatRelease();
		long begin=System.currentTimeMillis();
		e.init(file);
		e.start();
		long end=System.currentTimeMillis();
		
		double time=(double)(end-begin)/1000;
		/*System.out.println("共耗时"+time+"秒");*/
		System.out.println("频繁模式数目:"+EclatRelease.modSum);
	}
}
class MyMap<T,E> extends TreeMap
{
	public void add(T obj)
	{
		if(this.containsKey(obj))
		{
			int value=(Integer)this.get(obj);
			this.put(obj, value+1);
		}
		else 
			this.put(obj, 1);
	}
}