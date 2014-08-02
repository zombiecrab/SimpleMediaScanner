package com.mediascanner.filescanner;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import com.mediascanner.database.Database;

public class FileScanner {

	private DirectoryStream<Path> ds;
	private ArrayList<FileStruct> fileList;
	
	public FileScanner(String path, Database db) {
		fileList = new ArrayList<FileStruct>();
		FileStruct fileStruct = null;
		try {
			ds = Files.newDirectoryStream(Paths.get(path));
			for (Path p : ds){
				if (!(p.toFile().isDirectory())){
					fileStruct = new FileStruct(p);
					if (db.isExtensionValid(fileStruct.getExtension()) != null){
						//System.out.println("Found");
						fileStruct.cleanUpFilename();
						//System.out.println(fileStruct.getCleanTitle());
						fileList.add(fileStruct);
					}
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<FileStruct> getFileList() {
		return this.fileList;
	}
}
