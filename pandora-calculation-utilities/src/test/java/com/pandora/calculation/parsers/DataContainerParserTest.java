package com.pandora.calculation.parsers;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

import org.apache.commons.cli.CommandLine;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.pandora.calculation.data.DataContainer;

@ExtendWith(MockitoExtension.class)
class DataContainerParserTest {

    @Mock
    private CommandLine _cmd;

    private static final String VALID_TEST_FILE_PATH;

    private static final String NON_EXISTING_TEST_FILE_PATH;

    private static final String INVALID_TEST_FILE_PATH;

    static {
        String validFilename = "dataContainerParserTestFile.json";
        String nonExistingFilename = "nonExistingDataContainerParserTestFile.json";
        String invalidFilename = "invalidDataContainerParserTestFile.json";
        Path validTestFilePath = Paths.get("src", "test", "resources", validFilename);
        Path nonExistingTestFilePath = Paths.get("src", "test", "resources", nonExistingFilename);
        Path invalidTestFilePath = Paths.get("src", "test", "resources", invalidFilename);
        VALID_TEST_FILE_PATH = validTestFilePath.toAbsolutePath().toString();
        NON_EXISTING_TEST_FILE_PATH = nonExistingTestFilePath.toAbsolutePath().toString();
        INVALID_TEST_FILE_PATH = invalidTestFilePath.toAbsolutePath().toString();
    }

    @Test
    void testParseNoBootstrapDataOptionReturnsEmpty() {
        when(_cmd.hasOption("bootstrapData")).thenReturn(false);
        Optional<DataContainer> result = DataContainerParser.parse(_cmd);
        assertTrue(result.isEmpty());
    }

    @Test
    void testParseValidFileReturnsDataContainer() {
        Optional<DataContainer> result = DataContainerParser.parse(VALID_TEST_FILE_PATH);
        assertTrue(result.isPresent());
    }

    @Test
    void testParseFileNotFoundReturnsEmpty() {
        Optional<DataContainer> result = DataContainerParser.parse(NON_EXISTING_TEST_FILE_PATH);
        assertTrue(result.isEmpty());
    }

    @Test
    void testParseInvalidJsonReturnsEmpty() {
        Optional<DataContainer> result = DataContainerParser.parse(INVALID_TEST_FILE_PATH);
        assertTrue(result.isEmpty());
    }
}
