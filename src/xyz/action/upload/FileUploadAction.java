package xyz.action.upload;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class FileUploadAction extends ActionSupport {
	private static final boolean DEBUG = false ;
	private File upload;
	private String uploadContentType;
	private String uploadFileName;
	private String result;
	public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public String getUploadContentType() {
		return uploadContentType;
	}
	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}
	public String getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
	@Override
	public String execute() throws Exception {
		if(DEBUG){
			System.out.println("BIGNEWS : UPLOAD IS RUNING");
		}
		String path = ServletActionContext.getServletContext().getRealPath( "/logFiles");
		File file = new File(path);
		if (file.exists() == false) {
			file.mkdir();
		}
		FileUtils.copyFile(upload, new File(file, uploadFileName));
		result = "上传成功";
		return SUCCESS;
	}
}
