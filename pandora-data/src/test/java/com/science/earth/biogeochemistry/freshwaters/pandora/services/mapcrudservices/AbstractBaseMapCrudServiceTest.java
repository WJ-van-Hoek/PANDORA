package com.science.earth.biogeochemistry.freshwaters.pandora.services.mapcrudservices;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.AbstractBaseObject;
import com.science.earth.biogeochemistry.freshwaters.pandora.services.mapcrudservices.implementations.AbstractBaseMapCrudService;

import lombok.experimental.SuperBuilder;

class AbstractBaseMapCrudServiceTest {

    ConcreteBaseCommandCrudService concreteBaseCommandCrudService;

    final Long id = Long.valueOf(1l);

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
	Long id = 2L;
	ConcreteBaseObject baseEntity = ConcreteBaseObject.builder().id(id).build();

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
	assertEquals(1l, concreteBaseCommandCrudService.findById(1l).getId());
    }

}

class ConcreteBaseCommandCrudService extends AbstractBaseMapCrudService<ConcreteBaseObject> {

}

@SuperBuilder
class ConcreteBaseObject extends AbstractBaseObject {
}
