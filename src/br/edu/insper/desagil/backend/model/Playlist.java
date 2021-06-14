package br.edu.insper.desagil.backend.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Playlist {
	private int id;
	private List<Track> tracks;
	private Map<String, Integer> ratings;
	
	
	public Playlist(int id) {
		super();
		this.id = id;
		this.tracks = new ArrayList<>();
		this.ratings = new HashMap<>();
	}
	
	
	public int getId() {
		return id;
	}

	public List<Track> getTracks() {
		return tracks;
	}

	public Map<String, Integer> getRatings() {
		return ratings;
	}
	
	public void addTrack(Track track) {
		this.tracks.add(track);
	}
	
	public void putRating(String nome, int avaliacao) {
		this.ratings.put(nome, avaliacao);
	}
	
	public double averageRatings() {
		double media = 0.00;
		
		int soma = 0;
		
		for (int rating : this.ratings.values()) {
			soma += rating;
		}
		
		media = (double) soma/this.ratings.size();
		
		int mediaInteira = (int) media;
		double mediaFracionaria = media - mediaInteira;
		
		if (mediaFracionaria < 0.26) {
			mediaFracionaria = 0.0;
		} 
		
		else if (mediaFracionaria > 0.26 && mediaFracionaria < 0.74) {
			mediaFracionaria = 0.5;
		}
		
		else {
			mediaFracionaria = 1.0;
		}
		
		
		media = (double) mediaInteira + mediaFracionaria;
		return media;
	}
}

	
