package com.science.earth.biogeochemistry.freshwaters.pandora.general.services.interfaces;

import com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.RiverTimestepBaseObject;

public interface RiverTimestepService {
    RiverTimestepBaseObject calculateNextTimestep(RiverTimestepBaseObject river);
}
