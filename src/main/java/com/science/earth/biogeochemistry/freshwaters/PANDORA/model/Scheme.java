package com.science.earth.biogeochemistry.freshwaters.PANDORA.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 * @author Hoek0024 on 15 mei 2023
 *
 */
@Setter
@Getter
@NoArgsConstructor
@Entity
@SuperBuilder
@Table(name = "schemes")
public class Scheme extends AbstractBaseEntity {

    private static final long serialVersionUID = -4702853862654193516L;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "scheme_reactions", joinColumns = @JoinColumn(name = "scheme_id"), inverseJoinColumns = @JoinColumn(name = "reaction_id"))
    private Set<Reaction> reactions = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "scheme_sources", joinColumns = @JoinColumn(name = "scheme_id"), inverseJoinColumns = @JoinColumn(name = "source_id"))
    private Set<Source> sources = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "scheme_species", joinColumns = @JoinColumn(name = "scheme_id"), inverseJoinColumns = @JoinColumn(name = "specie_id"))
    private Set<Specie> species = new HashSet<>();
    
}
