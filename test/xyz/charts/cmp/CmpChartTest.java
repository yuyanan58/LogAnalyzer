package xyz.charts.cmp;

public class CmpChartTest {
	public static void main(String[] args) {
		String path = "L:/codesoft/Tomcat/apache-tomcat-7.0.68/webapps/dreaming/logFiles/a.log";
		CmpChart chart = new CmpChart(path, 1, 2);
		System.out.println(chart.getCmpStr());
	}
}
