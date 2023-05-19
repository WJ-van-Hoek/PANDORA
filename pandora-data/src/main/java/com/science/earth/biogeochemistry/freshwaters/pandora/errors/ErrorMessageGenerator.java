package com.science.earth.biogeochemistry.freshwaters.pandora.errors;

public interface ErrorMessageGenerator {
    public String generate(String messageProperty, Object... args);
}
