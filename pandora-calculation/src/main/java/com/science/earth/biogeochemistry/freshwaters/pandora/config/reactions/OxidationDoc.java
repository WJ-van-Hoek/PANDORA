package com.science.earth.biogeochemistry.freshwaters.pandora.config.reactions;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import com.science.earth.biogeochemistry.freshwaters.pandora.config.species.DOC;

@Configuration
@Order(2)
public class OxidationDoc extends Oxidation<DOC> {
    private String reactionProductionPrefix = "reaction.oxidation.doc.production.";

    private String reactionRemovalPrefix = "reaction.oxidation.doc.removal.";

    @Override
    protected String getReactionProductionPrefix() {
	return reactionProductionPrefix;
    }

    @Override
    protected String getReactionRemovalPrefix() {
	return reactionRemovalPrefix;
    }
}