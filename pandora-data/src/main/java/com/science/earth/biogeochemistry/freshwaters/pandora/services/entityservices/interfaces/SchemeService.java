package com.science.earth.biogeochemistry.freshwaters.pandora.services.entityservices.interfaces;

import java.util.Set;

import com.science.earth.biogeochemistry.freshwaters.pandora.model.Reaction;
import com.science.earth.biogeochemistry.freshwaters.pandora.model.Scheme;
import com.science.earth.biogeochemistry.freshwaters.pandora.model.Source;
import com.science.earth.biogeochemistry.freshwaters.pandora.model.Specie;

public interface SchemeService extends AbstractBaseEntityService<Scheme> {
    public void addReactionToScheme(Scheme scheme, Reaction reaction);
    
    public void addReactionByIdToScheme(Scheme scheme, Long reactionId);
    
    public void addReactionByIdToSchemeById(Long schemeId, Long reactionId);

    public void addSourceToScheme(Scheme scheme, Source source);
    
    public void addSourceByIdToScheme(Scheme scheme, Long sourceId);
    
    public void addSourceByIdToSchemeById(Long schemeId, Long sourceId);

    public void addSpecieToScheme(Scheme scheme, Specie specie);
    
    public void addSpecieByIdToScheme(Scheme scheme, Long specieId);
    
    public void addSpecieByIdToSchemeById(Long schemeId, Long specieId);

    public void deleteReactionFromScheme(Scheme scheme, Reaction reaction);
    
    public void deleteReactionByIdFromScheme(Scheme scheme, Long reactionId);
    
    public void deleteReactionByIdFromSchemeById(Long schemeId, Long reactionId);

    public void deleteSourceFromScheme(Scheme scheme, Source source);
    
    public void deleteSourceByIdFromScheme(Scheme scheme, Long sourceId);
    
    public void deleteSourceByIdFromSchemeById(Long schemeId, Long sourceId);

    public void deleteSpecieFromScheme(Scheme scheme, Specie specie);

    public void deleteSpecieByIdFromScheme(Scheme scheme, Long specieId);
    
    public void deleteSpecieByIdFromSchemeById(Long schemeId, Long specieId);
    
    public void addReactionSetToScheme(Scheme scheme, Set<Reaction> reactions);

    public void addSourceSetToScheme(Scheme scheme, Set<Source> sources);

    public void addSpecieSetToScheme(Scheme scheme, Set<Specie> species);
}
