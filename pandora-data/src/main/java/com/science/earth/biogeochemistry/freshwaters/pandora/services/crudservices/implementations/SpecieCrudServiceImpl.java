package com.science.earth.biogeochemistry.freshwaters.pandora.services.crudservices.implementations;

import org.springframework.stereotype.Service;

import com.science.earth.biogeochemistry.freshwaters.pandora.errors.ErrorMessageGenerator;
import com.science.earth.biogeochemistry.freshwaters.pandora.model.Specie;
import com.science.earth.biogeochemistry.freshwaters.pandora.repositories.SpecieRepository;
import com.science.earth.biogeochemistry.freshwaters.pandora.services.crudservices.interfaces.SpecieCrudService;

@Service
public class SpecieCrudServiceImpl extends AbstractBaseEntityCrudServiceImpl<Specie, SpecieRepository<Specie>>
	implements SpecieCrudService {

    protected SpecieCrudServiceImpl(SpecieRepository<Specie> repository, ErrorMessageGenerator errorMessageGenerator) {
	super(repository, errorMessageGenerator);
    }

}
