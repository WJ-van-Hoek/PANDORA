package com.science.earth.biogeochemistry.freshwaters.pandora.model.inputs;

import java.util.HashSet;
import java.util.Set;

import com.science.earth.biogeochemistry.freshwaters.pandora.model.inputs.params.SourceFraction;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "sources")
public abstract class SourceInputEntity extends AbstractInputEntity {

    private static final long serialVersionUID = 6079241974433175927L;
    
    // CascadeType all means that if I delete a source, it is going to cascade down
    // by deleting their associated source fractions too
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "source")
    private Set<SourceFraction> fractionals = new HashSet<>();
    
    protected SourceInputEntity(Long id, String name, Set<SourceFraction> fractionals) {
	super(id, name);
	this.fractionals = fractionals;
    }
}
