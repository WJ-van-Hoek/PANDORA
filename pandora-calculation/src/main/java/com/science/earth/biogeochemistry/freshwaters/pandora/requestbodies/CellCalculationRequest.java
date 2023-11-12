package com.science.earth.biogeochemistry.freshwaters.pandora.requestbodies;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.Cell;

import jakarta.xml.bind.ValidationException;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CellCalculationRequest implements RequestBody {
    private Cell cell;
    double[] y0;
    List<double[]> upstreamSources;
    List<double[]> terrestrialSources;
    List<Double> discharges;
    List<Double> volumes;
    private LocalDateTime t0;
    private int numberOfTimesteps;

    @Override
    public void validate() throws ValidationException {

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

	// Additional validation or consistency checks can be added here
    }
}
