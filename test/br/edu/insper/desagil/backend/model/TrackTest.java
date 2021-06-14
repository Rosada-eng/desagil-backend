package br.edu.insper.desagil.backend.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TrackTest {
	private Artist fabioJr;
	
	@BeforeEach
	void setUp() {
		Artist fabioJr = new Artist("Fabio Jr");
	}

	@Test
	void testZeroSeconds() {
		Track track = new Track (fabioJr, "Rio", 0);
		String duration = track.getDurationString();
		
		assertEquals("0:00", duration);
	}

	@Test
	void testFiveSeconds() {
		Track track = new Track (fabioJr, "Rio", 5);
		String duration = track.getDurationString();
		
		assertEquals("0:05", duration);
	}

	@Test
	void testTwentyFiveSeconds() {
		Track track = new Track (fabioJr, "Rio", 25);
		String duration = track.getDurationString();
		
		assertEquals("0:25", duration);
	}

	@Test
	void testOneMinuteZeroSeconds() {
		Track track = new Track (fabioJr, "Rio", 60);
		String duration = track.getDurationString();
		
		assertEquals("1:00", duration);
	}

	@Test
	void testOneMinuteFiveSeconds() {
		Track track = new Track (fabioJr, "Rio", 65);
		String duration = track.getDurationString();
		
		assertEquals("1:05", duration);
	}

	@Test
	void testOneMinuteTwentyFiveSeconds() {
		Track track = new Track (fabioJr, "Rio", 85);
		String duration = track.getDurationString();
		
		assertEquals("1:25", duration);
	}

	@Test
	void testTwoMinutesZeroSeconds() {
		Track track = new Track (fabioJr, "Rio", 120);
		String duration = track.getDurationString();
		
		assertEquals("2:00", duration);
	}

	@Test
	void testTwoMinutesFiveSeconds() {
		Track track = new Track (fabioJr, "Rio", 125);
		String duration = track.getDurationString();
		
		assertEquals("2:05", duration);
	}

	@Test
	void testTwoMinutesTwentyFiveSeconds() {
		Track track = new Track (fabioJr, "Rio", 145);
		String duration = track.getDurationString();
		
		assertEquals("2:25", duration);
	}

	@Test
	void testOneCollaborator() {
		Artist anitta = new Artist ("Anitta");
		Artist beckyG = new Artist ("Becky G");
		
		List<Artist> colaboradores = new ArrayList<>();
		colaboradores.add(beckyG);
		
		CollaborationTrack coTrack = new CollaborationTrack(anitta, colaboradores, "Rio", 90);
		String fullArtistName = coTrack.getFullArtistName();
		
		assertEquals("Anitta (feat. Becky G)", fullArtistName);
	}

	@Test
	void testTwoCollaborators() {
		Artist anitta = new Artist ("Anitta");
		Artist ludmilla = new Artist ("Ludmilla");
		Artist snoopDog = new Artist ("Snoop Dog");
		
		List<Artist> colaboradores = new ArrayList<>();
		colaboradores.add(ludmilla);
		colaboradores.add(snoopDog);
		
		CollaborationTrack coTrack = new CollaborationTrack(anitta, colaboradores, "Rio", 90);
		String fullArtistName = coTrack.getFullArtistName();

		assertEquals("Anitta (feat. Ludmilla, Snoop Dog)", fullArtistName);
	}
}
