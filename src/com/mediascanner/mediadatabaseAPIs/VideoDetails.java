package com.mediascanner.mediadatabaseAPIs;

public class VideoDetails  {
	private String title = null;
	private String date = null;
	private String[] genres = null;
	private String plot = null;
	private String imageUrl = null;
	private String Released = null;
	private double imdbRating = 0.0;
	private String type = null;
	
	
	public VideoDetails () {
		
	}
	
	@Override 
	public String toString() {
		StringBuilder ret = new StringBuilder();
		ret.append("\nTitle: "+title+"\nData: "+date+"\nGenres: ");
		for(int i=0; i<genres.length;i++){
			if (i == genres.length -1){
				ret.append(genres[i]);
			} else {
				ret.append(genres[i]+", ");
			}
			
		}
		return ret.toString();
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

	public String getPlot() {
		return plot;
	}

	public void setPlot(String plot) {
		this.plot = plot;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getReleased() {
		return Released;
	}

	public void setReleased(String released) {
		Released = released;
	}

	public double getImdbRating() {
		return imdbRating;
	}

	public void setImdbRating(double imdbRating) {
		this.imdbRating = imdbRating;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	

}
