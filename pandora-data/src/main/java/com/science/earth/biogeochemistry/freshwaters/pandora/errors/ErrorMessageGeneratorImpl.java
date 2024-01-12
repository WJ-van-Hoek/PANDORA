package com.science.earth.biogeochemistry.freshwaters.pandora.errors;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

@Component
public class ErrorMessageGeneratorImpl implements ErrorMessageGenerator {

    /**
     * The {@code messageSource} attribute in the {@link ErrorMessageGeneratorImpl} class represents a Spring
     * {@link org.springframework.context.MessageSource} instance. This component is responsible for providing a
     * mechanism to resolve messages based on a message code and optional arguments, with support for
     * internationalization and localization.
     *
     * <p>
     * This attribute is annotated with {@code @Autowired}, indicating that it is injected by the Spring container
     * during the instantiation of the {@code ErrorMessageGeneratorImpl} bean.
     *
     * <p>
     * The primary purpose of this attribute is to facilitate the generation of error messages within the
     * {@code ErrorMessageGeneratorImpl} class. The {@code messageSource} is used in the
     * {@link #generate(String, Object...)} method to retrieve the actual localized message based on the specified
     * message property and optional arguments.
     *
     * <p>
     * It is expected that an instance of this class is created with a {@code MessageSource} dependency, which is
     * injected through the constructor.
     *
     * @see org.springframework.context.MessageSource
     * @see org.springframework.beans.factory.annotation.Autowired
     * @see com.science.earth.biogeochemistry.freshwaters.pandora.errors.ErrorMessageGeneratorImpl
     */
    @Autowired
    private MessageSource messageSource;

    /**
     * Constructs a new {@code ErrorMessageGeneratorImpl} with the specified {@link MessageSource}.
     *
     * @param messageSourceParam The {@code MessageSource} to be used for retrieving localized error messages.
     */
    public ErrorMessageGeneratorImpl(final MessageSource messageSourceParam) {
        this.messageSource = messageSourceParam;
    }

    /**
     * Generates an error message based on the provided message property and optional arguments.
     *
     * @param messageProperty The key or code of the message property to retrieve.
     * @param args Optional arguments to be used in formatting the error message.
     * @return The generated error message.
     */
    public final String generate(final String messageProperty, final Object... args) {
        return messageSource.getMessage(messageProperty, args, Locale.getDefault());
    }
}
