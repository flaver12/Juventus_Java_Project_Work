package org.team42.inventory_system.business;

import org.team42.inventory_system.persistence.StorageDAOFactory;
import org.team42.inventory_system.persistence.StorageDAOInterface;

public class ItemFactory {

    private static ItemFactory theInstance = null;
    private StorageDAOInterface storageDAO = null;

    private ItemFactory(){
        storageDAO = StorageDAOFactory.getInstance().createStorageDAO();
    }

    public static ItemFactory getInstance() {
		if(theInstance == null) {
			theInstance =  new ItemFactory();
		}
		return theInstance;
	}
    
    public static BcItem createItem(int id, String friendlyName){
        return new BcItem(id, friendlyName);
    }

    public void saveItem(Item item) {
        storageDAO.insertItem(item.getId(), item.getFriendlyName());
    }
}
