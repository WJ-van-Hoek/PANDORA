package com.science.earth.biogeochemistry.freshwaters.pandora.services.entityservices.interfaces;

import java.util.List;

import com.science.earth.biogeochemistry.freshwaters.pandora.commands.interfaces.RiverCommand;

public interface PandoraRiverService {
    List<RiverCommand> getAllRivers();
    RiverCommand getRiverByIndex(int index);
}
