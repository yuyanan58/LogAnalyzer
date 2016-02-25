package LogTree;

import java.util.HashMap;

public class ColumnHashTable {

	private HashMap<ColumnHash , Integer> ColumnHashTable;      

	public ColumnHashTable(HashMap<ColumnHash , Integer> ColumnHashTable) {

		this.ColumnHashTable=ColumnHashTable;
	}
	
	public ColumnHash getColumnHashTableC() {
		java.util.Iterator it = ColumnHashTable.entrySet().iterator();
		int colM = 0;
		ColumnHash CH = new ColumnHash(null);
		while(it.hasNext()){
			java.util.Map.Entry entry = (java.util.Map.Entry)it.next();
			CH = (ColumnHash) entry.getKey();
			colM = (int) entry.getValue();
		}
		return CH;
	}

	public int getColumnHashTablec() {
		java.util.Iterator it = ColumnHashTable.entrySet().iterator();
		int colM = 0;
		ColumnHash CH = new ColumnHash(null);
		while(it.hasNext()){
			java.util.Map.Entry entry = (java.util.Map.Entry)it.next();
			CH = (ColumnHash) entry.getKey();
			colM = (int) entry.getValue();
		}
		return colM;
	}
	
	public void setHashMapList(HashMap<ColumnHash , Integer> ColumnHashTable) {
		this.ColumnHashTable = ColumnHashTable;
	}
	
	public void putColumnHashTable(ColumnHash CH , int colM) {
		this.ColumnHashTable.put(CH, colM);	
	}
	
	public void removeColumnHashTable(ColumnHash CH) {
		this.ColumnHashTable.remove(CH);
	}
}