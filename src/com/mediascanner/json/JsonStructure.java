package com.mediascanner.json;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import com.mediascanner.SearchResult;

public class JsonStructure {
	private JSONArray ja = null;
	private ArrayList<SearchResult> results;
	
	public void parseJson(String jsonString ) {
		JSONObject tempMain = new JSONObject(jsonString);
		results = new ArrayList<SearchResult>();
		ja = tempMain.getJSONArray("Search");
		for (int res=0; res<ja.length();res++){
			SearchResult result = new SearchResult();
			result.setDate(ja.getJSONObject(res).getString("Year"));
			result.setTitle(ja.getJSONObject(res).getString("Title"));
			result.setType(ja.getJSONObject(res).getString("Type"));
			result.setImdbId(ja.getJSONObject(res).getString("imdbID"));
			
			results.add(result);
		}
		
		System.out.println(results.toString());
	}
	
	public ArrayList<SearchResult> getResultsArray(){
		return results;
	}
	
	//private VideoDetails getVideoDetailsFromJson(JSONObject json){
		
	//}
	
}