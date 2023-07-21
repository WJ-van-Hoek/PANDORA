package com.science.earth.biogeochemistry.freshwaters.pandora.general.services.implementations;

import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.science.earth.biogeochemistry.freshwaters.pandora.general.PandoraTimestep;
import com.science.earth.biogeochemistry.freshwaters.pandora.general.PandoraTimestepImpl;
import com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.CellBaseObject;
import com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.CellTimestepBaseObject;
import com.science.earth.biogeochemistry.freshwaters.pandora.general.services.interfaces.CellTimestepService;
import com.science.earth.biogeochemistry.freshwaters.pandora.general.services.interfaces.PandoraIntegratorService;
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

    @Override
    public CellTimestepBaseObject calculateNextTimestep(CellTimestepBaseObject cellTimestep, LocalDateTime t0) {

	PandoraTimestep timestep = buildPandoraTimestep(cellTimestep.getCell(), t0);

	double[] yEnd = pandoraIntegratorService.integrate(timestep);
	cellTimestep.setYEnd(Arrays.stream(yEnd).boxed().toList());
	return cellTimestep;
    }

    private PandoraTimestep buildPandoraTimestep(CellBaseObject cell, LocalDateTime t0) {
	double[] y0 = yMapService.findYAtTimestep(cell, t0);
	double[] terrestrialSources = terrestrialSourcesMapService.findAtTimestep(cell, t0);
	double[] upstreamSources = upstreamSourcesMapService.findAtTimestep(cell, t0);

	return PandoraTimestepImpl.builder().y0(y0).t0(0d).dimension(y0.length)
		.terrestrialSources(terrestrialSources).upstreamSources(upstreamSources).build();
    }

}
