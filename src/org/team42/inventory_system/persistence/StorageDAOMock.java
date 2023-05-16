package org.team42.inventory_system.persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.team42.inventory_system.persistence.spec.StorageDAOSpecification;

public class StorageDAOMock implements StorageDAOInterface {

	private static final AtomicInteger sequence = new AtomicInteger();
	private List<StorageDAOSpecification> items = new ArrayList<StorageDAOSpecification>();

	@Override
	public void insertItem(String friendlyName) {
		final int generatedId = next();
		this.items.add(generatedId, new StorageDAOSpecification(generatedId, friendlyName));
	}

	@Override
	public void updateItem(int itemId, String friendlyName) {
		this.items.get(itemId).setFriendlyName(friendlyName);
	}

	@Override
	public StorageDAOSpecification getItem(int itemId) {
		return this.items.get(itemId);
	}

	@Override
	public List<StorageDAOSpecification> getItems() {
		return this.items;
	}

	private static int next() {
		return sequence.getAndIncrement();
	}
}
