package com.pandora.calculation.parsers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import org.apache.commons.cli.CommandLine;

import com.fasterxml.jackson.databind.JsonNode;
import com.general.utils.json.mappers.File;
import com.pandora.calculation.data.BootstrapDataContainer;
import com.pandora.calculation.data.BootstrapDataContainerBuilder;
import com.pandora.calculation.data.FixCellDataPoint;
import com.pandora.calculation.data.FixCellDataPointVector;
import com.pandora.calculation.data.TemporalCellDataPoint;
import com.pandora.calculation.data.TemporalCellDataPointVector;

/**
 * Utility class for parsing bootstrap data from command line arguments.
 */
public final class BootstrapDataParser {

    private BootstrapDataParser() {
    }

    /**
     * Parses bootstrap data from the provided command line.
     *
     * @param cmd The command line containing the arguments.
     * @return A {@link BootstrapDataContainer} parsed from the command line, or an empty Optional if no bootstrap data
     * were found.
     */
    public static Optional<BootstrapDataContainer> parse(final CommandLine cmd) {
        if (!cmd.hasOption("bootstrapData")) {
            return Optional.empty();
        }

        String hydrologyDataFilePath = cmd.getOptionValue("bootstrapData");
        Optional<JsonNode> jsonNodeOptional = File.mapToJson(hydrologyDataFilePath);
        return jsonNodeOptional.flatMap(BootstrapDataParser::parseToContainer);
    }

    private static Optional<BootstrapDataContainer> parseToContainer(final JsonNode jsonNode) {
        BootstrapDataContainerBuilder builder = new BootstrapDataContainerBuilder();
        TemporalCellDataPointVector dischargeData = parseDischargeData(jsonNode);
        TemporalCellDataPointVector volumeData = parseVolumeData(jsonNode);
        FixCellDataPointVector fixCellData = parseFixCellData(jsonNode);
        BootstrapDataContainer bootstrapData = builder.dischargeData(dischargeData).volumeData(volumeData)
                .fixData(fixCellData).build();
        return Optional.ofNullable(bootstrapData);
    }

    private static TemporalCellDataPointVector parseDischargeData(final JsonNode jsonNode) {
        String dischargeDataFilePath = jsonNode.get("dischargeDataFilePath").asText();
        TemporalCellDataPointVector dischargeData = new TemporalCellDataPointVector();
        parseTemporalCellDataPointVectorNode(dischargeData, dischargeDataFilePath);
        return dischargeData;
    }

    private static TemporalCellDataPointVector parseVolumeData(final JsonNode jsonNode) {
        String volumeDataFilePath = jsonNode.get("volumeDataFilePath").asText();
        TemporalCellDataPointVector volumeData = new TemporalCellDataPointVector();
        parseTemporalCellDataPointVectorNode(volumeData, volumeDataFilePath);
        return volumeData;
    }

    private static FixCellDataPointVector parseFixCellData(final JsonNode jsonNode) {
        String fixCellDataFilePath = jsonNode.get("fixCellDataFilePath").asText();
        FixCellDataPointVector fixDataVector = new FixCellDataPointVector();
        parseFixCellDataPointVectorNode(fixDataVector, fixCellDataFilePath);
        return fixDataVector;
    }

    private static void parseFixCellDataPointVectorNode(final FixCellDataPointVector fixDataVector, final String path) {
        Optional<JsonNode> jsonNodeOptional = File.mapToJson(path);
        jsonNodeOptional.ifPresent(rootNode -> parseToFixCellDataPointVector(fixDataVector, rootNode));
    }

    private static void parseToFixCellDataPointVector(final FixCellDataPointVector fixDataVector,
            final JsonNode rootNode) {
        JsonNode cellsNode = rootNode.get("cells");
        if (cellsNode != null && cellsNode.isArray()) {
            for (JsonNode cellNode : cellsNode) {
                int cellId = cellNode.get("cell_id").asInt();
                JsonNode dataNode = cellNode.get("data");
                if (dataNode != null && dataNode.isObject()) {
                    double latitude = dataNode.get("latitude").asDouble();
                    double longitude = dataNode.get("longitude").asDouble();
                    int previousCellValue = dataNode.get("previous_cell").asInt();
                    Integer previousCell = previousCellValue != 0 ? previousCellValue : null;
                    fixDataVector.add(new FixCellDataPoint(cellId, latitude, longitude, previousCell));
                }
            }
        }
    }

    private static void parseTemporalCellDataPointVectorNode(final TemporalCellDataPointVector dataMatrix,
            final String dataFilePath) {
        Optional<JsonNode> jsonNodeOptional = File.mapToJson(dataFilePath);
        jsonNodeOptional.ifPresent(rootNode -> parseToTemporalCellDataPointVector(rootNode, dataMatrix));
    }

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
