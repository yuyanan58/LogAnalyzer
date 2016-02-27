package xyz.charts.bar;

import xyz.charts.bar.BarChart;

public class BarChartTest {
	public static void main(String[] args) {
		String path = "L:/codesoft/Tomcat/apache-tomcat-7.0.68/webapps/dreaming/logFiles/a.log";
		BarChart bar = new BarChart(path);
		System.out.println(bar.getBarChartStr());
	}
}
