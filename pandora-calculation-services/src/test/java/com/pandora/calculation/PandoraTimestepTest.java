package com.pandora.calculation;


import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for {@link PandoraTimestep}.
 */
class PandoraTimestepTest {

    /** Initial concentration values for the test instance. */
    private static final double[] INITIAL_Y = {1.0, 2.0, 3.0};

    /** Alternative initial concentration values for the test instance. */
    private static final double[] ALTERNATIVE_INITIAL_Y = {4.0, 5.0, 6.0};

    /** Initial time for the test instance. */
    private static final double INITIAL_T0 = 0.0;

    /** End time for the test instance. */
    private static final double END_T = 10.0;

    /** Dimensionality of the test instance. */
    private static final int DIMENSION = 3;

    /** Discharge value for the test instance. */
    private static final double DISCHARGE = 5.0;

    /** Volume value for the test instance. */
    private static final double VOLUME = 2.0;

    /** Expected discharge rate calculated as DISCHARGE / VOLUME. */
    private static final double EXPECTED_DISCHARGE_RATE = DISCHARGE / VOLUME;

    /** Alternative volume set to zero for edge case testing. */
    private static final double ZERO_VOLUME = 0.0;

    /** Expected discharge rate when volume is zero. */
    private static final double EXPECTED_ZERO_DISCHARGE_RATE = 0.0;

    /** Terrestrial source values for the test instance. */
    private static final double[] TERRESTRIAL_SOURCES = {0.5, 1.0, 1.5};

    /** Upstream source values for the test instance. */
    private static final double[] UPSTREAM_SOURCES = {2.0, 2.5, 3.0};

    /** Index for the first source in arrays. */
    private static final int INDEX_FIRST = 0;

    /** Index for the second source in arrays. */
    private static final int INDEX_SECOND = 1;

    /** Index for the third source in arrays. */
    private static final int INDEX_THIRD = 2;

    /** Test instance of PandoraTimestep. */
    private PandoraTimestep _pandoraTimestep;

    @BeforeEach
    void setUp() {
        _pandoraTimestep = PandoraTimestep.builder()
                .y0(INITIAL_Y)
                .t0(INITIAL_T0)
                .tEnd(END_T)
                .dimension(DIMENSION)
                .discharge(DISCHARGE)
                .volume(VOLUME)
                .terrestrialSources(TERRESTRIAL_SOURCES)
                .upstreamSources(UPSTREAM_SOURCES)
                .build();
    }

    @Test
    void testGetters() {
        assertArrayEquals(INITIAL_Y, _pandoraTimestep.getY0());
        assertEquals(INITIAL_T0, _pandoraTimestep.getT0());
        assertEquals(END_T, _pandoraTimestep.getTEnd());
        assertEquals(DIMENSION, _pandoraTimestep.getDimension());
        assertEquals(DISCHARGE, _pandoraTimestep.getDischarge());
        assertEquals(VOLUME, _pandoraTimestep.getVolume());
        assertArrayEquals(TERRESTRIAL_SOURCES, _pandoraTimestep.getTerrestrialSources());
        assertArrayEquals(UPSTREAM_SOURCES, _pandoraTimestep.getUpstreamSources());
    }

    @Test
    void testGetDischargeRate() {
        assertEquals(EXPECTED_DISCHARGE_RATE, _pandoraTimestep.getDischargeRate());
    }

    @Test
    void testGetDischargeRateZeroVolume() {
        PandoraTimestep timestep = PandoraTimestep.builder()
                .y0(INITIAL_Y)
                .t0(INITIAL_T0)
                .tEnd(END_T)
                .dimension(DIMENSION)
                .discharge(DISCHARGE)
                .volume(ZERO_VOLUME) // Zero volume case
                .terrestrialSources(TERRESTRIAL_SOURCES)
                .upstreamSources(UPSTREAM_SOURCES)
                .build();
        assertEquals(EXPECTED_ZERO_DISCHARGE_RATE, timestep.getDischargeRate());
    }

    @Test
    void testGetTerrestrialSourceByIndex() {
        assertEquals(TERRESTRIAL_SOURCES[0], _pandoraTimestep.getTerrestrialSources(INDEX_FIRST));
        assertEquals(TERRESTRIAL_SOURCES[1], _pandoraTimestep.getTerrestrialSources(INDEX_SECOND));
        assertEquals(TERRESTRIAL_SOURCES[2], _pandoraTimestep.getTerrestrialSources(INDEX_THIRD));
    }

    @Test
    void testGetUpstreamSourceByIndex() {
        assertEquals(UPSTREAM_SOURCES[0], _pandoraTimestep.getUpstreamSources(INDEX_FIRST));
        assertEquals(UPSTREAM_SOURCES[1], _pandoraTimestep.getUpstreamSources(INDEX_SECOND));
        assertEquals(UPSTREAM_SOURCES[2], _pandoraTimestep.getUpstreamSources(INDEX_THIRD));
    }

    @Test
    void testEqualsAndHashCode() {
        PandoraTimestep sameTimestep = PandoraTimestep.builder()
                .y0(INITIAL_Y)
                .t0(INITIAL_T0)
                .tEnd(END_T)
                .dimension(DIMENSION)
                .discharge(DISCHARGE)
                .volume(VOLUME)
                .terrestrialSources(TERRESTRIAL_SOURCES)
                .upstreamSources(UPSTREAM_SOURCES)
                .build();

        PandoraTimestep differentTimestep = PandoraTimestep.builder()
                .y0(ALTERNATIVE_INITIAL_Y)
                .t0(INITIAL_T0)
                .tEnd(END_T)
                .dimension(DIMENSION)
                .discharge(DISCHARGE)
                .volume(VOLUME)
                .terrestrialSources(TERRESTRIAL_SOURCES)
                .upstreamSources(UPSTREAM_SOURCES)
                .build();

        assertEquals(_pandoraTimestep, sameTimestep);
        assertEquals(_pandoraTimestep.hashCode(), sameTimestep.hashCode());
        assertNotEquals(_pandoraTimestep, differentTimestep);
        assertNotEquals(_pandoraTimestep.hashCode(), differentTimestep.hashCode());
    }

    @Test
    void testNotEqualsNullAndDifferentClass() {
        assertNotEquals(_pandoraTimestep, null);
        assertNotEquals(_pandoraTimestep, "Not a PandoraTimestep");
    }
}
