package com.science.earth.biogeochemistry.freshwaters.pandora.general.services.calculation.implementations;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.CellBaseObject;
import com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.PandoraTimestep;
import com.science.earth.biogeochemistry.freshwaters.pandora.general.services.calculation.interfaces.CellTimestepService;
import com.science.earth.biogeochemistry.freshwaters.pandora.general.services.calculation.interfaces.LocalDateTimeService;
import com.science.earth.biogeochemistry.freshwaters.pandora.general.services.calculation.interfaces.PandoraIntegratorService;
import com.science.earth.biogeochemistry.freshwaters.pandora.services.mapcrudservices.implementations.TerrestrialSourcesMapService;
import com.science.earth.biogeochemistry.freshwaters.pandora.services.mapcrudservices.implementations.UpstreamSourcesMapService;
import com.science.earth.biogeochemistry.freshwaters.pandora.services.mapcrudservices.implementations.YMapService;

@Service
public class CellTimestepServiceImpl implements CellTimestepService {

    @Autowired
    YMapService yMapService;

    @Autowired
    TerrestrialSourcesMapService terrestrialSourcesMapService;

    @Autowired
    UpstreamSourcesMapService upstreamSourcesMapService;

    @Autowired
    PandoraIntegratorService pandoraIntegratorService;

    @Autowired
    LocalDateTimeService localDateTimeService;

    @Override
    public void calculateNextTimestep(CellBaseObject cell, LocalDateTime t0) {
	PandoraTimestep timestep = buildPandoraTimestep(cell, t0);
	double[] yEnd = pandoraIntegratorService.integrate(timestep);
	LocalDateTime tEnd = localDateTimeService.calculateTEndAsLocalDateTime(t0, timestep.getTEnd());
	yMapService.saveAtCellAndTimestep(cell, tEnd, yEnd);
    }

    private PandoraTimestep buildPandoraTimestep(CellBaseObject cell, LocalDateTime t0) {
	double[] y0 = yMapService.findAtCellAndTimestep(cell, t0);
	double[] terrestrialSources = terrestrialSourcesMapService.findAtCellAndTimestep(cell, t0);
	double[] upstreamSources = upstreamSourcesMapService.findAtCellAndTimestep(cell, t0);

	return PandoraTimestep.builder().y0(y0).t0(0d).tEnd(1d).dimension(y0.length)
		.terrestrialSources(terrestrialSources).upstreamSources(upstreamSources).build();
    }

}
