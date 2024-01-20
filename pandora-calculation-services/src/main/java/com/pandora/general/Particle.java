package com.pandora.general;

/**
 * The {@code Particle} interface defines methods to retrieve information about a particle, including its radius and
 * density. Implementing classes are expected to provide concrete implementations for these methods.
 *
 * @version 0.0.1
 * @author Wim Joost van Hoek
 */
public interface Particle {

    /**
     * Gets the radius of the particle.
     *
     * @return The radius of the particle as a {@code double}.
     */
    double getParticleRadius();

    /**
     * Gets the density of the particle.
     *
     * @return The density of the particle as a {@code double}.
     */
    double getParticleDensity();
}
