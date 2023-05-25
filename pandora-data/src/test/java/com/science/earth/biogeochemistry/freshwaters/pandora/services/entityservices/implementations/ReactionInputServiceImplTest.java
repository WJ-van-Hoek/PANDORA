package com.science.earth.biogeochemistry.freshwaters.pandora.services.entityservices.implementations;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.science.earth.biogeochemistry.freshwaters.pandora.errors.ErrorMessageGenerator;

class ReactionInputServiceImplTest {
    
    @Mock
    ErrorMessageGenerator errorMessageGenerator;

    @InjectMocks
    ReactionInputServiceImpl reactionServiceImpl;

    @BeforeEach
    void setUp() throws Exception {
	MockitoAnnotations.openMocks(this);
    }

    @Test
    void testReactionServiceImpl() {
	assertEquals(errorMessageGenerator, reactionServiceImpl.errorMessageGenerator);
    }

}
