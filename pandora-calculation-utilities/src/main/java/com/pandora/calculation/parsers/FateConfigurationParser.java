package com.pandora.calculation.parsers;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.pandora.calculation.config.FateReactionConfiguration;
import com.pandora.calculation.config.builders.FateReactionConfigurationBuilder;
import com.pandora.calculation.config.builders.SpecieConfigurationBuilder;

/**
 * Utility class for parsing fate configurations from JSON data.
 */
public class FateConfigurationParser {
    /**
     * Key for the JSON node containing fate data.
     */
    private static final String DY_NODE_KEY = "dy";

    /**
     * Key for the JSON node containing fate reactions.
     */
    private static final String FATES_NODE_KEY = "fates";

    /**
     * Key for the type of fate.
     */
    private static final String TYPE_KEY = "fateType";

    /**
     * Key for the name of the fate.
     */
    private static final String NAME_KEY = "name";

    /**
     * Key for the type of fate as a reaction.
     */
    private static final String FATE_REACTIONTYPE_KEY = "reaction";

    /**
     * Key for the rate of the reaction fate.
     */
    private static final String RATE_KEY = "rate";

    /**
     * Key for the destination of the reaction fate.
     */
    private static final String TO_KEY = "to";

    /**
     * Parses fate configurations from the given JSON node and adds them to the specified builder.
     *
     * @param speciesNode The JSON node containing species data.
     * @param builder     The builder to which fate configurations will be added.
     */
    public static void parseFates(final JsonNode speciesNode, final SpecieConfigurationBuilder builder) {
        JsonNode dyNode = speciesNode.get(DY_NODE_KEY);
        JsonNode fatesNode = dyNode.get(FATES_NODE_KEY);

        if (fatesNode != null && fatesNode.isArray()) {
            List<FateReactionConfiguration> fateReactions = new ArrayList<>();
            for (JsonNode fateNode : fatesNode) {
                String fateType = fateNode.get(TYPE_KEY).asText();
                String name = fateNode.has(NAME_KEY) ? fateNode.get(NAME_KEY).asText() : null;
                if (fateType.equals(FATE_REACTIONTYPE_KEY)) {
                    FateReactionConfigurationBuilder<?> reactionBuilder = FateReactionConfiguration.builder();
                    double rate = fateNode.has(RATE_KEY) ? fateNode.get(RATE_KEY).asDouble() : 0.0;
                    String to = fateNode.has(TO_KEY) ? fateNode.get(TO_KEY).asText() : null;
                    fateReactions.add(reactionBuilder.name(name).rate(rate).to(to).build());
                }
            }
            builder.fateReactionConfigurations(fateReactions);
        }
    }
}


