package org.team42.inventory_system.persistence;

public class StorageDAOFactory {
    
    private static StorageDAOFactory theInstance = null;

    private StorageDAOFactory() {

    }

    public static StorageDAOFactory getInstance(){
        if (theInstance == null) {
			theInstance = new StorageDAOFactory();
		}
		return theInstance;
    }

    public StorageDAOInterface createStorageDAO(){
        return new StorageDAOMock();
    }

}
