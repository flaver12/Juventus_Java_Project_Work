package org.team42.inventory_system.business;

import java.util.ArrayList;
import java.util.List;

import org.team42.inventory_system.persistence.StorageDAOFactory;
import org.team42.inventory_system.persistence.StorageDAO;

public class ItemFactory {

	private static ItemFactory theInstance = null;
	private StorageDAO storageDAO = null;

	private ItemFactory() {
		storageDAO = StorageDAOFactory.getInstance().createStorageDAO();
	}

	public static ItemFactory getInstance() {
		if (theInstance == null) {
			theInstance = new ItemFactory();
		}
		return theInstance;
	}

	public static Item createItem(int id, String friendlyName) {
		return new BCItem(id, friendlyName);
	}

	public static Item createItem(String friendlyName) {
		return new BCItem(friendlyName);
	}

	public Item saveItem(Item item) {
		return this.convertToItem(
				storageDAO.insertItem(item.getFriendlyName())
		);
	}

	public Item updateItem(Item item) {
		try {
			return this.convertToItem(
				storageDAO.updateItem(
					item.getId(),
					item.getFriendlyName()
				)
			);
		} catch (NullPointerException e) {
			return null;
		}

	}

	public Item getItem(int itemId) {
		try {
			return this.convertToItem(storageDAO.getItem(itemId));
		} catch (NullPointerException e) {
			return null;
		}
	}

	public List<Item> getItems() {
		List<Item> itemList = new ArrayList<Item>();

		for (StorageDAO item : storageDAO.getItems()) {
			itemList.add(this.convertToItem(item));
		}

		return itemList;
	}

	private Item convertToItem(StorageDAO storageItem) {
		return new BCItem(storageItem.getId(), storageItem.getFriendlyName());
	}
}
