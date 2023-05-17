package org.team42.inventory_system.persistence;

public class StorageDAOFactory {

	private static StorageDAOFactory Instance = null;

	private StorageDAOFactory() {

	}

	public static StorageDAOFactory getInstance() {
		if (Instance == null) {
			Instance = new StorageDAOFactory();
		}
		return Instance;
	}

	public StorageDAO createStorageDAO() {
		return new StorageDAOMock();
	}
}
