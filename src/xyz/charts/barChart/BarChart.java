package xyz.charts.barChart;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import xyz.model.LogFile;

public class BarChart{
	private static final boolean DEBUG = false ; 
	
	public static String getBarChartJSON(String path){
		String jsonString = LogPath2JsonString(new LogFile(path)) ;
		return jsonString ;
	}
		
	private static String LogPath2JsonString(LogFile logFile) {
		//logFile = new LogFile(this.path) ;
		{
			;
		}
		JSONObject jsonObject = LogFile2JsonObject() ;
		return jsonObject.toString();
	}
	private static JSONObject LogFile2JsonObject() {
		JSONObject res = new JSONObject() ;
		{
			JSONArray series = new JSONArray() ;
			{
				JSONObject gao = new JSONObject() ; 
				{
					gao.put("name", "I am name 哈哈");
					gao.put("type", "pie") ;
					gao.put("radius", "55%");
					JSONArray data = new JSONArray() ;
					{
						String[] value = {"235", "274", "310", "335","400"};
						String[] names  = {"视频广告", "联盟广告","邮件营销","直接访问","搜索引擎"};
						for(int i = 0 ; i < 5 ; i ++){
							int ind_data = 0 ;
							JSONObject foo = new JSONObject() ;
							{
								foo.put("value", value[i]) ;
								foo.put("name",  names[i]) ;
							}
							data.add(ind_data ++, foo);
						}
					}
					gao.put("data", data) ;
				}
				series.add(0 , gao) ;
			}
			res.put("series", series);
		}
		return res ;
	}
}





