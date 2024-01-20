package com.pandora.general;

/**
 * The {@code Sediment} interface defines methods for obtaining properties of sediment particles, including radius,
 * density, and characteristics relevant to sediment transport.
 * <p>
 * Sediment properties are essential in studies related to fluid dynamics and sediment transport in various
 * environments. Implementing classes should provide concrete implementations for the specified methods.
 * </p>
 *
 * <p>
 * The interface includes methods to retrieve information specific to sediment behavior, such as the non-cohesive or
 * cohesive nature, critical shield stress angle, and the Manning's "n" coefficient.
 * </p>
 *
 * <p>
 * The values returned by the methods may vary based on the type of sediment, where non-cohesive sediments (e.g., sands)
 * and cohesive sediments (e.g., silts, clays) exhibit different ranges for certain parameters.
 * </p>
 *
 * <p>
 * For non-cohesive sediments (e.g., sands):
 * <ul>
 * <li>{@link #getAlpha()} can range from about 0.01 to 10.</li>
 * <li>{@link #getThetaCritical()} typically ranges from about 0.02 to 0.05.</li>
 * <li>{@link #getN()} is typically around 1 to 2.</li>
 * </ul>
 *
 * <p>
 * For cohesive sediments (e.g., silts, clays):
 * <ul>
 * <li>{@link #getAlpha()} can range from about 0.001 to 1.</li>
 * <li>{@link #getThetaCritical()} is generally lower and can range from about 0.005 to 0.02.</li>
 * <li>{@link #getN()} can be in the range of 2 to 4.</li>
 * </ul>
 *
 */
public interface Sediment {
    /**
     * Gets the radius of the sediment particle.
     *
     * @return The radius of the sediment particle as a {@code double}.
     */
    double getParticleRadius();

    /**
     * Gets the density of the sediment particle.
     *
     * @return The density of the sediment particle as a {@code double}.
     */
    double getParticleDensity();

    /**
     * Gets the non-dimensional parameter "α" representing sediment characteristics. The value of "α" may vary based on
     * the type of sediment, with different ranges for non-cohesive and cohesive sediments.
     *
     * @return The value of "α" as a {@code double}.
     */
    double getAlpha();

    /**
     * Gets the critical shield stress angle "θ_c" for sediment transport. The value of "θ_c" may vary based on the type
     * of sediment, with different ranges for non-cohesive and cohesive sediments.
     *
     * @return The critical shield stress angle "θ_c" as a {@code double}.
     */
    double getThetaCritical();

    /**
     * Gets the Manning's "n" coefficient representing the roughness of the sediment surface. The value of "n" may vary
     * based on the type of sediment, with different ranges for non-cohesive and cohesive sediments.
     *
     * @return The Manning's "n" coefficient as a {@code double}.
     */
    double getN();
}
