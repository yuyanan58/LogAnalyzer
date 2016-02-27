package xyz.charts.event_time;

public class EventTimeChartTest {
	public static void main(String[] args) {
		String path = "L:/codesoft/Tomcat/apache-tomcat-7.0.68/webapps/dreaming/logFiles/a.log";
		EventTimeChart eventTimeChart = new EventTimeChart(path) ;
		System.out.println(eventTimeChart.getEventTimeStr());
	}
}
