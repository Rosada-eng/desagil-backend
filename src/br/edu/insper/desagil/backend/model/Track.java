package br.edu.insper.desagil.backend.model;

public class Track {
	private Artist artist;
	private String name;
	private int duration; // em seg
	
	public Track(Artist artist, String name, int duration) {
		super();
		this.artist = artist;
		this.name = name;
		this.duration = duration;
	}

	public Artist getArtist() {
		return artist;
	}

	public String getName() {
		return name;
	}

	public int getDuration() {
		return duration;
	}
	
	public String getDurationString() {
		String durationString;
		
		int min = 0;
		min = this.getDuration()/60;
		
		int seg = 00;				
		seg = this.getDuration() - 60*min; 		
		
		String segString = "";		
		if (seg < 10) {
			segString = "0" + Integer.toString(seg);
		}
		
		else {
			segString = Integer.toString(seg);
		}
		
		durationString = Integer.toString(min) + ":" + segString;		
		return durationString;
	}

	public String getFullArtistName() {
		String fullName = this.getArtist().getName();
		
		return fullName;
	}
}
