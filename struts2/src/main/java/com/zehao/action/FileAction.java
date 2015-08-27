package com.zehao.action;

import java.io.File;

import org.apache.commons.io.FileUtils;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class FileAction extends ActionSupport {
	private File file;
	private String fileContentType;
	private String fileFileName;
	private String destPath = "C:\\work\\Java";

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub

		try {
			System.out.println("File name: " + file);
			System.out.println("fileFileName: " + fileFileName);
			System.out.println("Dst File name: " + fileContentType);
			File destFile = new File(destPath, fileFileName);
			FileUtils.copyFile(file, destFile);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("上传文件失败！");
			return Action.ERROR;
		}
		System.out.println("上传文件成功！");
		return Action.SUCCESS;

	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public String getDestPath() {
		return destPath;
	}

	public void setDestPath(String destPath) {
		this.destPath = destPath;
	}

}
