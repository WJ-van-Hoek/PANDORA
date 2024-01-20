package com.pandora.model;

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
    /**
     * Reference to the next cell in a sequence.
     */
    private CellDBEntity nextCell;

    /**
     * Constructs a new {@code CellDBEntity} with the specified ID and reference to the next cell.
     *
     * @param idParam The unique identifier (ID) for the cell.
     * @param nextCellParam The reference to the next cell in the sequence.
     */
    public CellDBEntity(final Long idParam, final CellDBEntity nextCellParam) {
        super(idParam);
        this.nextCell = nextCellParam;
    }
}
