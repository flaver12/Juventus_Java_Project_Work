package org.team42.inventory_system.business;

import java.util.List;
import java.util.stream.Collectors;

import org.team42.inventory_system.persistence.StorageDAOFactory;
import org.team42.inventory_system.persistence.StorageDAOInterface;

public class ItemFactory {

	private static ItemFactory theInstance = null;
	private StorageDAOInterface storageDAO = null;

	private ItemFactory() {
		storageDAO = StorageDAOFactory.getInstance().createStorageDAO();
	}

	public static ItemFactory getInstance() {
		if (theInstance == null) {
			theInstance = new ItemFactory();
		}
		return theInstance;
	}

	public static BcItem createItem(int id, String friendlyName) {
		return new BcItem(id, friendlyName);
	}

	public static BcItem createItem(String friendlyName) {
		return new BcItem(friendlyName);
	}

	public void saveItem(Item item) {
		storageDAO.insertItem(item.getFriendlyName());
	}

	public void updateItem(Item item) {
		storageDAO.updateItem(item.getId(), item.getFriendlyName());
	}

	public Item getItem(int itemId) {
		return storageDAO.getItem(itemId).toBcItem();
	}

	public List<Item> getItems() {
		return storageDAO.getItems().stream().map(i -> i.toBcItem()).collect(Collectors.toList());
	}
}
