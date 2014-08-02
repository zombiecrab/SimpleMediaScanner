package com.mediascanner.filescanner;

import java.nio.file.Path;

public class FileStruct {
	
	private Path path = null;
	private String fileName = null;
	private String extension = null;
	private String parentFolderName = null;
	private String fullPath = null;

	public FileStruct(Path path) {
		this.fileName = path.getFileName().toString();
		
		String[] filenameSplit = this.fileName.split("\\.");
		this.extension = filenameSplit[filenameSplit.length-1];
		
		this.parentFolderName = path.getName(path.getNameCount()-2).toString();
		
		this.fullPath = path.toString();
		
		this.path = path;		
	}
	
	@Override
	public String toString(){
		StringBuilder s = new StringBuilder();
		
		s.append("\nFile Name: "+fileName+"\n");
		s.append("Extension: "+extension+"\n");
		s.append("Parent Folder Name: "+parentFolderName+"\n");
		s.append("Full Path: "+fullPath+"\n");
		
		return s.toString();
	}

	public Path getPath() {
		return path;
	}

	public void setPath(Path path) {
		this.path = path;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public String getParentFolderName() {
		return parentFolderName;
	}

	public void setParentFolderName(String parentFolderName) {
		this.parentFolderName = parentFolderName;
	}

	public String getFullPath() {
		return fullPath;
	}

	public void setFullPath(String fullPath) {
		this.fullPath = fullPath;
	}

}
