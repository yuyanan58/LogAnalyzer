package LogTree;

import java.util.HashMap;

public class ColumnHash {

	private HashMap<String , HashMap<Integer , Integer>> ColumnHash;      

	public ColumnHash(HashMap<String , HashMap<Integer , Integer>> ColumnHash) {
		this.ColumnHash=ColumnHash;
	}
	
	public void putColumnHash(String Segment , HashMap<Integer , Integer> list) {
		this.ColumnHash.put(Segment, list);
	}
	
	public HashMap<String , HashMap<Integer , Integer>> getColumnHash() {
		return this.ColumnHash;
	}

	public HashMap<Integer , Integer> getColumnHashValue(String Segment) {
		return this.ColumnHash.get(Segment);
	}
	
	public void setColumnHash(HashMap<String , HashMap<Integer , Integer>> ColumnHash) {
		this.ColumnHash = ColumnHash;
	}
	
	public void removeColumnHash(String Segment) {
		this.ColumnHash.remove(Segment);
	}
	
	public boolean empty()
	{
		return this.ColumnHash.isEmpty();
	}
	
}
