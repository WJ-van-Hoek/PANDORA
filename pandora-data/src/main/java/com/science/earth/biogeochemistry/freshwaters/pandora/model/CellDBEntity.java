package com.science.earth.biogeochemistry.freshwaters.pandora.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "cells")
public class CellDBEntity extends AbstractBaseDBEntity {

    private CellDBEntity nextCell;

    /**
     * @param id
     * @param nextCell
     */
    public CellDBEntity(Long id, CellDBEntity nextCell) {
        super(id);
        this.nextCell = nextCell;
    }

}
