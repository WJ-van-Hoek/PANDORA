package com.science.earth.biogeochemistry.freshwaters.pandora.errors;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

@Component
public class ErrorMessageGeneratorImpl implements ErrorMessageGenerator {

    @Autowired
    private MessageSource messageSource;

    public ErrorMessageGeneratorImpl(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public String generate(String messageProperty, Object... args) {
        return messageSource.getMessage(messageProperty, args, Locale.getDefault());
    }
}
