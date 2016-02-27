package xyz.charts.pie;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;

import xyz.controller.analyzer.Analyzer;
import xyz.model.event.Event;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class PieChart {
	private static final boolean DEBUG = false ;
	private String pieStr = null;
	
	public String getPieStr(){
		return this.pieStr ;
	}
	/**
	 * PieChart的构造方法，传入的参赛为一个文件的路径。执行 doPath2Str方法，
	 * 这个方法中传入Analyer对象，每次对Analyer对象的中分析的结果进行提取。
	 * 得到我们在PieChart中要的数据。
	 * @param path
	 */
	public PieChart(String path){
		try {
			this.pieStr = doPath2Str(new Analyzer(path));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	private String doPath2Str(Analyzer analyzer) {
		HashMap<String, Integer> eventCnt = new HashMap<>();
		for(Event event : analyzer.getEvents()){
			String eventType = event.getEventType() ;
			if( eventCnt.get(eventType) == null ){
				eventCnt.put(eventType, 1);
			}else{
				eventCnt.put(eventType, eventCnt.get(eventType) + 1);
			}
		}
		if(DEBUG){
			for (String key : eventCnt.keySet()) {
				System.out.println(key + " -> " + eventCnt.get(key));
			}
		}
		String resString = map2String(eventCnt) ;
		return resString;
	}
	
	private static class Event_cnt implements Comparable{
		String name ;
		int val ;
		
		@Override
		public String toString() {
			return "[" + name + ", " + val + "]";
		}

		@Override
		public int compareTo(Object o) {
			Event_cnt t = (Event_cnt)o ;
			if(this.val == t.val){
				return 0 ;
			}else if(this.val < t.val){
				return 1 ;
			}else{
				return -1 ;
			}
		}
	}
	
	private String map2String(HashMap<String, Integer> eventCnt) {
		int cnt = eventCnt.size();
		Event_cnt[] event_cnts = new Event_cnt[cnt] ;
		for(int i = 0 ; i < cnt ; i ++) event_cnts[i] = new Event_cnt() ;
		int ind_key = 0 ;
		for (String key : eventCnt.keySet()) {
			event_cnts[ind_key].name = key ;
			event_cnts[ind_key].val  = eventCnt.get(key);
			ind_key ++ ;
		}
		Arrays.sort(event_cnts);
		
		if(DEBUG){
			System.out.println(cnt);
			System.out.println(Arrays.toString(event_cnts));
		}
		
		final int other_cnt = 18 ;
		JSONObject resJsonObject = new JSONObject() ;
		{
			JSONArray data1 = new JSONArray() ;
			{
				for(int i = 0 ; i < other_cnt ; i ++){
					data1.add(i, event_cnts[i].name);
				}
				data1.add(other_cnt , "other event") ;
			}
			resJsonObject.put("data1", data1);
			
			JSONArray data2 = new JSONArray() ;
			{
				JSONObject tJsonObject = new JSONObject() ;				
				for(int i = 0 ; i < other_cnt ; i ++){
					tJsonObject.put("name", event_cnts[i].name);
					tJsonObject.put("value", event_cnts[i].val);
					data2.add(i, tJsonObject);
				}
				int other_sum = 0 ;
				for(int i = other_cnt ; i < event_cnts.length ; i ++){
					other_sum += event_cnts[i].val ;
				}
				tJsonObject.put("name", "other event");
				tJsonObject.put("value", other_sum);
				data2.add(other_cnt , tJsonObject);
			}
			resJsonObject.put("data2", data2);
		}
		if(DEBUG) System.out.println(resJsonObject.toString());
		return resJsonObject.toString();
	}	
}
