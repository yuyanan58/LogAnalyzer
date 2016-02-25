package test.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class OutPutFile {
	public static void OutPutAFile(File file2) {
		try {
			Scanner cin = new Scanner(file2);
			while(cin.hasNext()){
				System.out.println(cin.nextLine());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
