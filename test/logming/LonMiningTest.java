package logming;

public class LonMiningTest {
	public static void main(String[] args) {
		LogMining logMining2 = new LogMining("L:/codesoft/Tomcat/apache-tomcat-7.0.68/webapps/dreaming/logFiles/a.log");
		String[] t = logMining2.getLogMiningString() ;
		for(int i = 0 ; i < t.length ; i ++){
			System.out.println(t[i]);
		}
	}
}
