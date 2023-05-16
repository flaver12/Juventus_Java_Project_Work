package org.team42.inventory_system.persistence;

import java.util.List;

import org.team42.inventory_system.persistence.spec.StorageDAOSpecification;

public interface StorageDAOInterface {

	public void insertItem(String friendlyName);

	public void updateItem(int itemId, String friendlyName);

	public StorageDAOSpecification getItem(int itemId);

	public List<StorageDAOSpecification> getItems();
}
