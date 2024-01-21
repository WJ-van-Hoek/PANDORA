package com.pandora.general.objects.services.implementations;

import org.springframework.stereotype.Service;

import com.pandora.general.objects.River;
import com.pandora.general.objects.services.abstractions.classes.AbstractBaseMapCrudService;

/**
 * RiverMapCrudService is an implementation of the {@link AbstractBaseMapCrudService} class, providing CRUD (Create,
 * Read, Update, Delete) operations for managing {@link River} objects. This service is annotated with {@link Service}
 * to indicate that it is a Spring service component.
 *
 * @version 0.0.1
 * @author Wim Joost van Hoek
 * @see AbstractBaseMapCrudService
 * @see River
 * @see Service
 */
@Service
public class RiverMapCrudService extends AbstractBaseMapCrudService<River> {
}
