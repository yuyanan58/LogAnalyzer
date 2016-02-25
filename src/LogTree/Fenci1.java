package logtree;

import java.awt.List;
import java.util.ArrayList;

public class Fenci1
{
	public MyTree<String> fenci(String Log)
	{
		String[] Array = Log.split(" ");
		String[] Seg = new String[100]; 
		int leng = 0;
		int c = 0;
		int num = 0;
		if (Array[2].indexOf("") != -1 && Array[2].length() == 1)
			leng = 6;
		else
			leng = 5;
		String segment1="";
		for (int i = 0; i <= leng-2; i++)
		{
			segment1 = segment1 + Array[i] + " ";
		}
		Node<String> root = new Node<String>(segment1,-1,1);
	    MyTree<String> tree = new MyTree<String>(root);
	    Node<String> root1 = new Node<String>(Array[leng-1],0,2);
	    tree.add(root1,root);
	    root = root1;
	    int leng11 = leng;
		while (leng < Array.length)
		{
			do
			{
				if (Array[leng].indexOf(".") != -1 && leng < Array.length-1)
				{
					int cout = 0;
					for (int i = 0; i< Array[leng].length(); i++)
					{
						if ((Array[leng].charAt(i)<=57) && (Array[leng].charAt(i)>=48))
						{
							cout++;
						}
					}
					if ((((float)cout/Array[leng].length()) > 0.5) && (leng+1 < Array.length))
					{
						leng++;
						break;
					}
					else
					{
						int pos = Array[leng11].indexOf(":");
						segment1 = Array[leng11].substring(0, pos+1);
						int zz = segment1.indexOf("[");
						int zy = segment1.indexOf("]");
						if (zz != -1 && zy != -1)
						{
							segment1 = segment1.substring(0, zz)+segment1.substring(zy+1, pos);
						}
						Node<String> root2 = new Node<String>(segment1,1,3);
						tree.add(root2, root);
						segment1 = Array[leng11].substring(pos+1, Array[leng11].length());
						for (int i = leng11+1;i <= leng; i++)
						{
							segment1 = segment1 + " " + Array[i];
						}
						Node<String> root3 = new Node<String>(segment1,1,4);  
						tree.add(root3,root2);
						root = root2;
					}
					leng++;
				}
				else if (leng == Array.length-1)
				{
					int pos = Array[leng11].indexOf(":");
					segment1 = Array[leng11].substring(0, pos+1);
					int zz = segment1.indexOf("[");
					int zy = segment1.indexOf("]");
					if (zz != -1 && zy != -1)
					{
						segment1 = segment1.substring(0, zz)+segment1.substring(zy+1, pos);
					}
					Node<String> root2 = new Node<String>(segment1,1,3);
					tree.add(root2, root);
					segment1 = Array[leng11].substring(pos+1, Array[leng11].length());
					for (int i = leng11+1;i <= leng; i++)
					{
						segment1 = segment1 + " " + Array[i];
					}
					Node<String> root3 = new Node<String>(segment1,1,4);  
					tree.add(root3,root2);
					root = root2;
					leng++;
				}
				else
				{
					leng++;
				}
			}while ((leng < Array.length) && ((Array[leng].indexOf("=") == -1) || (Array[leng].indexOf("(") == -1)));
			if ((leng == Array.length-1) && Array[leng].indexOf(".") != -1)
			{
				int pos = Array[leng11].indexOf(":");
				segment1 = Array[leng11].substring(0, pos+1);
				int zz = segment1.indexOf("[");
				int zy = segment1.indexOf("]");
				if (zz != -1 && zy != -1)
				{
					segment1 = segment1.substring(0, zz)+segment1.substring(zy+1, pos);
				}
				Node<String> root2 = new Node<String>(segment1,1,3);
				tree.add(root2, root);
				segment1 = Array[leng11].substring(pos+1, Array[leng11].length());
				for (int i = leng11+1;i < leng; i++)
				{
					segment1 = segment1 + " " + Array[i];
				}
				segment1 = segment1 + " " + Array[leng].substring(0, Array[leng].indexOf(".")+1);
				Node<String> root3 = new Node<String>(segment1,1,4);  
				tree.add(root3,root2);
				root = root2;
			}
			if ((leng < Array.length) && Array[leng].indexOf("=") != -1)
			{
				segment1 = "";
				for (int i = leng; i< Array.length; i++)
				{
					segment1 = segment1+Array[i];
				}
				segment1 = segment1.substring(segment1.indexOf("(")+1, segment1.indexOf(")"));
				segment1 = "," + segment1 + ",";
				int leng1 = 0;
				int d[] = new int[20];
				int cout = 0;
				do
				{
					d[++cout] = segment1.indexOf("=", leng1+1);
					leng1 = d[cout];
				}while (leng1 < segment1.length() && segment1.indexOf("=", leng1+1)!= -1);
				for (int i = 0; i < cout; i++)
				{
					String seg = segment1.substring(segment1.indexOf(",", d[i])+1 , d[i+1]);
					Node<String> root2 = new Node<String>(seg,1,4);
					tree.add(root2, root);
					String seg1 = segment1.substring(d[i+1]+1, segment1.indexOf(",", d[i+1]+1));
					Node<String> root3 = new Node<String>(seg1,1,5);
					tree.add(root3, root2);
				}
				leng = Array.length;
			}
			
		}
		return tree;
	}
}