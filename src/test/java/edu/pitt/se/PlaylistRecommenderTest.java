package edu.pitt.se;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class PlaylistRecommenderTest {

    @Test
    public void testClassifyEnergyHigh() {
        assertEquals("HIGH", PlaylistRecommender.classifyEnergy(List.of(150, 145, 142)));
    }

    @Test
    public void testClassifyEnergyMedium() {
        assertEquals("MEDIUM", PlaylistRecommender.classifyEnergy(List.of(120, 110)));
    }

    @Test
    public void testClassifyEnergyLow() {
        assertEquals("LOW", PlaylistRecommender.classifyEnergy(List.of(80, 90)));
    }

    @Test
    public void testClassifyEnergyRejectsNull() {
        assertThrows(IllegalArgumentException.class,
                () -> PlaylistRecommender.classifyEnergy(null));
    }

    @Test
    public void testClassifyEnergyRejectsEmpty() {
        assertThrows(IllegalArgumentException.class,
                () -> PlaylistRecommender.classifyEnergy(List.of()));
    }

    @Test
    public void testValidTrackTitle() {
        assertTrue(PlaylistRecommender.isValidTrackTitle("Summer Vibes"));
    }

    @Test
    public void testInvalidTrackTitleSpecialChars() {
        assertFalse(PlaylistRecommender.isValidTrackTitle("Hello!"));
    }

    @Test
    public void testInvalidTrackTitleTooLong() {
        assertFalse(PlaylistRecommender.isValidTrackTitle("This title is definitely too long to pass"));
    }

    @Test
    public void testNormalizeVolumeClampsHigh() {
        assertEquals(100, PlaylistRecommender.normalizeVolume(150));
    }

    @Test
    public void testNormalizeVolumeClampsLow() {
        assertEquals(0, PlaylistRecommender.normalizeVolume(-20));
    }

    @Test
    public void testNormalizeVolumeNormal() {
        assertEquals(75, PlaylistRecommender.normalizeVolume(75));
    }
}
