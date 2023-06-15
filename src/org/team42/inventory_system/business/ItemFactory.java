package org.team42.inventory_system.business;

import java.util.ArrayList;
import java.util.List;

import org.team42.inventory_system.persistence.StorageDAOFactory;
import org.team42.inventory_system.persistence.StorageDAO;

/**
 * Die ItemFactory wird genutzt, um Instanzen der Klasse BCItem zu erzeugen
 */
public class ItemFactory {

	private static ItemFactory theInstance = null;
	private StorageDAO storageDAO = null;

	private ItemFactory() {
		storageDAO = StorageDAOFactory.getInstance().createStorageDAO();
	}

	/**
	 * Prüft, ob die Instanz existiert oder nicht.
	 * Wenn sie nicht existiert, wird sie erzeugt.
	 * @return Gibt die Instanz zurück
	 */
	public static ItemFactory getInstance() {
		if (theInstance == null) {
			theInstance = new ItemFactory();
		}
		return theInstance;
	}

	/**
	 * Erstellt ein Item
	 * @param id Eindeutige ID des Items
	 * @param friendlyName Bezeichnung des Items
	 * @return Gibt das erstellte BCItem zurück
	 */
	public static Item createItem(int id, String friendlyName) {
		return new BCItem(id, friendlyName);
	}

	/**
	 * Erstellt ein Item nur mit der Bezeichnung, ohne ID
	 * @param friendlyName Bezeichnung des Items
	 * @return Gibt das erstellte BCItem zurück
	 */
	public static Item createItem(String friendlyName) {
		return new BCItem(friendlyName);
	}

	public Item saveItem(Item item) {
		return this.convertToItem(
				storageDAO.insertItem(item.getFriendlyName())
		);
	}

	/**
	 * Aktualisiert das Item
	 * @param item
	 * @return ??
	 */
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

	/**
	 * Holt die Informationen von einem einzelnen Item anhand der itemID
	 * @param itemId Einzigartige ID des gewüschnten Items
	 * @return Gibt das Item oder Null zurück
	 */
	public Item getItem(int itemId) {
		try {
			return this.convertToItem(storageDAO.getItem(itemId));
		} catch (NullPointerException e) {
			return null;
		}
	}

	/**
	 * Liest alle gespeicherten Items aus
	 * @return Gibt eine Liste der gespeicherten Items zurück
	 */
	public List<Item> getItems() {
		List<Item> itemList = new ArrayList<Item>();

		for (StorageDAO item : storageDAO.getItems()) {
			itemList.add(this.convertToItem(item));
		}

		return itemList;
	}

	/**
	 * 
	 * @param storageItem
	 * @return BCItem
	 */
	private Item convertToItem(StorageDAO storageItem) {
		return new BCItem(storageItem.getId(), storageItem.getFriendlyName());
	}
}
