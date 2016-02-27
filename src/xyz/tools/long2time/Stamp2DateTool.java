package xyz.tools.long2time;

import java.text.SimpleDateFormat;

public class Stamp2DateTool {
	public static String Stamp2Date(long t){
		SimpleDateFormat format =  new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
	    Long time = t ;
	    String res = format.format(time);
	    return res ;
	}
}
