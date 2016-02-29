package xyz.tools.fileutils;

import java.io.File;

public class FileutilsTEST {
	public static void main(String[] args) {
		String path = "L:/codesoft/Tomcat/apache-tomcat-7.0.68/webapps/dreaming/logFiles/";
		FileUtils.ListDirectory(new File(path));
	}
}
