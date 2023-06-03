/**
 * 
 */
package com.science.earth.biogeochemistry.freshwaters.pandora.model.inputs;

import java.util.Set;

import com.science.earth.biogeochemistry.freshwaters.pandora.model.inputs.params.FloatInputParam;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Hoek0024 on 13 mei 2023
 *
 */
@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "species")
public class SpecieInputEntity extends AbstractInputEntity {

    private static final long serialVersionUID = -4713024593142103209L;

    private String unit;

    private int molarMass;

    @Builder
    public SpecieInputEntity(Long id, String name, String unit, int molarMass, Set<FloatInputParam> floatInputParams) {
	super(id, name, floatInputParams);
	this.unit = unit;
	this.molarMass = molarMass;
    }
}
