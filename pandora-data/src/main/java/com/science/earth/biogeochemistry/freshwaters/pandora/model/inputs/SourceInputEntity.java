package com.science.earth.biogeochemistry.freshwaters.pandora.model.inputs;

import java.util.Set;

import com.science.earth.biogeochemistry.freshwaters.pandora.model.inputs.params.FloatInputParam;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Setter
@Getter
@NoArgsConstructor
@Entity
@SuperBuilder
@Table(name = "sources")
public abstract class SourceInputEntity extends AbstractInputEntity {

    private static final long serialVersionUID = 6079241974433175927L;
        
    protected SourceInputEntity(Long id, String name, Set<FloatInputParam> floatInputParams) {
	super(id, name, floatInputParams);
    }
}
