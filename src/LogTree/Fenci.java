package logtree;

import java.awt.List;
import java.util.ArrayList;

public class Fenci
{
	public String[] fenci(String Log)
	{
		String[] Array = Log.split(" ");
		String[] Seg = new String[100]; 
		int leng = 0;
		int c = 0;
		int num = 0;
		Node root = new Node();
		MyTree tree= new MyTree();
		/*
		 * 处理日志的格式  A: B: "" C: ""  D
		 */
		while (leng < Array.length)
		{
			if (leng == 0)
			{
				if (Array[leng].indexOf(":") == -1)
				{
					Node<String> root1 = new Node<String>(Array[leng],-1,1);
					root = root1;
				    MyTree<String> tree1 = new MyTree<String>(root);
				    tree = tree1;  
					leng++;
				}
				else
				{
					int lengz = leng;
					int lengy = leng;
					while (Array[lengy].indexOf(":") == -1)
						lengy++;
					String segment="";
					for (int j = lengz; j<= lengy; j++)
					{
						segment = segment + Array[j];
					}
					Node<String> root1 = new Node<String>(segment,-1,1);
					root = root1;
				    MyTree<String> tree1 = new MyTree<String>(root);
				    tree = tree1;
					leng = lengy+1;
				}
			}
			else
			{
				int lengz = leng;
				int lengy = leng;
				do
				{
					System.out.println(Array[lengy]+" "+Array[lengy].indexOf("\""));
					lengy++;
				}while ((lengy < Array.length) && (Array[lengy-1].indexOf("\"") == -1));
				if (Array[lengy-1].indexOf("\"") == -1 && lengy == Array.length)
				{
					String segment="";
					for (int j = lengz; j< lengy; j++)
					{
						segment = segment + Array[j];
					}
					Seg[num++] = segment;
					leng = lengy;
				}
				else
				{
					String segment="";
					for (int j = lengz; j< lengy; j++)
					{
						segment = segment + Array[j];
					}
					Seg[num++] = segment;
					leng = lengy;
				}
			}
			for (int i = 0; i < num; i++)
			{
				i = num - 1;
				int pos = Seg[i].indexOf(":");
				if (pos != -1)
				{
					String segment = Seg[i].substring(0, pos+1);
					Node<String> root1 = new Node<String>(segment,1,2);  
					tree.add(root1,root);
				    segment = Seg[i].substring(pos+1, Seg[i].length());
				    Node<String> root2 = new Node<String>(segment,1,3);  
				    tree.add(root2,root1);
				}
				else
				{
					Node<String> root1 = new Node<String>(Seg[i],1,2);  
					tree.add(root1,root);
				}
			}
		}
		System.out.println(tree.getSize());
		return null;
	}
}