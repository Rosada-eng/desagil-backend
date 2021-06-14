package br.edu.insper.desagil.backend.model;

import java.util.ArrayList;
import java.util.List;

public class CollaborationTrack extends Track{
	private List<Artist> collaborators;

	public CollaborationTrack(Artist artist, List<Artist> collaborators, String name, int duration) {
		super(artist, name, duration);
		this.collaborators = collaborators;
	}
	
	private List<String> getCollaboratorsName() {
		List<String> collaboratorsName = new ArrayList<>();
		
		for (Artist artista: this.collaborators) {
			collaboratorsName.add(artista.getName());
		}
		
		return collaboratorsName;
	}

	@Override
	public String getFullArtistName() {
		String fullName = "";
		fullName += super.getArtist().getName();
		
		String colaboradores = String.join(", ", this.getCollaboratorsName());
		
		fullName += " (feat. ";
		fullName += colaboradores;
		fullName += ")";

		return fullName;
	}
}
