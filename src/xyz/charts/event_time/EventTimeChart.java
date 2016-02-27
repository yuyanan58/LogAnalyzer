package xyz.charts.event_time;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import xyz.controller.analyzer.Analyzer;
import xyz.model.event.Event;
import xyz.tools.long2time.Stamp2DateTool;

public class EventTimeChart {
	private static final boolean DEBUG = false ;
	private String eventTimeStr = null ;
	private long timeLang = 0 ;
	
	public void setTimeLang(long timeLang) {
		this.timeLang = timeLang;
	}
	public String getEventTimeStr() {
		return eventTimeStr;
	}

	public EventTimeChart(String path) {
		try{
			this.eventTimeStr = doPath2Str(new Analyzer(path));
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}
	}

	private String doPath2Str(Analyzer analyzer) {
		HashMap<Long, Integer> timeCntHashMap = new HashMap<>();
		for(Event event : analyzer.getEvents()){
			long time = event.getTimeStamp() ;
			if(timeCntHashMap.get(time) == null){
				timeCntHashMap.put(time, 1) ;
			}else {
				timeCntHashMap.put(time, timeCntHashMap.get(time) + 1) ;
			}
		}
		String resString = map2String(timeCntHashMap);
		return resString;
	}
	
	private static class WangDaChui implements Comparable{
		long date ;
		int data ;
		@Override
		public int compareTo(Object o) {
			WangDaChui w = (WangDaChui) o ;
			if(this.date < w.date){
				return -1 ;
			}else{
				return 1 ;
			}
		}
		@Override
		public String toString() {
			return "[" + Stamp2DateTool.Stamp2Date(this.date) + ", " + data + "]\r\n";
		}
	}
	
	private String map2String(HashMap<Long, Integer> timeCntHashMap) {
		int cnt = timeCntHashMap.size() ;
		WangDaChui[] wangDaChuis = new WangDaChui[cnt] ;
		for(int i = 0 ; i < cnt ; i ++) wangDaChuis[i] = new WangDaChui() ;
		int ind_wangdachui = 0 ;
		for(long l : timeCntHashMap.keySet()){
			wangDaChuis[ind_wangdachui].date = l ;
			wangDaChuis[ind_wangdachui].data = timeCntHashMap.get(l) ;
			ind_wangdachui ++ ;
		}
		
		Arrays.sort(wangDaChuis);
		
		if(DEBUG){
			System.out.println(Arrays.toString(wangDaChuis));
		}
		
		int max = - 1; 
		JSONObject resJsonObject = new JSONObject() ;
		{
			JSONArray dataArray = new JSONArray() ;
			JSONArray dateArray = new JSONArray() ;
			for(int i = 0 ; i < wangDaChuis.length ; i ++){
				dataArray.add(i, wangDaChuis[i].data);
				dateArray.add(i, Stamp2DateTool.Stamp2Date(wangDaChuis[i].date));
				max = Math.max(max, wangDaChuis[i].data);
			}
			max *= 1.05 ;
			resJsonObject.put("data", dataArray) ;
			resJsonObject.put("date", dateArray) ;
			resJsonObject.put("max", max);
		}
		return resJsonObject.toString();
	}
}














