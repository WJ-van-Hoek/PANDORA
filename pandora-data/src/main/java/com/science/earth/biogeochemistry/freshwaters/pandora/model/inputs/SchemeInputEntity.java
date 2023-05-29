package com.science.earth.biogeochemistry.freshwaters.pandora.model.inputs;

import java.util.HashSet;
import java.util.Set;

import com.science.earth.biogeochemistry.freshwaters.pandora.model.inputs.params.FloatInputParam;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Hoek0024 on 15 mei 2023
 *
 */
@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "schemes")
public class SchemeInputEntity extends AbstractInputEntity {

    private static final long serialVersionUID = -4702853862654193516L;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "scheme_reactions", joinColumns = @JoinColumn(name = "scheme_id"), inverseJoinColumns = @JoinColumn(name = "reaction_id"))
    private Set<ReactionInputEntity> reactions = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "scheme_sources", joinColumns = @JoinColumn(name = "scheme_id"), inverseJoinColumns = @JoinColumn(name = "source_id"))
    private Set<SourceInputEntity> sources = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "scheme_species", joinColumns = @JoinColumn(name = "scheme_id"), inverseJoinColumns = @JoinColumn(name = "specie_id"))
    private Set<SpecieInputEntity> species = new HashSet<>();

    @Builder
    public SchemeInputEntity(Long id, String name, Set<ReactionInputEntity> reactions, Set<SourceInputEntity> sources,
	    Set<SpecieInputEntity> species, Set<FloatInputParam> floatInputParams) {
	super(id, name, floatInputParams);
	this.reactions = ((reactions == null) || (reactions.isEmpty())) ? new HashSet<>() : reactions;
	this.sources = ((sources == null) || (sources.isEmpty())) ? new HashSet<>() : sources;
	this.species = ((species == null) || (species.isEmpty())) ? new HashSet<>() : species;
    }

}
