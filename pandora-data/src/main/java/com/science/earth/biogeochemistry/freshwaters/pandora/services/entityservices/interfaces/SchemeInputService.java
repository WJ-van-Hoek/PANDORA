package com.science.earth.biogeochemistry.freshwaters.pandora.services.entityservices.interfaces;

import java.util.Set;

import com.science.earth.biogeochemistry.freshwaters.pandora.model.inputs.ReactionInputEntity;
import com.science.earth.biogeochemistry.freshwaters.pandora.model.inputs.SchemeInputEntity;
import com.science.earth.biogeochemistry.freshwaters.pandora.model.inputs.SourceInputEntity;
import com.science.earth.biogeochemistry.freshwaters.pandora.model.inputs.SpecieInputEntity;

public interface SchemeInputService extends AbstractBaseEntityService<SchemeInputEntity> {
    public void addReactionToScheme(SchemeInputEntity scheme, ReactionInputEntity reaction);
    
    public void addReactionByIdToScheme(SchemeInputEntity scheme, Long reactionId);
    
    public void addReactionByIdToSchemeById(Long schemeId, Long reactionId);

    public void addSourceToScheme(SchemeInputEntity scheme, SourceInputEntity source);
    
    public void addSourceByIdToScheme(SchemeInputEntity scheme, Long sourceId);
    
    public void addSourceByIdToSchemeById(Long schemeId, Long sourceId);

    public void addSpecieToScheme(SchemeInputEntity scheme, SpecieInputEntity specie);
    
    public void addSpecieByIdToScheme(SchemeInputEntity scheme, Long specieId);
    
    public void addSpecieByIdToSchemeById(Long schemeId, Long specieId);

    public void deleteReactionFromScheme(SchemeInputEntity scheme, ReactionInputEntity reaction);
    
    public void deleteReactionByIdFromScheme(SchemeInputEntity scheme, Long reactionId);
    
    public void deleteReactionByIdFromSchemeById(Long schemeId, Long reactionId);

    public void deleteSourceFromScheme(SchemeInputEntity scheme, SourceInputEntity source);
    
    public void deleteSourceByIdFromScheme(SchemeInputEntity scheme, Long sourceId);
    
    public void deleteSourceByIdFromSchemeById(Long schemeId, Long sourceId);

    public void deleteSpecieFromScheme(SchemeInputEntity scheme, SpecieInputEntity specie);

    public void deleteSpecieByIdFromScheme(SchemeInputEntity scheme, Long specieId);
    
    public void deleteSpecieByIdFromSchemeById(Long schemeId, Long specieId);
    
    public void addReactionSetToScheme(SchemeInputEntity scheme, Set<ReactionInputEntity> reactions);

    public void addSourceSetToScheme(SchemeInputEntity scheme, Set<SourceInputEntity> sources);

    public void addSpecieSetToScheme(SchemeInputEntity scheme, Set<SpecieInputEntity> species);
}
