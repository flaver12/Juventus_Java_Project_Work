package org.team42.inventory_system.persistence;

import java.util.List;

/**
 * Interface für DAO
 */
public interface StorageDAO {

	public StorageDAO insertItem(String friendlyName);

	public StorageDAO updateItem(int itemId, String friendlyName);

	public StorageDAO getItem(int itemId);

	public List<StorageDAO> getItems();

	public void setFriendlyName(String friendlyName);

	public String getFriendlyName();

	public int getId();

	public void setId(int id);
}
