package com.science.earth.biogeochemistry.freshwaters.PANDORA.errors;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Locale;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.context.MessageSource;

class ErrorMessageGeneratorImplTest {

    @Mock
    private MessageSource messageSource;

    @InjectMocks
    ErrorMessageGeneratorImpl errorMessageGeneratorImpl;

    @BeforeEach
    void setUp() throws Exception {
	MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGenerate() {
	// given
	when(messageSource.getMessage(any(String.class), any(Object[].class), any(Locale.class)))
		.thenReturn("this is a mocked message");
	String message = "this is an error message";
	Object[] args = new Object[] { "object1", "object2" };

	// when
	errorMessageGeneratorImpl.generate(message, args);

	// then
	ArgumentCaptor<String> stringCaptor = ArgumentCaptor.forClass(String.class);
	ArgumentCaptor<Object[]> objectArrayCaptor = ArgumentCaptor.forClass(Object[].class);

	verify(messageSource, times(1)).getMessage(stringCaptor.capture(), objectArrayCaptor.capture(),
		any(Locale.class));
	assertEquals(message, stringCaptor.getValue());
	assertArrayEquals(args, objectArrayCaptor.getValue());
    }

}
