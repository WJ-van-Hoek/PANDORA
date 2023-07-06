package com.science.earth.biogeochemistry.freshwaters.pandora.services.commandcrudservices;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.science.earth.biogeochemistry.freshwaters.pandora.commands.AbstractBaseCommand;

import lombok.experimental.SuperBuilder;

class AbstractBaseCommandCrudServiceTest {

    ConcreteBaseCommandCrudService concreteBaseCommandCrudService;

    final Long id = Long.valueOf(1l);

    /**
     * @throws java.lang.Exception
     */
    @BeforeEach
    void setUp() throws Exception {
	concreteBaseCommandCrudService = new ConcreteBaseCommandCrudService();

	ConcreteBaseCommand concreteBaseEntity = ConcreteBaseCommand.builder().id(id).build();

	concreteBaseCommandCrudService.save(id, concreteBaseEntity);
    }

    @Test
    void testFindAll() {
	Set<ConcreteBaseCommand> concreteBaseEntity = concreteBaseCommandCrudService.findAll();

	assertEquals(1, concreteBaseEntity.size());
    }

    @Test
    void testFindById() {
	ConcreteBaseCommand baseEntity = concreteBaseCommandCrudService.findById(id);

	assertEquals(id, baseEntity.getId());
    }

    @Test
    void testSaveExistingId() {
	Long id = 2L;
	ConcreteBaseCommand baseEntity = ConcreteBaseCommand.builder().id(id).build();

	ConcreteBaseCommand savedBaseEntity = concreteBaseCommandCrudService.save(baseEntity);
	assertEquals(id, savedBaseEntity.getId());
    }

    @Test
    void testSaveNoId() {
	ConcreteBaseCommand baseEntity = ConcreteBaseCommand.builder().build();

	ConcreteBaseCommand savedBaseEntity = concreteBaseCommandCrudService.save(baseEntity);
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
	ConcreteBaseCommand concreteBaseEntity = ConcreteBaseCommand.builder().build();
	assertDoesNotThrow(() -> concreteBaseCommandCrudService.nullCheck(concreteBaseEntity));
    }

}

class ConcreteBaseCommandCrudService extends AbstractBaseCommandCrudService<ConcreteBaseCommand> {

}

@SuperBuilder
class ConcreteBaseCommand extends AbstractBaseCommand {
}
