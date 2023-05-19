package com.science.earth.biogeochemistry.freshwaters.PANDORA.services.crudservices.implementations;

import org.springframework.stereotype.Service;

import com.science.earth.biogeochemistry.freshwaters.PANDORA.errors.ErrorMessageGenerator;
import com.science.earth.biogeochemistry.freshwaters.PANDORA.model.Specie;
import com.science.earth.biogeochemistry.freshwaters.PANDORA.repositories.SpecieRepository;
import com.science.earth.biogeochemistry.freshwaters.PANDORA.services.crudservices.interfaces.SpecieCrudService;

@Service
public class SpecieCrudServiceImpl extends AbstractBaseEntityCrudServiceImpl<Specie, SpecieRepository<Specie>>
	implements SpecieCrudService {

    protected SpecieCrudServiceImpl(SpecieRepository<Specie> repository, ErrorMessageGenerator errorMessageGenerator) {
	super(repository, errorMessageGenerator);
    }

}
