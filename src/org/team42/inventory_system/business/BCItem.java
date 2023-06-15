package org.team42.inventory_system.business;

public class BCItem extends AbstractItem {

	/**
	 * Konstruktor für BCItem
	 * @param id Einzigartige ID des Items
	 * @param friendlyName Bezeichnung des Items
	 */
	public BCItem(int id, String friendlyName) {
		this.id = id;
		this.friendlyName = friendlyName;
	}

	/**
	 * Konstruktor für BCItem
	 */
	public BCItem(String friendlyName) {
		this.friendlyName = friendlyName;
	}
}
