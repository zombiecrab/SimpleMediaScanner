/**
 * 
 */
package com.mediascanner.databaseAPIs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import com.mediascanner.json.JsonStructure;

/**
 * @author Alex Wood
 *
 */
public class OMDB extends JsonStructure{
	
	private String searchContentString = null;
	
	public OMDB() {
		// TODO Auto-generated constructor stub
	}

	public void Search (String searchTerm) {
		try {
			URL omdbUrl = new URL("http://www.omdbapi.com/?s="+searchTerm);
			URLConnection omdbCon = omdbUrl.openConnection();
			BufferedReader omdbBuff = new BufferedReader(new InputStreamReader(omdbCon.getInputStream()));	
			
			if ((searchContentString = omdbBuff.readLine()) == null){
				System.out.println("No results found on OMDB.");
			}
			omdbBuff.close();
		} catch (MalformedURLException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}
		
		if (searchContentString != null) {
			parseJson(searchContentString);
		}
	}	
}
