/**
 * 
 */
package com.science.earth.biogeochemistry.freshwaters.pandora.model.inputs;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
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
@AllArgsConstructor
@Entity
@SuperBuilder
@Table(name = "reactions")
public abstract class ReactionInputEntity extends AbstractInputEntity {

    private static final long serialVersionUID = -2032204521712978301L;
    
    private float rate;
    
    protected ReactionInputEntity(Long id, String name, float rate) {
	super(id, name);
	this.rate = rate;
    }

}
