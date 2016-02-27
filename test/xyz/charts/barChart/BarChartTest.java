package xyz.charts.barChart;

import xyz.charts.bar.BarChart;

public class BarChartTest {
	public static void main(String[] args) {
		String string = BarChart.getBarChartJSON("a");
		System.out.println(string);
	}
}
