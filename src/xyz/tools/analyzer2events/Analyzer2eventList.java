package xyz.tools.analyzer2events;

import java.util.Arrays;
import java.util.HashMap;
import xyz.controller.analyzer.Analyzer;
import xyz.model.event.Event;

public class Analyzer2eventList {
	private static final boolean DEBUG = false;
	
	public static class Event_li implements Comparable{
		public String name ;
		public int cnt ;
		@Override
		public int compareTo(Object o) {
			Event_li t = (Event_li)o ;
			return this.cnt < t.cnt ? 1 : -1 ;
		}
		@Override
		public String toString() {
			return "[" + name + ", " + cnt + "]";
		}
	}
	public static Event_li[] analyzer2NAMEString(Analyzer analyzer) {
		HashMap<String, Integer> event_map = new HashMap<>();
		for(Event event:analyzer.getEvents()){
			String tString = event.getEventType() ;
			if(event_map.get(tString) == null){
				event_map.put(tString, 1);
			}else{
				event_map.put(tString, event_map.get(tString) + 1);
			}
		}
		
		Event_li[] temp = new Event_li[event_map.size()];
		int ind_temp = 0 ;
		for(String key:event_map.keySet()){
			temp[ind_temp] = new Event_li(); 
			temp[ind_temp].name = key ;
			temp[ind_temp].cnt  = event_map.get(key) ;
			ind_temp ++ ;
		}
		Arrays.sort(temp) ;
		if(DEBUG) {
			System.out.println(Arrays.toString(temp));
		}
		return temp;
	}
}
