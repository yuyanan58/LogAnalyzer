package xyz.tools.analyzer2events;

import java.io.FileNotFoundException;
import java.util.Arrays;

import xyz.controller.analyzer.Analyzer;
import xyz.tools.analyzer2events.Analyzer2eventList.Event_li;

public class Analyzer2eventsTest {
	public static void main(String[] args) {
		String pathString = "L:/codesoft/Tomcat/apache-tomcat-7.0.68/webapps/dreaming/logFiles/a.log";
		try {
			Event_li[] aEvent_li = Analyzer2eventList.analyzer2NAMEString(new Analyzer(pathString));
			System.out.println(Arrays.toString(aEvent_li));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}
