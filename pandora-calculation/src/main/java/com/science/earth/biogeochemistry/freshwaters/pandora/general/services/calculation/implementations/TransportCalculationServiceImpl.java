package com.science.earth.biogeochemistry.freshwaters.pandora.general.services.calculation.implementations;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.science.earth.biogeochemistry.freshwaters.pandora.config.services.SpecieBeanService;
import com.science.earth.biogeochemistry.freshwaters.pandora.config.species.abstractions.Specie;
import com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.PandoraTimestep;
import com.science.earth.biogeochemistry.freshwaters.pandora.general.services.calculation.interfaces.TransportCalculationService;

@Service
public class TransportCalculationServiceImpl implements TransportCalculationService {
    /**
     * Service for accessing species information.
     */
    @Autowired
    private SpecieBeanService specieBeanService;

    /**
     * Calculates the transport of each species based on the given state variables and discharge rate.
     *
     * @param y The state variables representing species concentrations.
     * @param pandoraTimestep The Pandora timestep containing simulation parameters.
     * @return An array representing the changes in species concentrations due to transport.
     */
    @Override
    public double[] calculateTransport(final double[] y, final PandoraTimestep pandoraTimestep) {
        // Array to store changes in species concentrations due to transport.
        double[] transportDY = new double[y.length];

        // Retrieve all species in the simulation.
        Collection<Specie> species = specieBeanService.getAllSpecies().values();

        // Calculate transport for each species.
        species.forEach(specie -> calculateTransport(specie, pandoraTimestep.getDischargeRate(), y, transportDY));

        return transportDY;
    }

    /**
     * Calculates the transport for a specific species based on its characteristics and the given parameters.
     *
     * @param specie The species for which transport is calculated.
     * @param rate The discharge rate for the current timestep.
     * @param y The state variables representing species concentrations.
     * @param transportDY The array to store changes in species concentrations due to transport.
     */
    private void calculateTransport(final Specie specie, final double rate, final double[] y,
            final double[] transportDY) {
        // Get the index of the current species in the state variables array.
        int i = specie.getIndex();

        // Calculate and store the transport effect for the current species.
        transportDY[i] = specie.calculateTransport(y[i], rate);
    }
}
