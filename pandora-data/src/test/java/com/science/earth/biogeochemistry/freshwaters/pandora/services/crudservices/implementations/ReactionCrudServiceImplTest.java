package com.science.earth.biogeochemistry.freshwaters.pandora.services.crudservices.implementations;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.science.earth.biogeochemistry.freshwaters.pandora.errors.ErrorMessageGenerator;
import com.science.earth.biogeochemistry.freshwaters.pandora.model.inputs.ReactionInputEntity;
import com.science.earth.biogeochemistry.freshwaters.pandora.repositories.ReactionRepository;

class ReactionCrudServiceImplTest {

    @Mock
    ReactionRepository<ReactionInputEntity> reactionRepository;

    @Mock
    ErrorMessageGenerator errorMessageGenerator;

    @InjectMocks
    ReactionCrudServiceImpl reactionCrudServiceImpl;

    @BeforeEach
    void setUp() throws Exception {
	MockitoAnnotations.openMocks(this);
    }

    @Test
    void testReactionCrudServiceImpl() {
	assertEquals(reactionRepository, reactionCrudServiceImpl.repository);
    }

}
