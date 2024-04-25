package com.pandora.calculation.parsers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import com.fasterxml.jackson.databind.JsonNode;
import com.general.utils.json.mappers.File;
import com.pandora.calculation.data.TemporalCellDataPoint;
import com.pandora.calculation.data.TemporalCellDataPointVector;

/**
 * Utility class for parsing JSON data into TemporalCellDataPointVector objects.
 */
public final class TemporalCellDataPointVectorNodeParser {

    /**
     * Private constructor to prevent instantiation of this utility class.
     */
    private TemporalCellDataPointVectorNodeParser() {
    }

    /**
     * Parses the JSON data from the specified file path and populates the given TemporalCellDataPointVector.
     *
     * @param dataMatrix   The TemporalCellDataPointVector to populate with the parsed data.
     * @param dataFilePath The file path to the JSON data.
     */
    public static void parseTemporalCellDataPointVectorNode(final TemporalCellDataPointVector dataMatrix,
                                                            final String dataFilePath) {
        Optional<JsonNode> jsonNodeOptional = File.mapToJson(dataFilePath);
        jsonNodeOptional.ifPresent(rootNode -> parseToTemporalCellDataPointVector(rootNode, dataMatrix));
    }

    /**
     * Parses the JSON data represented by the root JSON node and populates the given TemporalCellDataPointVector.
     *
     * @param rootNode    The root JSON node containing the data.
     * @param dataVector  The TemporalCellDataPointVector to populate with the parsed data.
     */
    private static void parseToTemporalCellDataPointVector(final JsonNode rootNode,
                                                           final TemporalCellDataPointVector dataVector) {
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        JsonNode cellsNode = rootNode.get("cells");
        for (JsonNode cellNode : cellsNode) {
            int cellId = cellNode.get("cell_id").asInt();
            for (JsonNode entryNode : cellNode.get("data")) {
                String dateStr = entryNode.get("datetime").asText();
                LocalDateTime dateTime = LocalDateTime.parse(dateStr, formatter);
                double value = entryNode.get("value").asDouble();
                TemporalCellDataPoint dataPoint = new TemporalCellDataPoint(cellId, value, dateTime);
                dataVector.add(dataPoint);
            }
        }
    }
}

