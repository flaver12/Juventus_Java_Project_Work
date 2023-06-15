package org.team42.inventory_system.business;

/**
 * Das Interface "Item" definiert die Methoden für die Kinder-Klassen
 */

public interface Item {
	public int getId();

	public String getFriendlyName();

	public void setId(int id);

	public void setFriendlyName(String friendlyName);
}
