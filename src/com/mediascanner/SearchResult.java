package com.mediascanner;

public class SearchResult {
	private String title = null;
	private String date = null;
	private String[] genres = null;
	private String type = null;
	private String imdbId = null;
	
	public SearchResult (String title, String date, String[] genres){
		this.title = title;
		this.date = date;
		this.genres = genres;
	}
	
	public SearchResult () {
		
	}
	
	@Override 
	public String toString() {
		return "\nTitle: "+title+"\nData: "+date+"\nType: "+type+"\nIMDB ID: "+imdbId+"\n\n";
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String[] getGenres() {
		return genres;
	}

	public void setGenres(String[] genres) {
		this.genres = genres;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getImdbId() {
		return imdbId;
	}

	public void setImdbId(String imdbId) {
		this.imdbId = imdbId;
	}
}
