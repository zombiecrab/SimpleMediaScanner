package com.mediascanner;

public class VideoDetails {
	private String title = null;
	private String date = null;
	private String[] genres = null;
	
	public VideoDetails (String title, String date, String[] genres){
		this.title = title;
		this.date = date;
		this.genres = genres;
	}
	
	public VideoDetails () {
		
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
	
	

}
