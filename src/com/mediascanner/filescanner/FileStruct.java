package com.mediascanner.filescanner;

import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileStruct {
	
	private Path path = null;
	private String fileName = null;
	private String extension = null;
	private String parentFolderName = null;
	private String fullPath = null;
	private String cleanTitle = null;
	private String episodeNumber = null;

	public FileStruct(Path path) {
		this.fileName = path.getFileName().toString();
		
		String[] filenameSplit = this.fileName.split("\\.");
		this.extension = filenameSplit[filenameSplit.length-1];
		
		this.parentFolderName = path.getName(path.getNameCount()-2).toString();
		
		this.fullPath = path.toString();
		
		this.path = path;		
	}
	
	public void cleanUpFilename(){
		Pattern s00e00Match = Pattern.compile("[Ss]..[Ee]..");
		Pattern yearMatch = Pattern.compile("[1900-2050]");
		
		Matcher episodeNumber = s00e00Match.matcher(fileName);
		if (episodeNumber.find()){
			cleanTitle = fileName.substring(0, episodeNumber.start()-1);
			this.episodeNumber = episodeNumber.group();
		}
		
		if (cleanTitle != null){
			Matcher year = yearMatch.matcher(cleanTitle);
			if (year.find()){
				cleanTitle = cleanTitle.substring(0, year.start()-1);
			}
		} else {
			Matcher year = yearMatch.matcher(fileName);
			if (year.find()){
				cleanTitle = fileName.substring(0, year.start()-1);
			}
		}
		
	}
	
	@Override
	public String toString(){
		StringBuilder s = new StringBuilder();
		
		s.append("\nFile Name: "+fileName+"\n");
		s.append("Extension: "+extension+"\n");
		s.append("Parent Folder Name: "+parentFolderName+"\n");
		s.append("Full Path: "+fullPath+"\n");
		s.append("Clean title: "+cleanTitle+"\n");
		
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

	public String getCleanTitle() {
		return cleanTitle;
	}

	public void setCleanTitle(String cleanTitle) {
		this.cleanTitle = cleanTitle;
	}

}
