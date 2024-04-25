package com.pandora.calculation.config;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;
import lombok.experimental.Accessors;

@Getter
@Builder
@Accessors(prefix = "_", chain = true) // Specify prefix and chain options
public final class ModelRunConfiguration extends IndexedConfiguration {
    /**
     * The end dateTime of the model run.
     */
    private final LocalDateTime _startDateTime;

    /**
     * The end dateTime of the model run.
     */
    private final LocalDateTime _endDateTime;

    /**
     * The timestep of the model run in years.
     */
    private final int _timestep;

    /**
     * The root path of all other paths.
     */
    private final String _rootPath;

    /**
     * The bootstrapData path.
     */
    private final String _bootstrapPath;

    /**
     * The specie configurations path.
     */
    private final String _speciesPath;

    /**
     * Constructs a new ModelRunConfiguration object using the provided builder.
     *
     * <p>
     * This constructor initializes a model run configuration with the specified start date and time, end date and time,
     * timestep, root path, bootstrap path, and species path.
     *
     * @param startDateTime The start date and time of the model run.
     * @param endDateTime The end date and time of the model run.
     * @param timestep The timestep of the model run.
     * @param rootPath The root path of the model run.
     * @param bootstrapPath The bootstrap path of the model run.
     * @param speciesPath The species path of the model run.
     */
    @Builder
    private ModelRunConfiguration(final LocalDateTime startDateTime, final LocalDateTime endDateTime,
            final int timestep, final String rootPath, final String bootstrapPath, final String speciesPath) {
        _startDateTime = startDateTime;
        _endDateTime = endDateTime;
        _timestep = timestep;
        _rootPath = rootPath;
        _bootstrapPath = bootstrapPath;
        _speciesPath = speciesPath;
    }

}
