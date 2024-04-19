package com.pandora.calculation.parsers;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.apache.commons.cli.CommandLine;
import org.junit.jupiter.api.Test;

import com.pandora.calculation.config.SpecieConfiguration;

class SpecieConfigParserTest {

    @Test
    void testParseSpecieConfigsReturnsEmptyOptional() {
        // Arrange
        CommandLine cmd = mock(CommandLine.class);
        when(cmd.hasOption("specieConfigurations")).thenReturn(false);

        // Act
        Optional<List<SpecieConfiguration>> result = SpecieConfigParser.parse(cmd);

        // Assert
        assertTrue(result.isEmpty());
    }

}
