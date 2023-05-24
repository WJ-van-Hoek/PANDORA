package com.science.earth.biogeochemistry.freshwaters.pandora.model.inputs.params;

import com.science.earth.biogeochemistry.freshwaters.pandora.model.AbstractBaseEntity;
import com.science.earth.biogeochemistry.freshwaters.pandora.model.inputs.SourceInputEntity;
import com.science.earth.biogeochemistry.freshwaters.pandora.model.inputs.SpecieInputEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class SourceFraction extends AbstractBaseEntity {

    private static final long serialVersionUID = 24109037202595284L;
    
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "specie_id")
    private SpecieInputEntity specie;
    
    private float fractional;
    
    @ManyToOne
    @JoinColumn(name = "source_id")
    private SourceInputEntity source;
}
