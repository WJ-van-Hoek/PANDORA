package com.science.earth.biogeochemistry.freshwaters.pandora.config.reactions;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import com.science.earth.biogeochemistry.freshwaters.pandora.config.reactions.abstractions.Oxidation;
import com.science.earth.biogeochemistry.freshwaters.pandora.config.species.DOC;

@ConditionalOnProperty(name = "doc.enabled", havingValue = "true")
@Configuration
@Order(2)
public class OxidationDoc extends Oxidation<DOC> {
    /**
     * The {@code reactionProductionPrefix} field in the {@link OxidationDoc} class represents the prefix used to
     * construct property names for the production quantities associated with the oxidation reaction involving Dissolved
     * Organic Carbon (DOC) species.
     * <p>
     * The prefix is initialized to "reaction.oxidation.doc.production." and is used in conjunction with specific
     * property names to dynamically retrieve configuration values related to the production of species during the
     * oxidation reaction.
     * <p>
     * Developers extending or configuring the {@link OxidationDoc} class should be aware that this field influences the
     * construction of property names and plays a crucial role in obtaining configuration values for the production
     * phase of the reaction.
     *
     * @see OxidationDoc
     */
    private String reactionProductionPrefix = "reaction.oxidation.doc.production.";

    /**
     * The {@code reactionRemovalPrefix} field in the {@link OxidationDoc} class represents the prefix used to construct
     * property names for the removal quantities associated with the oxidation reaction involving Dissolved Organic
     * Carbon (DOC) species.
     * <p>
     * The prefix is initialized to "reaction.oxidation.doc.removal." and is used in conjunction with specific property
     * names to dynamically retrieve configuration values related to the removal of species during the oxidation
     * reaction.
     * <p>
     * Developers extending or configuring the {@link OxidationDoc} class should be aware that this field influences the
     * construction of property names and plays a crucial role in obtaining configuration values for the removal phase
     * of the reaction.
     *
     * @see OxidationDoc
     */
    private String reactionRemovalPrefix = "reaction.oxidation.doc.removal.";

    @Override
    protected final String getReactionProductionPrefix() {
        return reactionProductionPrefix;
    }

    @Override
    protected final String getReactionRemovalPrefix() {
        return reactionRemovalPrefix;
    }
}
