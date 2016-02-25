package xyz.model;

import java.io.File;

import logtree.main;

/**
 * LogFile �࣬���е���־�ļ����Ǹ����һ������
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
	 * LogFile ���вι��췽����
	 * @param path ��һ����־�ļ���·����
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
