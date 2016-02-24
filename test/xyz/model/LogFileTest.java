package xyz.model;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class LogFileTest {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws FileNotFoundException {
		LogFile logFile = new LogFile();
		Scanner cin = new Scanner(logFile.getFile()) ;
		while(cin.hasNext()){
			System.out.println(cin.nextLine());
		}
	}
}
