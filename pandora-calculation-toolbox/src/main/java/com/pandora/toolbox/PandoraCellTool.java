package com.pandora.toolbox;

import com.pandora.calculation.bootstrap.BootstrapParams;
import com.pandora.calculation.parsers.CommandLineToolParser;
import com.pandora.calculation.parsers.Parsable;

//TODO write javdocs
/**
 *
 */
public class PandoraCellTool {
    /**
     * @param args
     */
    public static void main(final String[] args) {
        Parsable<BootstrapParams> params = BootstrapParams.builder().build();
        BootstrapParams bootstrapParams = CommandLineToolParser.parseArgs(args, params);
    }

}
