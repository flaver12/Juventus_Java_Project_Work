package persistance;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.team42.inventory_system.persistence.StorageDAO;
import org.team42.inventory_system.persistence.StorageDAOFactory;

class StorageMockFactoryTest {

	@Test
	void testGetInstance() {
		StorageDAOFactory storageFactory = StorageDAOFactory.getInstance();
		assertTrue(storageFactory instanceof StorageDAOFactory);
	}

	@Test
	void testCreateStorageDAO() {
		StorageDAOFactory storageFactory = StorageDAOFactory.getInstance();
		assertTrue(storageFactory.createStorageDAO() instanceof StorageDAO);
	}

}
