package com.science.earth.biogeochemistry.freshwaters.pandora.model.inputs;

import java.util.Set;

import com.science.earth.biogeochemistry.freshwaters.pandora.model.inputs.params.FloatInputParam;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "sources")
public class SourceInputEntity extends AbstractInputEntity {

    private static final long serialVersionUID = 6079241974433175927L;

    @Builder  
    public SourceInputEntity(Long id, String name, Set<FloatInputParam> floatInputParams) {
	super(id, name, floatInputParams);
    }
}
