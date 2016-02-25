package xyz.model;

import java.io.File;

import logtree.main;

/**
 * LogFile 类，所有的日志文件都是该类的一个对象。
 * @author onion
 *
 */
public class LogFile {
	private String path ;
	private File file ;	

	public LogFile(){
		this.path = "/dreaming/logFiles/c.log" ;
		file = new File(this.path) ;
	}
	/**
	 * LogFile 的有参构造方法。
	 * @param path 是一个日志文件的路径。
	 */
	public LogFile(String path){
		this.path = path ;
		file = new File(this.path) ;
	}
	
	/*BEGIN:GET & SET*/
	public String getPath() { return path; }
	public void setPath(String path) { this.path = path; }
	public File getFile() { return file; }
	public void setFile(File file) { this.file = file; }
}
