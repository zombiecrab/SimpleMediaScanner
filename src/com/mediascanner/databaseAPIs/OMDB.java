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
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import com.mediascanner.SearchResult;
import com.mediascanner.VideoDetails;

/**
 * @author Alex Wood
 *
 */
public class OMDB{
	private JSONArray ja = null;
	private ArrayList<SearchResult> searchResults;
	
	
	public OMDB() {
		// TODO Auto-generated constructor stub
	}

	public void Search (String searchTerm) {
		String searchContentString = null;
		
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
			parseSearchResultJson(searchContentString);
		}
	}
	
	public VideoDetails imdbDetailRetrival(String imdbID){
		String searchContentString = null;
		
		try {
			URL omdbUrl = new URL("http://www.omdbapi.com/?i="+imdbID);
			URLConnection omdbCon = omdbUrl.openConnection();
			BufferedReader omdbBuff = new BufferedReader(new InputStreamReader(omdbCon.getInputStream()));	
			
			if ((searchContentString = omdbBuff.readLine()) == null){
				System.out.println("Imdb ID not found on OMDB.");
			}
			omdbBuff.close();
		} catch (MalformedURLException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}
		
		if (searchContentString != null) {
			return parseImdbSearchResultJson(searchContentString);
		} else {
			return null;
		}
		
	}
	
	public void parseSearchResultJson(String jsonString ) {
		JSONObject tempMain = new JSONObject(jsonString);
		searchResults = new ArrayList<SearchResult>();
		ja = tempMain.getJSONArray("Search");
		for (int res=0; res<ja.length();res++){
			SearchResult result = new SearchResult();
			result.setDate(ja.getJSONObject(res).getString("Year"));
			result.setTitle(ja.getJSONObject(res).getString("Title"));
			result.setType(ja.getJSONObject(res).getString("Type"));
			result.setImdbId(ja.getJSONObject(res).getString("imdbID"));
			
			searchResults.add(result);
		}
		
		System.out.println(searchResults.toString());
	}
	
	public VideoDetails parseImdbSearchResultJson(String jsonString ) {
		VideoDetails videoDetails = new VideoDetails();
		JSONObject videoJson = new JSONObject(jsonString);
		videoDetails.setTitle(videoJson.getString("Title"));
		videoDetails.setDate(videoJson.getString("Year"));
		videoDetails.setGenres(videoJson.getString("Genre").split(", "));
		videoDetails.setImageUrl(videoJson.getString("Poster"));
		videoDetails.setImdbRating(Double.parseDouble(videoJson.getString("imdbRating")));
		videoDetails.setPlot(videoJson.getString("Plot"));
		videoDetails.setReleased(videoJson.getString("Released"));
		videoDetails.setType(videoJson.getString("Type"));
		
		return videoDetails;
	}
}
