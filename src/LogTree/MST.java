package logtree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

public class MST
{
		
	public ColumnHashTable FillCT(String[] Segment)
	{
		HashMap CHT1 = new HashMap<ColumnHash, Integer>();
		ColumnHashTable CHT = new ColumnHashTable(CHT1);
		HashMap CH1 = new HashMap<String , HashMap<Integer , Integer>>();
		ColumnHash CH = new ColumnHash(CH1);
		int colM = 0;
		for (int i = 0; i < Segment.length; i++)
		{
			HashMap<Integer , Integer> list = new HashMap<Integer , Integer>();
			if (CH.empty())
			{
				list = new HashMap<Integer , Integer>();  
	    		list.put(++colM , 1);
	    		CH.putColumnHash(Segment[i], list);
			}
			else
			{
				list = CH.getColumnHashValue(Segment[i]); 
				if(list == null)
				{
					list = new HashMap<Integer , Integer>();  
		    		list.put(++colM , 1);
		    		CH.putColumnHash(Segment[i], list);
				}
				else
				{
					int Col = 0 , Occur = 0;
					java.util.Iterator it = list.entrySet().iterator();
					while(it.hasNext()){
						java.util.Map.Entry entry = (java.util.Map.Entry)it.next();
						Col = (int) entry.getKey();
						Occur = (int) entry.getValue();
					}
					list.put(Col, (Occur+1));
					CH.putColumnHash(Segment[i], list);
				}
			}
		}
		CHT.putColumnHashTable(CH, colM);
		return CHT;
	}
	
	public ColumnHashTable RemoveCT(ColumnHashTable CHT , int fmin)
	{
		int colM = CHT.getColumnHashTablec();
		ColumnHash CH = CHT.getColumnHashTableC();
		HashMap<String, HashMap<Integer, Integer>> list = CH.getColumnHash();
		CHT.removeColumnHashTable(CH);
		java.util.Iterator it = list.entrySet().iterator();
		while(it.hasNext()){
			java.util.Map.Entry entry = (java.util.Map.Entry)it.next();
			String Segment = (String) entry.getKey();
			HashMap<Integer, Integer> CO= (HashMap<Integer, Integer>) entry.getValue();
			java.util.Iterator it1 = CO.entrySet().iterator();
			java.util.Map.Entry entry1 = (java.util.Map.Entry)it1.next();
			int Col = (int) entry.getKey();
			int Occur = (int) entry.getValue();
			if (Occur < fmin)
			{
				CH.removeColumnHash(Segment);
				colM = colM - 1;
			}
		}
		CHT.putColumnHashTable(CH, colM);
		return CHT;
	}
	
	public void BuildMST()
	{
		
	}
}