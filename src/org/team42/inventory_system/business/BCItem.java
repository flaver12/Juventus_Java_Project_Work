package org.team42.inventory_system.business;

public class BCItem extends AbstractItem {

	// Constructor
	public BCItem(int id, String friendlyName) {
		this.id = id;
		this.friendlyName = friendlyName;
	}

	public BCItem(String friendlyName) {
		this.friendlyName = friendlyName;
	}
}
