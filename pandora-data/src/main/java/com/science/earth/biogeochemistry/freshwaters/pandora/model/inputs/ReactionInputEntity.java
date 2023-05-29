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
@Table(name = "reactions")
public abstract class ReactionInputEntity extends AbstractInputEntity {

    private static final long serialVersionUID = -2032204521712978301L;

    protected ReactionInputEntity(Long id, String name, Set<FloatInputParam> floatInputParams) {
	super(id, name, floatInputParams);
    }

}
