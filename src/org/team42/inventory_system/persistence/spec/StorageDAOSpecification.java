package org.team42.inventory_system.persistence.spec;

import org.team42.inventory_system.business.BcItem;

public class StorageDAOSpecification {

	private int id;
	private String friendlyName;

	public StorageDAOSpecification(int id, String friendlyName) {
		super();
		this.id = id;
		this.friendlyName = friendlyName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFriendlyName() {
		return friendlyName;
	}

	public void setFriendlyName(String friendlyName) {
		this.friendlyName = friendlyName;
	}

	public BcItem toBcItem() {
		return new BcItem(this.id, this.friendlyName);
	}
}
