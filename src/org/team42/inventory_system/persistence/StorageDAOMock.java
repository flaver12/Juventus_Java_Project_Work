package org.team42.inventory_system.persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.team42.inventory_system.persistence.spec.StorageDAOSpecification;

public class StorageDAOMock implements StorageDAOInterface {

	private static final AtomicInteger sequence = new AtomicInteger();
	private List<StorageDAOSpecification> items = new ArrayList<StorageDAOSpecification>();

	@Override
	public StorageDAOSpecification insertItem(String friendlyName) {
		final int generatedId = next();
		this.items.add(generatedId, new StorageDAOSpecification(generatedId, friendlyName));
		return this.items.get(generatedId);
	}

	@Override
	public StorageDAOSpecification updateItem(int itemId, String friendlyName) {
		try {
			this.items.get(itemId).setFriendlyName(friendlyName);
			return this.items.get(itemId);
		} catch (IndexOutOfBoundsException e) {
			return null;
		}

	}

	@Override
	public StorageDAOSpecification getItem(int itemId) {
		try {
			return this.items.get(itemId);
		} catch (IndexOutOfBoundsException e) {
			return null;
		}
	}

	@Override
	public List<StorageDAOSpecification> getItems() {
		return this.items;
	}

	private static int next() {
		return sequence.getAndIncrement();
	}
}
