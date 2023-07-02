package com.science.earth.biogeochemistry.freshwaters.pandora.general.interfaces;

import java.util.List;

public interface PandoraRiverService {
    List<River> getAllRivers();
    River getRiverByIndex(int index);
}
