package org.team42.inventory_system.business;

public class BcItem extends AbstractItem {

	// Constructor
	public BcItem(int id, String friendlyName) {
		this.id = id;
		this.friendlyName = friendlyName;
	}

	public BcItem(String friendlyName) {
		this.friendlyName = friendlyName;
	}
}
