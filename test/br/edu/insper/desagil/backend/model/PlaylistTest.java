package br.edu.insper.desagil.backend.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlaylistTest {
	private static double DELTA = 0.000001;
	private Playlist playlist;

	@BeforeEach
	void setUp() {
		playlist = new Playlist(1111);
	}

	@Test
	void testRoundDownToZero() {
		playlist.putRating("fulano", 1);
		playlist.putRating("cicrano", 2);
		playlist.putRating("beltrano", 3);
		playlist.putRating("fabiano", 3);
		
		double media = playlist.averageRatings();
		assertEquals(2.0, media, DELTA);
	}

	@Test
	void testRoundUpToHalf() {
		playlist.putRating("fulano", 1);
		playlist.putRating("cicrano", 2);
		playlist.putRating("beltrano", 1);
		
		double media = playlist.averageRatings();
		assertEquals(1.5, media, DELTA);
	}

	@Test
	void testRoundDownToHalf() {
		playlist.putRating("fulano", 1);
		playlist.putRating("cicrano", 2);
		playlist.putRating("beltrano", 2);

		double media = playlist.averageRatings();
		assertEquals(1.5, media, DELTA);
	}

	@Test
	void testRoundUpToOne() {
		playlist.putRating("fulano", 1);
		playlist.putRating("cicrano", 1);
		playlist.putRating("beltrano", 2);
		playlist.putRating("fabiano", 3);
		
		double media = playlist.averageRatings();
		assertEquals(2.0, media, DELTA);
	}
}
