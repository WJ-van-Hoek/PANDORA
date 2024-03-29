package com.pandora.controllers.requestbodies;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import com.pandora.general.objects.Cell;

import jakarta.validation.ValidationException;
import lombok.Getter;

/**
 * The {@code CellCalculationRequest} class represents the request body for cell calculation-related HTTP requests. It
 * implements the {@link RequestBody} interface and provides methods for validating the content of the request body. It
 * contains information such as the cell for calculation, initial conditions, sources, discharges, volumes, starting
 * time, and the number of timesteps.
 *
 * @author Wim Joost van Hoek
 * @version 0.0.1
 * @see RequestBody
 */
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
