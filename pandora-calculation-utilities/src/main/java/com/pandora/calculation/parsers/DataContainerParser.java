package com.pandora.calculation.parsers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.cli.CommandLine;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.general.utils.json.mappers.File;
import com.pandora.calculation.data.DataContainer;
import com.pandora.calculation.data.BootstrapDataContainerBuilder;
import com.pandora.calculation.data.FixCellDataPoint;
import com.pandora.calculation.data.FixCellDataPointVector;
import com.pandora.calculation.data.TemporalCellDataPointVector;

/**
 * Utility class for parsing bootstrap data from command line arguments.
 */
public final class DataContainerParser {

    private DataContainerParser() {
    }

    /**
     * Parses bootstrap data from the provided command line.
     *
     * @param cmd The command line containing the arguments.
     * @return A {@link DataContainer} parsed from the command line, or an empty Optional if no bootstrap data were
     * found.
     */
    public static Optional<DataContainer> parse(final CommandLine cmd) {
        if (!cmd.hasOption("bootstrapData")) {
            return Optional.empty();
        }

        String bootstrapDataFilePath = cmd.getOptionValue("bootstrapData");
        return parse(bootstrapDataFilePath);
    }

    /**
     * Parses the bootstrap data file located at the specified path and returns the parsed data container. If parsing is
     * successful, the parsed data container is wrapped in an {@link Optional}, otherwise, an empty {@link Optional} is
     * returned.
     *
     * @param bootstrapDataFilePath The file path of the bootstrap data file to parse.
     * @return An {@link Optional} containing the parsed {@link DataContainer}, or an empty {@link Optional} if parsing
     * fails or the file is not found.
     */
    public static Optional<DataContainer> parse(final String bootstrapDataFilePath) {
        Optional<JsonNode> jsonNodeOptional = File.mapToJson(bootstrapDataFilePath);
        return jsonNodeOptional.flatMap(DataContainerParser::parseToContainer);
    }

    private static Optional<DataContainer> parseToContainer(final JsonNode jsonNode) {
        BootstrapDataContainerBuilder builder = new BootstrapDataContainerBuilder();
        TemporalCellDataPointVector dischargeData = parseDischargeData(jsonNode);
        TemporalCellDataPointVector volumeData = parseVolumeData(jsonNode);
        FixCellDataPointVector fixCellData = parseFixCellData(jsonNode);
        DataContainer bootstrapData = builder.dischargeData(dischargeData).volumeData(volumeData).fixData(fixCellData)
                .build();
        return Optional.ofNullable(bootstrapData);
    }

    private static TemporalCellDataPointVector parseDischargeData(final JsonNode jsonNode) {
        String dischargeDataFilePath = jsonNode.get("dischargeDataFilePath").asText();
        TemporalCellDataPointVector dischargeData = new TemporalCellDataPointVector();
        TemporalCellDataPointVectorNodeParser.parseTemporalCellDataPointVectorNode(dischargeData,
                dischargeDataFilePath);
        return dischargeData;
    }

    private static TemporalCellDataPointVector parseVolumeData(final JsonNode jsonNode) {
        String volumeDataFilePath = jsonNode.get("volumeDataFilePath").asText();
        TemporalCellDataPointVector volumeData = new TemporalCellDataPointVector();
        TemporalCellDataPointVectorNodeParser.parseTemporalCellDataPointVectorNode(volumeData, volumeDataFilePath);
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
                long cellId = cellNode.get("cell_id").asInt();
                JsonNode dataNode = cellNode.get("data");
                if (dataNode != null && dataNode.isObject()) {
                    double latitude = dataNode.get("latitude").asDouble();
                    double longitude = dataNode.get("longitude").asDouble();
                    ArrayNode previousCellArray = (ArrayNode) dataNode.get("previous_cells");
                    List<Long> previousCells = new ArrayList<>();
                    for (JsonNode node : previousCellArray) {
                        previousCells.add(node.asLong());
                    }
                    fixDataVector
                            .add(new FixCellDataPoint(cellId, latitude, longitude, previousCells.toArray(new Long[0])));
                }
            }
        }
    }

}
