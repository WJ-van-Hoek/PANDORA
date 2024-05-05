package com.pandora.calculation.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pandora.calculation.PandoraTimestep;
import com.pandora.calculation.config.SpecieConfiguration;

/**
 * Implementation of the {@link TransportCalculationService} interface that calculates the transport of chemical species
 * within a simulation.
 * <p>
 * This implementation utilizes a service for retrieving configuration information about chemical species, and computes
 * the transport rates based on the species' properties and the current state of the simulation represented by the
 * variables {@code y} and the {@code pandoraTimestep}.
 * </p>
 * <p>
 * Instances of this class are intended to be managed by the Spring framework as Spring beans, allowing for dependency
 * injection of required services.
 * </p>
 *
 * @author [Your Name]
 * @since 1.0
 */
@Service
public final class TransportCalculationServiceImpl implements TransportCalculationService {

    /** Service for retrieving configuration information about chemical species. */
    @Autowired
    private SpecieConfigurationMemoryService _specieConfigurationMemoryService;

    /**
     * Calculates the transport of chemical species within the simulation.
     *
     * @param y The current state of the system, represented by an array of variables.
     * @param pandoraTimestep The timestep information for the current state of the simulation.
     * @return An array containing the computed transport derivatives for each variable.
     */
    @Override
    public double[] calculateTransport(final double[] y, final PandoraTimestep pandoraTimestep) {
        // Initialize array to store transport derivatives
        double[] transportDY = new double[y.length];
        // Retrieve configuration information about all chemical species
        List<SpecieConfiguration> species = _specieConfigurationMemoryService.findAllSpecieConfigurations();
        // Calculate transport rates for each species
        species.forEach(specie -> calculateTransport(specie, pandoraTimestep.getDischargeRate(), y, transportDY));
        return transportDY;
    }

    /**
     * Calculates the transport rate for a specific chemical species.
     *
     * @param specie The configuration information of the chemical species.
     * @param rate The discharge rate for the current timestep.
     * @param y The current state of the system, represented by an array of variables.
     * @param transportDY The array to store the computed transport derivatives.
     */
    private void calculateTransport(final SpecieConfiguration specie, final double rate, final double[] y,
            final double[] transportDY) {
        int i = specie.getIndex();
        // Calculate transport rate for the species
        transportDY[i] = specie.getTransportability() * y[i] * rate;
    }
}
