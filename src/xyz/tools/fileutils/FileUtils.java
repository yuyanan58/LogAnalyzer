package xyz.tools.fileutils;

import java.io.File;

public class FileUtils {
	public static String[] ListDirectory(File dir){
		if(dir.exists() == false){
			throw new IllegalArgumentException("file:" + dir + " is not exit") ;
		}
		if(dir.isDirectory() == false){
			throw new IllegalArgumentException("file:" + dir + " is not a directory") ;
		}
		String[] filesNames = dir.list() ;
		for (String string : filesNames) {
			System.out.println(string);
		}
		return filesNames;
	}
}
