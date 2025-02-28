package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Rating;

class RatingTest {

    @Test
    void getRatingTest() {
        assertEquals(Rating.None, Rating.setRating(0));
        assertEquals(Rating.One, Rating.setRating(1));
        assertEquals(Rating.Two, Rating.setRating(2));
        assertEquals(Rating.Three, Rating.setRating(3));
        assertEquals(Rating.Four, Rating.setRating(4));
        assertEquals(Rating.Five, Rating.setRating(5));
        assertEquals(Rating.Five, Rating.setRating(10));
    }

}
