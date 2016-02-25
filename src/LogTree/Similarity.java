package logtree;

public class Similarity
{
	public double count(String str1, String str2)
	{
		/*
		 * index  1
		 * ip     2
		 * word   3
		 * oid    4
		 * comment5
		 * number 6
		 * symbol 7
		 * 
		 */
		String[] Array1 = str1.split(" ");
		String[] Array2 = str2.split(" ");
		String[][] array1 = new String[Array1.length][2];
		String[][] array2 = new String[Array2.length][2];
		for (int i = 0;i < Array1.length; i++)
		{
			if (Array1.length == 1)
			{
				int point = 0;
				int word = 0;
				int num = 0;
				for (int j = 0; j < Array1[i].length(); j++)
				{
					if (Array1[i].charAt(j) == '.')
					{
						point++;
					}
					else if ((Array1[i].charAt(j)<=57) && (Array1[i].charAt(j)>=48))
					{
						num++;
					}
					else if ((Array1[i].charAt(j)<=90) && (Array1[i].charAt(j)>=65) || (Array1[i].charAt(j)<=122) && (Array1[i].charAt(j)>=97))
					{
						word++;
					}
				}
					if (point == 2)
					{
						array1[i][0] = Array1[i];
						array1[i][1] = "1";
					}
					else if (point == 3)
					{
						array1[i][0] = Array1[i];
						array1[i][1] = "2";
					}
					else if (point > 3)
					{
						array1[i][0] = Array1[i];
						array1[i][1] = "4";
					}
					else
					{
						if (num == Array1[i].length())
						{
							array1[i][0] = Array1[i];
							array1[i][1] = "6";
						}
						else
						{
							if (word != 0)
							{
								array1[i][0] = Array1[i];
								array1[i][1] = "3";
							}
							else
							{
								array1[i][0] = Array1[i];
								array1[i][1] = "7";
							}
						}
					}
				
			}
			else
			{
				int leng = 0;
				int point[] = new int[Array1.length];
				int word[] = new int[Array1.length];
				int num[] = new int[Array1.length];
				do
				{
					for (int j = 0; j < Array1[leng].length(); j++)
					{
						if (Array1[leng].charAt(j) == '.')
						{
							point[leng]++;
						}
						else if ((Array1[leng].charAt(j)<=57) && (Array1[leng].charAt(j)>=48))
						{
							num[leng]++;
						}
						else if ((Array1[leng].charAt(j)<=90) && (Array1[leng].charAt(j)>=65) || (Array1[leng].charAt(j)<=122) && (Array1[leng].charAt(j)>=97))
						{
							word[leng]++;
						}
					}
					leng++;
				}while (leng < Array1.length);
				int cout = 0;
				for (int j = 0; j < Array1.length; j++)
				{
					if (Array1[j].equals("OID"))
					{
						String seg = Array1[j] + " " + Array1[j+1];
						array1[cout][0] = seg;
						array1[cout][1] = "4";
						cout++;
						j++;
					}
					else if ((point[j] != 0) && (num[j] != 0) && (word[j] == 0))
					{
						array1[cout][0] = Array1[j];
						array1[cout][1] = "2";
						cout++;
					}
					else
					{
						String seg = "";
						do
						{
							seg = seg + Array1[j] + " ";
							j++;
						}while (j < Array1.length && (point[j] == 0 || num[j]==0));
						array1[cout][0] = seg;
						array1[cout][1] = "5";
						cout++;
						j--;
					}
				}
			}
		}
		for (int i = 0;i < Array2.length; i++)
		{
			if (Array2.length == 1)
			{
				int point = 0;
				int word = 0;
				int num = 0;
				for (int j = 0; j < Array2[i].length(); j++)
				{
					if (Array2[i].charAt(j) == '.')
					{
						point++;
					}
					else if ((Array2[i].charAt(j)<=57) && (Array2[i].charAt(j)>=48))
					{
						num++;
					}
					else if ((Array2[i].charAt(j)<=90) && (Array2[i].charAt(j)>=65) || (Array2[i].charAt(j)<=122) && (Array2[i].charAt(j)>=97))
					{
						word++;
					}
					if (point == 2)
					{
						array2[i][0] = Array2[i];
						array2[i][1] = "1";
					}
					else if (point == 3)
					{
						array2[i][0] = Array2[i];
						array2[i][1] = "2";
					}
					else if (point > 3)
					{
						array2[i][0] = Array2[i];
						array2[i][1] = "4";
					}
					else
					{
						if (num == Array2[i].length())
						{
							array2[i][0] = Array2[i];
							array2[i][1] = "6";
						}
						else
						{
							if (word != 0)
							{
								array2[i][0] = Array2[i];
								array2[i][1] = "3";
							}
							else
							{
								array2[i][0] = Array2[i];
								array2[i][1] = "7";
							}
						}
					}
				}
			}
			else
			{
				int leng = 0;
				int point[] = new int[Array2.length];
				int word[] = new int[Array2.length];
				int num[] = new int[Array2.length];
				do
				{
					for (int j = 0; j < Array2[leng].length(); j++)
					{
						if (Array2[leng].charAt(j) == '.')
						{
							point[leng]++;
						}
						else if ((Array2[leng].charAt(j)<=57) && (Array2[leng].charAt(j)>=48))
						{
							num[leng]++;
						}
						else if ((Array2[leng].charAt(j)<=90) && (Array2[leng].charAt(j)>=65) || (Array2[leng].charAt(j)<=122) && (Array2[leng].charAt(j)>=97))
						{
							word[leng]++;
						}
					}
					leng++;
				}while (leng < Array2.length);
				int cout = 0;
				for (int j = 0; j < Array2.length; j++)
				{
					if (Array2[j].equals("OID"))
					{
						String seg = Array2[j] + " " + Array2[j+1];
						array2[cout][0] = seg;
						array2[cout][1] = "4";
						cout++;
						j++;
					}
					else if ((point[j] != 0) && (num[j] != 0) && (word[j] == 0))
					{
						array2[cout][0] = Array2[j];
						array2[cout][1] = "2";
						cout++;
					}
					else
					{
						String seg = "";
						do
						{
							seg = seg + Array2[j] + " ";
							j++;
						}while (j < Array2.length && (point[j] == 0 || num[j]==0));
						array2[cout][0] = seg;
						array2[cout][1] = "5";
						cout++;
						j--;
					}
				}
			}
		}
		int sum1 = 0;
		while (sum1 < array1.length && array1[sum1][0] != null)
		{
			sum1++;
		}
		int sum2 = 0;
		while (sum2 < array2.length && array2[sum2][0] != null)
		{
			sum2++;
		}
		double d = 0;
		for (int i = 0; i < sum1; i++)
		{
			for (int j = 0; j < sum2; j++)
			{
				
				if ((array1[i][0].contains(array2[j][0]) && (array1[i][0].length() - array2[j][0].length() <= 2)) || (array2[j][0].contains(array1[i][0]) && (array2[j][0].length() - array1[i][0].length() <= 2)))
				{
					d++;
				}
				else if (array1[i][1].equals(array2[j][1]))
				{
					d = d + 0.5;
				}
			}
		}
		d = d / (Math.sqrt(sum1*sum2));
		return d;
	}
}