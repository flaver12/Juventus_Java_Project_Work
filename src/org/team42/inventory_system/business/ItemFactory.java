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
    
    public static Item createItem(int id, String friendlyName){
        return new Item(id, friendlyName);
    }

    public void saveItem(ItemInterface item) {
        storageDAO.insertItem(item.getId(), item.getFriendlyName());
    }
}
