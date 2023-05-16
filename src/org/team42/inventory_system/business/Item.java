package org.team42.inventory_system.business;

public interface Item {
	public int getId();

	public String getFriendlyName();

	public void setId(int id);

	public void setFriendlyName(String friendlyName);
}
