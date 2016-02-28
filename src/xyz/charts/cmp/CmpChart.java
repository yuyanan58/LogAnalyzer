package xyz.charts.cmp;

import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.LinkedList;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import xyz.controller.analyzer.Analyzer;
import xyz.model.event.Event;
import xyz.tools.analyzer2events.Analyzer2eventList;
import xyz.tools.analyzer2events.Analyzer2eventList.Event_li;

public class CmpChart {
	private final SimpleDateFormat format = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
	private static final boolean DEBUG = false ;
	private String cmpStr = null ;
	private int ind1 = 0 ;
	private int ind2 = 1 ;
	public String getCmpStr(){
		return this.cmpStr;
	}
	public CmpChart(String path , int ind1 , int ind2){
		try {
			this.ind1 = ind1 ;
			this.ind2 = ind2 ;
			this.cmpStr = path2Str(new Analyzer(path));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	private class CmpCharJson{
		long[] time_tmp ;
		LinkedList<Integer> data1 ;
		LinkedList<Integer> data2 ;
		String   data1_name ;
		String	 data2_name ;
		int 	 data1_max  = -1;
		int      data2_max  = -1 ;
	}
	private String path2Str(Analyzer analyzer) {
		Event_li[] event_li = Analyzer2eventList.analyzer2NAMEString(analyzer);
		CmpCharJson res = new CmpCharJson();
		res.data1_name = event_li[ind1].name ;
		res.data2_name = event_li[ind2].name ;
		res.time_tmp  = analyzer2eve1eve2(analyzer , res.data1_name , res.data2_name);	
		if(DEBUG){
			System.out.println("length = " + res.time_tmp.length);
		}
		int ind_time_tmp = 0;
		
		res.data1 = new LinkedList<>() ;
		res.data2 = new LinkedList<>() ;
		
		for(int i = 0 ; i < analyzer.getEvents().size() && ind_time_tmp < res.time_tmp.length ; i ++){
			Event event = analyzer.getEvents().get(i);
			if( event.getTimeStamp() == res.time_tmp[ind_time_tmp] ){
				int r = i ;
				int l = r + 1 ;
				for( ; l < analyzer.getEvents().size() ; l ++){
					Event event2 = analyzer.getEvents().get(l) ;
					if(event2.getTimeStamp() > res.time_tmp[ind_time_tmp] ){
						break ;
					}else if(event2.getTimeStamp() < res.time_tmp[ind_time_tmp]){
						System.out.println("ERROR");
					}
				}
				int cnt1 = 0 ;
				int cnt2 = 0 ;
				for(int j = r ; j < l ; j ++){
					Event event2 = analyzer.getEvents().get(j) ;
					if( event2.getEventType().equals(res.data1_name) ){
						cnt1 ++ ;
					}
					if( event2.getEventType().equals(res.data2_name) ){
						cnt2 ++ ;
					}
				}
				res.data1_max = Math.max(res.data1_max, cnt1) ;
				res.data2_max = Math.max(res.data2_max, cnt2) ;				
				res.data1.add(cnt1) ;
				res.data2.add(cnt2) ;
				ind_time_tmp ++ ;
				i = l - 2 ;
			}
		}
		if(DEBUG){
			System.out.println("data1.l  = " + res.data1.size());
			System.out.println("data2.l  = " + res.data2.size());
			System.out.println("ind_leng = " + ind_time_tmp);
		}
		JSONObject resJsonObject = CmpCharJson2JS(res) ;
		return resJsonObject.toString() ;
	}
	
	private JSONObject CmpCharJson2JS(CmpCharJson res) {
		JSONObject ans = new JSONObject();
		{
			JSONArray time_dataArray = new JSONArray() ;
			{
				for(int i = 0 ; i < res.time_tmp.length ; i ++){
					time_dataArray.add(i, format.format(res.time_tmp[i]));
				}
			}
			ans.put("time_data", time_dataArray);
			
			JSONArray data1_data = new JSONArray();
			{
				for(int i = 0 ; i < res.data1.size() ; i ++){
					data1_data.add(i, res.data1.get(i));
				}
			}
			ans.put("data1_data", data1_data);
			
			JSONArray data2_data = new JSONArray();
			{
				for(int i = 0 ; i < res.data2.size() ; i ++){
					data2_data.add(i, res.data2.get(i));
				}
			}
			ans.put("data2_data", data2_data) ;
			ans.put("name0", res.data1_name);
			ans.put("name1", res.data2_name);
		}
		return ans;
	}
	
	private long[] analyzer2eve1eve2(Analyzer analyzer, String data1_name, String data2_name){
		LinkedList<Long> time = new LinkedList<>();
		for(Event event:analyzer.getEvents()){
			if( event.getEventType() . equals(data1_name) || event.getEventType() . equals(data2_name) ){
				time.add(event.getTimeStamp());
			}
		}
		long[] res = new long[time.size()];
		if(DEBUG){
			System.out.println("size = " + time.size());
		}
		for(int i = 0 ; i < time.size() ; i ++){
			res[i] = time.get(i);
		}
		return res;
	}
}










