package xyz.charts.pie;

public class PieChartTest {
	public static void main(String[] args) {
		String path = "L:/codesoft/Tomcat/apache-tomcat-7.0.68/webapps/dreaming/logFiles/a.log";
		PieChart pieChart = new PieChart(path) ;
		System.out.println(pieChart.getPieStr());
	}
}
