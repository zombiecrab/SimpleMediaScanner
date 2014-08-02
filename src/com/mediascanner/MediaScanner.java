/**
 * 
 */
package com.mediascanner;

import java.nio.file.DirectoryStream;
import java.nio.file.Path;
import java.util.ArrayList;

import com.mediascanner.database.Database;
import com.mediascanner.filescanner.FileScanner;
import com.mediascanner.filescanner.FileStruct;
import com.mediascanner.mediadatabaseAPIs.OMDB;

/**
 * @author Alex Wood
 *
 */
public class MediaScanner {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//new OMDB object
		OMDB omdb = new OMDB();
		//search for show. All results are stored in the object for now
		//omdb.Search("wire");
		//omdb.imdbDetailRetrival("tt0306414");
		
		Database db = new Database();
		//db.isExtensionValid("mkv");
		
		FileScanner fs = new FileScanner("C:\\Users\\alex\\Downloads", db);
		ArrayList<FileStruct> fileStructs = fs.getFileList();
		
		System.out.println(fileStructs.size());
		//for(int i=0; i< fileStructs.size();i++){
		for (FileStruct fileStruct : fileStructs) {
			System.out.println(fileStruct.toString());
			if (fileStruct.getCleanTitle() != null){
				omdb.Search(fileStruct.getCleanTitle());
			} else {
				omdb.Search(fileStruct.getFileName());
			}
			
		}

		
		//System.out.println(omdbSearchResults);
	}
}
