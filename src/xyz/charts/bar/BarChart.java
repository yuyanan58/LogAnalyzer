package xyz.charts.bar;

import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import antlr.collections.List;
import xyz.controller.analyzer.Analyzer;
import xyz.model.event.Event;

/**
 * timeStamp & eventType
 * @author onion
 *
 */
public class BarChart {
	private String barChartStr = null;
	private int event_num = 7 ;
	private static final long day_length = 24 * 60 * 60 ;
	private static final boolean DEBUG = false ;
	
	public String getBarChartStr() {
		return barChartStr;
	}
	
	public BarChart(String path){
		try {
			this.barChartStr = doPath2Str(new Analyzer(path));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private static class Event_li implements Comparable{
		String name ;
		int cnt ;
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
	
	private String doPath2Str(Analyzer analyzer) {
		
		String[] NAME_data = map2NAMEString(analyzer);
		String[] day_data  = map2DAYSString(analyzer) ;
		if(DEBUG){
			System.out.println("NAME_data = " + Arrays.toString(NAME_data));
			System.out.println("day_data = " + Arrays.toString(day_data));
		}
		
		JSONObject res = new JSONObject();
		{
			
			int MAX_data = - 1;
			
			JSONArray NAME_dataJArray = new JSONArray() ;
			{
				for(int i = 0 ; i < NAME_data.length ; i ++){
					NAME_dataJArray.add(i,	NAME_data[i]);
				}
			}
			res.put("NAME_data", NAME_dataJArray);
			
			JSONArray X_data = new JSONArray();
			{
				for(int i = 0 ; i < day_data.length ; i ++){
					X_data.add(i, day_data[i]);
				}
			}
			res.put("X_data", X_data) ;
			
			
			JSONArray aLL_data = new JSONArray();
			{
				for(int i = 0 ; i < NAME_data.length - 1 ; i ++){
					JSONObject temp = new JSONObject();
					{
						temp.put("name", NAME_data[i]);
						temp.put("type", "bar");
						JSONArray data = new JSONArray() ;
						{	
							for(int j = 0 ; j < day_data.length ; j ++){
								int cnt = 0 ;
								for (Event event : analyzer.getEvents()) {
									if( NAME_data[i].equals(event.getEventType()) &&
										gao(event.getTimeStamp()).equals(day_data[j]) ){
										cnt ++ ;
									}
								}
								MAX_data=Math.max(cnt, MAX_data);
								data.add(j, cnt);
							}
						}
						temp.put("data", data);
					}
					aLL_data.add(temp);
				}
				JSONObject temp = new JSONObject();
				{
					temp.put("name", "other");
					temp.put("type", "bar");
					JSONArray data = new JSONArray();
					{
						for(int j = 0 ; j < day_data.length ; j ++){
							int cnt = 0 ; 
							for(Event event : analyzer.getEvents()){
								if(gao(event.getTimeStamp()).equals(day_data[j])){
									String str = event.getEventType() ;
									boolean exit = false;
									for(int k = 0 ; k < NAME_data.length ; k ++){
										if(str.equals(NAME_data[k]) ){
											exit = true ;
											break ;
										} 
									}
									if(exit == false){
										cnt ++ ;
									}
								}
							}
							MAX_data=Math.max(cnt, MAX_data);
							data.add(j, cnt);
						}
					}
					temp.put("data", data);
				}
				aLL_data.add(temp);
			}
			res.put("ALL_data", aLL_data);
			res.put("MAX_data", MAX_data * 1.1);
		}
		return res.toString() ;
	}

	private static String gao(long l){
		SimpleDateFormat format =  new SimpleDateFormat( "yyyy-MM-dd" );
		String tim = format.format(l) ;
		return tim;
	}
	
	private static class DayCnt implements Comparable{
		String x_data ;
		long t ;
		@Override
		public int compareTo(Object o) {
			DayCnt t = (DayCnt)o;
			return this.t < t.t ? -1 : 1;
		}
		@Override
		public String toString() {
			return "[" + x_data + ", " + t + "]";
		}
		
	}
	private String[] map2DAYSString(Analyzer analyzer) {
		HashMap<String, Long> day_exit = new HashMap<>();
		for (Event event : analyzer.getEvents()) {
			long t = event.getTimeStamp() ;
			String tim = gao(t) ;
			if( day_exit.get(tim) == null ){
				day_exit.put(tim, t);
			}
		}
		DayCnt[] dayCnts = new DayCnt[day_exit.size()] ;
		int ind_dayCnts = 0 ;
		for(String key : day_exit.keySet()){
			dayCnts[ind_dayCnts] = new DayCnt() ;
			dayCnts[ind_dayCnts].x_data = key ;
			dayCnts[ind_dayCnts].t = day_exit.get(key);
			ind_dayCnts ++ ;
		}
		
		Arrays.sort(dayCnts);
		String[] resStrings = new String[day_exit.size()];
		for(int i = 0 ; i < dayCnts.length ; i ++){
			resStrings[i] = dayCnts[i].x_data ;
		}
		return resStrings;
	}

	private String[] map2NAMEString(Analyzer analyzer) {
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
		/**
		 * 所有要展示的事件类型。
		 */
		String[] name_date = new String[event_num] ;
		for(int i = 0 ; i < event_num - 1 ; i ++){
			name_date[i] = temp[i].name ;
		}
		name_date[event_num - 1] = "other";
		return name_date;
	}
}