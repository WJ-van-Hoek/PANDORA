package com.science.earth.biogeochemistry.freshwaters.PANDORA.model;

import java.util.HashSet;
import java.util.Set;

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
public abstract class Source extends AbstractBaseEntity {

    private static final long serialVersionUID = 6079241974433175927L;
    
    // CascadeType all means that if I delete a source, it is going to cascade down
    // by deleting their associated source fractions too
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "source")
    private Set<SourceFraction> fractionals = new HashSet<>();
}
