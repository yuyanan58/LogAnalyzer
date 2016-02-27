package xyz.controller.analyzer;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.JSONArray;

import xyz.model.LogFile;
import xyz.model.event.DevPeriodic;
import xyz.model.event.Event;
import xyz.model.event.EventType;

public class Analyzer {
	private List<Event> events;
	private List<EventType> eventTypes;
	private List<DevPeriodic> DevPs;
	private static final boolean DEBUG = true ;

	
	public List<Event> getEvents() {
		return events;
	}
	public List<EventType> getEventTypes() {
		return eventTypes;
	}
	public List<DevPeriodic> getDevPs() {
		return DevPs;
	}
	public Analyzer(LogFile logFile) throws FileNotFoundException{
		String pathString = logFile.getPath() ;
		AnalyseRE(pathString);
	}
	public Analyzer(String logFilePath) throws FileNotFoundException{
		String pathString = logFilePath ;
		AnalyseRE(pathString);
	}
	/*
	 * 下面是私有方法 
	 */
	/**
	 * @param str
	 * @param type
	 * @return
	 */
	private long getTimeStamp(String str, int type){
		String pat = "";
		if(type==1){
			pat = "MMM dd yyyy HH:mm:ss";
		}else{
			pat = "yyyy-MM-dd HH:mm:ss.SSS";
		}
		SimpleDateFormat sdf = new SimpleDateFormat(pat, Locale.US);
		Date dt = new Date();
		try {
			dt = sdf.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return dt.getTime();
	}
	
	private String getEventType(String str){
		int x = str.indexOf("[");
		if(x == -1)
			return str;
		return str.substring(0, x);
	}
	
	private void AnalyseRE(String log_path) throws FileNotFoundException{
		Scanner fs = new Scanner(new File(log_path));
		final String r1 = "^([A-Z][a-z]{1,2}\\s+\\d{1,2}\\s+\\d{4}\\s+\\d\\d:\\d\\d:\\d\\d)\\s+([A-Za-z\\-0-9]+)\\s+(.+(?=\\/)\\/)(.+(?=:)):(.+(?=\\s\\())\\s(\\(.+\\))$";
		final String r2 = "^([A-Z][a-z]{1,3}\\s+\\d{1,2}\\s+\\d{4}\\s+\\d\\d:\\d\\d:\\d\\d)\\s+([A-Za-z\\-0-9]+)\\s+(.+(?=\\/)\\/)(.+(?=:)):(.+)$";
		boolean flag = false;
		boolean getDevInfo=false;
		DevPeriodic dp = new DevPeriodic();
		Event eTmp = new Event();
		String Dev_Type = "UNKNOW_DEV_TYPE";
		JSONArray jsonArr1 = new JSONArray();
		JSONArray jsonArr2 = new JSONArray();
		Hashtable<String, String> dict = new Hashtable<String, String>();
		this.events = new LinkedList<Event>();
		this.DevPs = new LinkedList<DevPeriodic>();
		this.eventTypes = new LinkedList<EventType>();
		
		while(fs.hasNext()){
			String line = fs.nextLine();
			if(line.length()==0) continue;
			Pattern p1 =  Pattern.compile(r1);
			Matcher m1 = p1.matcher(line);
			Pattern p2 = Pattern.compile(r2);
			Matcher m2 = p2.matcher(line);
			
			if(m1.find()){
				Event e = new Event();
				e.setTimeStamp(getTimeStamp(m1.group(1), 1));
				e.setDevType(m1.group(2));
				e.setBala(m1.group(3));
				e.setEventType(getEventType(m1.group(4)));
				dict.put(getEventType(m1.group(4)), m1.group(5));
				e.setExtraInfo(m1.group(6));
				
				Dev_Type = e.getDevType();
				
				this.events.add(e);
			}else if(m2.find()){
				Event e = new Event();
				e.setTimeStamp(getTimeStamp(m2.group(1), 1));
				e.setDevType(m2.group(2));
				Dev_Type = e.getDevType();
				e.setBala(m2.group(3));
				e.setEventType(getEventType(m2.group(4)));
				dict.put(getEventType(m2.group(4)), m2.group(5));
				e.setExtraInfo("()");
				this.events.add(e);
			}else{
				if(line.matches("^#+$")){
					flag = !flag;
					if(flag){
						dp = new DevPeriodic();
						eTmp = new Event();
						jsonArr2 = new JSONArray();
						dp.setDevType(Dev_Type);
						eTmp.setDevType(Dev_Type);
						eTmp.setEventType("INFO_COLLECT");
					}else{
						if(getDevInfo==false){
							dict.put("INFO_COLLECT", jsonArr1.toString());
						}
						getDevInfo = true;
						dp.setInfo(jsonArr2.toString());
						this.DevPs.add(dp);
						this.events.add(eTmp);
					}
				}
				if(flag){
					if(line.matches("^#DateTime.+$")){
						String date_str = line.substring(line.indexOf(": ")+2);
						dp.setTimeStamp(getTimeStamp(date_str, 0));
						eTmp.setTimeStamp(dp.getTimeStamp());
					}else if(line.matches("^\\d+.+$")){
						String[] arr = line.split("( )+");
						int len = arr.length;
						HashMap<String, String> hm1 = new HashMap<String, String>();
						hm1.put(arr[0], arr[1]);
						jsonArr1.put(hm1);
						
						HashMap<String, String> hm2 = new HashMap<String, String>();
						hm2.put("CPU Usage", arr[len-3]);
						hm2.put("MPU Usage (Used/Total)", arr[len-2]+" "+arr[len-1]);
						jsonArr2.put(hm2);
						
					}
				}
				
			}
		}
		for(Iterator iter = dict.keySet().iterator();iter.hasNext();){
			String key = (String)iter.next();
			EventType et = new EventType(key, dict.get(key));
			this.eventTypes.add(et);
		}
		fs.close();
	}
}
