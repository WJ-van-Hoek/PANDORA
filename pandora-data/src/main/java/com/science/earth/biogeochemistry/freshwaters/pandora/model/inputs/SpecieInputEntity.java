/**
 * 
 */
package com.science.earth.biogeochemistry.freshwaters.pandora.model.inputs;

import java.util.Set;

import com.science.earth.biogeochemistry.freshwaters.pandora.model.inputs.params.FloatInputParam;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 * @author Hoek0024 on 13 mei 2023
 *
 */
@Setter
@Getter
@NoArgsConstructor
@Entity
@SuperBuilder
@Table(name = "species")
public abstract class SpecieInputEntity extends AbstractInputEntity {

    private static final long serialVersionUID = -4713024593142103209L;

    private String unit;

    private int molarMass;

    protected SpecieInputEntity(Long id, String name, String unit, int molarMass, Set<FloatInputParam> floatInputParams) {
	super(id, name, floatInputParams);
	this.unit = unit;
	this.molarMass = molarMass;
    }
}
