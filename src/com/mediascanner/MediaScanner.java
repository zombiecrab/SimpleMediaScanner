/**
 * 
 */
package com.mediascanner;

import com.mediascanner.databaseAPIs.OMDB;

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
		
		//System.out.println(omdbSearchResults);
	}
}
