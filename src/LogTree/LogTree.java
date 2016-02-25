package logtree;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class LogTree
{
	public String[][] logtree(File file)
	{
		 int MAX = 9144;
		 String str[][] = new String[MAX][2];
		 
		 List<String> c3 = new ArrayList<String>();
		 List<String> c4 = new ArrayList<String>();
		 List<String> c5 = new ArrayList<String>();
		 MST mst3 = new MST();
		 MST mst4 = new MST();
		 MST mst5 = new MST();
		 ColumnHashTable MST3 = new ColumnHashTable(null);
		 ColumnHashTable MST4 = new ColumnHashTable(null);
		 ColumnHashTable MST5 = new ColumnHashTable(null);
		 
		 double Fc[][][] = new double[3][][];
		 try{
			FileInputStream fis=new FileInputStream(file);
			BufferedReader br=new BufferedReader(new InputStreamReader(fis));
			String str1=null;
			int j = 0;
			while((str1=br.readLine()) != null)
			{
				Fenci1 Fen = new Fenci1();
				str[j][0] = str1;
				MyTree<String> tree = Fen.fenci(str[j][0]);
				List<Node<String>> list = tree.getAllNodes();
				for (int i = 0; i < list.size(); i++)
				{
					switch (list.get(i).getDepth())
				    {
					 case 3:
						 c3.add(list.get(i).getData());
						 break;
					 case 4:
						 c4.add(list.get(i).getData());
						 break;
					 case 5:
						 c5.add(list.get(i).getData());
						 break;
					}
				 }
				j++;
			}
		 } catch (FileNotFoundException e) {
				e.printStackTrace();
		 } catch (IOException e) {
				e.printStackTrace();
		 }
		 
		 for (int i = 3; i <=5; i++)
		 {
			 switch (i)
			 {
			 case 3:
				 String[] Arr3 = c3.toArray(new String[]{});
				 MST3 = mst3.FillCT(Arr3);
				 break;
			 case 4:
				 String[] Arr4 = c4.toArray(new String[]{});
				 MST4 = mst4.FillCT(Arr4);
				 break;
			 case 5:
				 String[] Arr5 = c5.toArray(new String[]{});
				 MST5 = mst5.FillCT(Arr5);
				 break;
			 }
		 }
		 
		 int num1 = 0;
		 String An[] = new String[MAX];
		 /*
		 for (int i = 0; i < num1; i++)
		 {
			 System.out.println(An[i]);
		 }
		 for (int i = 0 ; i < MAX; i++)
		 {
			 if (num1 == 0)
			 {
				 An[num1] = str[i];
				 num1++;
				 continue;
			 }
			 else
			 {
				 for (int j = 0; j < num1; j++)
				 {
					 Similarity Sim = new Similarity();
					 if (Sim.count(str[i], str[j]) > 0.5)
					 {
						 
					 }
				 }
			 }
		 }
		 */
		 String Seg3[] = new String[MST3.getColumnHashTablec()];
		 java.util.Iterator it3 =MST3.getColumnHashTableC().getColumnHash().entrySet().iterator();
		 int num = 0;
		 Fc[0] = new double[MST3.getColumnHashTablec()][MST3.getColumnHashTablec()];
		 while(it3.hasNext())
		 {
				java.util.Map.Entry entry = (java.util.Map.Entry)it3.next();
				String Seg = (String) entry.getKey();
				Seg3[num++] = Seg;
		 }
		 for (int i = 0; i < MST3.getColumnHashTablec(); i++)
		 {
			 for (int j = i; j < MST3.getColumnHashTablec(); j++)
			 {
				 Similarity Sim = new Similarity();
				 Fc[0][i][j] = Sim.count(Seg3[i], Seg3[j]);
				 Fc[0][j][i] = Fc[0][i][j];
			 }
		 }
		 
		 String Seg4[] = new String[MST4.getColumnHashTablec()];
		 java.util.Iterator it4 =MST4.getColumnHashTableC().getColumnHash().entrySet().iterator();
		 num = 0;
		 Fc[1] = new double[MST4.getColumnHashTablec()][MST4.getColumnHashTablec()];
		 while(it4.hasNext())
		 {
				java.util.Map.Entry entry = (java.util.Map.Entry)it4.next();
				String Seg = (String) entry.getKey();
				Seg4[num++] = Seg;
			}
		 for (int i = 0; i < MST4.getColumnHashTablec(); i++)
		 {
			 for (int j = i; j < MST4.getColumnHashTablec(); j++)
			 {
				 Similarity Sim = new Similarity();
				 
				 Fc[1][i][j] = Sim.count(Seg4[i], Seg4[j]);
				 Fc[1][j][i] = Fc[1][i][j];
			 }
		 }
		 String Seg5[] = new String[MST5.getColumnHashTablec()];
		 java.util.Iterator it5 =MST5.getColumnHashTableC().getColumnHash().entrySet().iterator();
		 num = 0;
		 Fc[2] = new double[MST5.getColumnHashTablec()][MST5.getColumnHashTablec()];
		 while(it5.hasNext())
		 {
				java.util.Map.Entry entry = (java.util.Map.Entry)it5.next();
				String Seg = (String) entry.getKey();
				Seg5[num++] = Seg;
			}
		 for (int i = 0; i < MST5.getColumnHashTablec(); i++)
		 {
			 for (int j = i; j < MST5.getColumnHashTablec(); j++)
			 {
				 Similarity Sim = new Similarity();
				 Fc[2][i][j] = Sim.count(Seg5[i], Seg5[j]);
				 Fc[2][j][i] = Fc[2][i][j];
			 }
		 }
		 //搜寻不相似的结果
		 for (int i = 0 ; i < MAX; i++)
		 {
			 if (num1 == 0)
			 {
				 An[num1] = str[i][0];
				 str[i][1] = num1 + "";
				 num1++;
				 continue;
			 }
			 Fenci1 Fen = new Fenci1();
			 MyTree<String> tree = Fen.fenci(str[i][0]);
			 List<Node<String>> list = tree.getAllNodes();
			 int mark = 1;
			 for (int j = 0; j < num1; j++)
			 {
				 Fenci1 Fen1 = new Fenci1();
				 MyTree<String> tree1 = Fen1.fenci(An[j]);
				 List<Node<String>> list1 = tree1.getAllNodes();
				 double Sim = 0;
				 mark = 1;
				 for (int i1 = 2; i1 < list.size(); i1++)
				 {
					 for (int j1 = 2; j1 < list1.size(); j1++)
					 {
						 if (list.get(i1).getDepth() == 3 && list1.get(j1).getDepth() ==3)
						 {
							 int k = 0;
							 int ii = -1;
							 int jj = -1;
							 do 
							 {
								 if (list.get(i1).getData().contains(Seg3[k]))
								 {
									 ii = k;
								 }
								 if (list1.get(j1).getData().contains(Seg3[k]))
								 {
									 jj = k;
								 }
								 k++;
							 } while (k < Seg3.length);
							 Sim = Sim + Fc[0][ii][jj];
						 }
						 else if (list.get(i1).getDepth() == 4 && list1.get(j1).getDepth() ==4)
						 {
							 int k = 0;
							 int ii = -1;
							 int jj = -1;
							 do 
							 {
								 if (list.get(i1).getData().contains(Seg4[k]) && Seg4[k].contains(list.get(i1).getData()))
								 {
									 ii = k;
								 }
								 if (list1.get(j1).getData().contains(Seg4[k]) && Seg4[k].contains(list1.get(j1).getData()))
								 {
									 jj = k;
								 }
								 k++;
							 } while (k < Seg4.length);
							 Sim = Sim + Fc[1][ii][jj]*0.5;
						 }
						 else if (list.get(i1).getDepth() == 5 && list1.get(j1).getDepth() ==5)
						 {
							 int k = 0;
							 int ii = -1;
							 int jj = -1;
							 do 
							 {
								 if (list.get(i1).getData().contains(Seg5[k]) && Seg5[k].contains(list.get(i1).getData()))
								 {
									 ii = k;
								 }
								 if (list1.get(j1).getData().contains(Seg5[k]) && Seg5[k].contains(list1.get(j1).getData()))
								 {
									 jj = k;
								 }
								 k++;
							 } while (k < Seg5.length);
							 Sim = Sim + Fc[2][ii][jj]*0.25;
						 }
					 }
				 }
				/* System.out.println(Sim); */
				 Sim = Sim/((list.size())); 
				/* System.out.println(Sim); */
				 if (Sim > 0.35)
				 {
					 mark = 0;
					 str[i][1] = j + "";
					 break;
				 }
			 }
			 if (mark == 1)
			 {
			/*	 System.out.println(num1+" "+str[i]);  */
				 An[num1] = str[i][0];
				 str[i][1] = num1+ "";
				 num1++;
			 }
		 }
		 /*
		 for (int i = 0; i < num1; i++)
		 {
			 System.out.println(An[i]);
		 }
		 */
		 return str;
	}
}