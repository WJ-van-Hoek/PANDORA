package com.science.earth.biogeochemistry.freshwaters.pandora.config.reactions;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.annotation.Order;

import com.science.earth.biogeochemistry.freshwaters.pandora.config.reactions.abstractions.Oxidation;
import com.science.earth.biogeochemistry.freshwaters.pandora.config.species.DOC;

@Configuration
@PropertySource("classpath:species.properties")
@ConditionalOnProperty(name = "doc.enabled", havingValue = "true")
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