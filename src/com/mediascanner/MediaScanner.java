/**
 * 
 */
package com.mediascanner;

import com.mediascanner.database.Database;
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
		omdb.Search("wire");
		omdb.imdbDetailRetrival("tt0306414");
		
		Database db = new Database();
		db.isExtensionValid("mkv");
		
		//System.out.println(omdbSearchResults);
	}
}
