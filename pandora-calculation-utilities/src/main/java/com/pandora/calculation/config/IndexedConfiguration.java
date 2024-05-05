package com.pandora.calculation.config;

import lombok.NoArgsConstructor;

/**
 * @author Wim Joost van Hoek
 * @version 0.0.1
 * @since 0.0.1
 */
@NoArgsConstructor
public abstract class IndexedConfiguration {

    /**
     * The index associated with the configuration.
     */
    private Integer _index;

    /**
     * Flag to track whether the index has been initialized.
     */
    private boolean _indexed = false;

    /**
     * Gets the index.
     *
     * @return The index.
     */
    public Integer getIndex() {
        return _index;
    }

    /**
     * Sets the index for the configuration. This method should only be called once to initialize the index.
     *
     * @param index the index to set
     * @throws IllegalStateException if the index has already been initialized
     */
    public final void setIndex(final int index) {
        if (!_indexed) {
            _index = index;
            _indexed = true;
        } else {
            // Throw an IllegalStateException or handle the case where index is already set
            throw new IllegalStateException("Index has already been set.");
        }
    }
}
