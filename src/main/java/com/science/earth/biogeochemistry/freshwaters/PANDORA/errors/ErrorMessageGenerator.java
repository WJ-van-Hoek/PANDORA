package com.science.earth.biogeochemistry.freshwaters.PANDORA.errors;

public interface ErrorMessageGenerator {
    public String generate(String messageProperty, Object... args);
}
