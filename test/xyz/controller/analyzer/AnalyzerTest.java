package xyz.controller.analyzer;

import java.io.FileNotFoundException;
import java.util.LinkedList;

import xyz.model.event.Event;
import antlr.collections.List;

public class AnalyzerTest {
	public static void main(String[] args) throws FileNotFoundException {
		String pathString = "L:/codesoft/Tomcat/apache-tomcat-7.0.68/webapps/dreaming/logFiles/a.log";
		Analyzer analyzer = new Analyzer(pathString);
		LinkedList<Event> eventList = null ;
		eventList =	new LinkedList<Event>();
		eventList = (LinkedList<Event>) analyzer.getEvents() ;
		for(Event event : analyzer.getEvents()){
			System.out.println(event.toString());
		}
	}
}
