package com.science.earth.biogeochemistry.freshwaters.pandora.general.services.interfaces;

import java.time.LocalDateTime;

import com.science.earth.biogeochemistry.freshwaters.pandora.general.PandoraTimestep;
import com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.CellBaseObject;
import com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.CellTimestepBaseObject;

public interface CellTimestepService {
    PandoraTimestep buildPandoraTimestep(CellBaseObject cell, LocalDateTime t0);
    CellTimestepBaseObject calculateNextTimestep(CellTimestepBaseObject cell, LocalDateTime t0);
}
