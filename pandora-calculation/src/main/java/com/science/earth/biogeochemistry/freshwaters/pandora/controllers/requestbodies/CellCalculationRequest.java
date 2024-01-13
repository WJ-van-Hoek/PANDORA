package com.science.earth.biogeochemistry.freshwaters.pandora.controllers.requestbodies;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.Cell;

import jakarta.xml.bind.ValidationException;
import lombok.Getter;

@Getter
public class CellCalculationRequest implements RequestBody {
    /**
     * The cell for which the calculation is requested.
     */
    private Cell cell;

    /**
     * The initial conditions for the calculation.
     */
    private double[] y0;

    /**
     * List of upstream sources for the calculation.
     */
    private List<double[]> upstreamSources;

    /**
     * List of terrestrial sources for the calculation.
     */
    private List<double[]> terrestrialSources;

    /**
     * List of discharges for the calculation.
     */
    private List<Double> discharges;

    /**
     * List of volumes for the calculation.
     */
    private List<Double> volumes;

    /**
     * The starting time for the calculation.
     */
    private LocalDateTime t0;

    /**
     * The number of timesteps for the calculation.
     */
    private int numberOfTimesteps;

    @Override
    public final void validate() throws ValidationException {

        // Null checks
        Objects.requireNonNull(this.getCell(), "Cell cannot be null");
        Objects.requireNonNull(this.getY0(), "y0 cannot be null");
        Objects.requireNonNull(this.getUpstreamSources(), "UpstreamSources cannot be null");
        Objects.requireNonNull(this.getTerrestrialSources(), "TerrestrialSources cannot be null");
        Objects.requireNonNull(this.getDischarges(), "Discharges cannot be null");
        Objects.requireNonNull(this.getVolumes(), "Volumes cannot be null");
        Objects.requireNonNull(this.getT0(), "t0 cannot be null");

        // Specific checks
        if (this.getNumberOfTimesteps() <= 0) {
            throw new ValidationException("numberOfTimesteps must be a positive integer");
        }
    }
}
