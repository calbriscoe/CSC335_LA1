package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Rating;

class RatingTest {

    @Test
    void getRatingTest() {
        assertEquals(Rating.None, Rating.getRating(0));
        assertEquals(Rating.One, Rating.getRating(1));
        assertEquals(Rating.Two, Rating.getRating(2));
        assertEquals(Rating.Three, Rating.getRating(3));
        assertEquals(Rating.Four, Rating.getRating(4));
        assertEquals(Rating.Five, Rating.getRating(5));
        assertEquals(Rating.Five, Rating.getRating(10));
    }

}
