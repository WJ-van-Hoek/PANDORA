package com.pandora.services.mapcrudservices.test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.pandora.general.objects.AbstractBaseObject;
import com.pandora.services.mapcrudservices.implementations.AbstractBaseMapCrudService;

import lombok.experimental.SuperBuilder;

class AbstractBaseMapCrudServiceTest {
    /**
     * Service instance representing a concrete implementation of the AbstractBaseMapCrudService for managing CRUD
     * operations on ConcreteBaseObject entities. This instance is used for testing the functionality of the
     * AbstractBaseMapCrudService class.
     */
    private ConcreteBaseCommandCrudService concreteBaseCommandCrudService;

    /**
     * A constant representing the ID value used in testing scenarios. This ID is initialized as 1L and is used to
     * simulate the ID of ConcreteBaseObject entities during testing.
     */
    private final Long id = Long.valueOf(1L);

    /**
     * @throws java.lang.Exception
     */
    @BeforeEach
    void setUp() throws Exception {
        concreteBaseCommandCrudService = new ConcreteBaseCommandCrudService();

        ConcreteBaseObject concreteBaseEntity = ConcreteBaseObject.builder().id(id).build();

        concreteBaseCommandCrudService.save(id, concreteBaseEntity);
    }

    @Test
    void testFindAll() {
        Set<ConcreteBaseObject> concreteBaseEntity = concreteBaseCommandCrudService.findAll();

        assertEquals(1, concreteBaseEntity.size());
    }

    @Test
    void testFindById() {
        ConcreteBaseObject baseEntity = concreteBaseCommandCrudService.findById(id);

        assertEquals(id, baseEntity.getId());
    }

    @Test
    void testSaveExistingId() {
        Long idParam = 1L;
        ConcreteBaseObject baseEntity = ConcreteBaseObject.builder().id(idParam).build();

        ConcreteBaseObject savedBaseEntity = concreteBaseCommandCrudService.save(baseEntity);
        assertEquals(id, savedBaseEntity.getId());
    }

    @Test
    void testSaveNoId() {
        ConcreteBaseObject baseEntity = ConcreteBaseObject.builder().build();

        ConcreteBaseObject savedBaseEntity = concreteBaseCommandCrudService.save(baseEntity);
        assertNotNull(savedBaseEntity);
        assertNotNull(savedBaseEntity.getId());
    }

    @Test
    void testDeleteById() {
        assertEquals(1, concreteBaseCommandCrudService.findAll().size());

        concreteBaseCommandCrudService.deleteById(id);

        assertEquals(0, concreteBaseCommandCrudService.findAll().size());
    }

    @Test
    void testDelete() {
        assertEquals(1, concreteBaseCommandCrudService.findAll().size());

        concreteBaseCommandCrudService.delete(concreteBaseCommandCrudService.findById(id));

        assertEquals(0, concreteBaseCommandCrudService.findAll().size());
    }

    @Test
    void testNullCheckThrow() {
        RuntimeException thrown = assertThrows(RuntimeException.class,
                () -> concreteBaseCommandCrudService.nullCheck(null));

        assertTrue(thrown.getMessage().contentEquals("Entity can not be null"));
    }

    @Test
    void testNullCheckNoThrow() {
        ConcreteBaseObject concreteBaseEntity = ConcreteBaseObject.builder().build();
        assertDoesNotThrow(() -> concreteBaseCommandCrudService.nullCheck(concreteBaseEntity));
    }

    @Test
    void testFirstIdOne() {
        concreteBaseCommandCrudService = new ConcreteBaseCommandCrudService();

        ConcreteBaseObject concreteBaseCommandWithoutId = ConcreteBaseObject.builder().build();

        concreteBaseCommandCrudService.save(concreteBaseCommandWithoutId);
        assertEquals(1L, concreteBaseCommandCrudService.findById(1L).getId());
    }

}

class ConcreteBaseCommandCrudService extends AbstractBaseMapCrudService<ConcreteBaseObject> {

}

@SuperBuilder
class ConcreteBaseObject extends AbstractBaseObject {
}
