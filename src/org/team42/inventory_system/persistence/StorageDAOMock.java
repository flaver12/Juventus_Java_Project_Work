package org.team42.inventory_system.persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class StorageDAOMock implements StorageDAO {

	private static final AtomicInteger sequence = new AtomicInteger();
	private List<StorageDAO> items = new ArrayList<StorageDAO>();

	private String friendlyName;
	private int id;

	@Override
	public StorageDAO insertItem(String friendlyName) {
		StorageDAO item = new StorageDAOMock();
		item.setId(next());
		item.setFriendlyName(friendlyName);

		items.add(id, item);
		return item;
	}

	@Override
	public StorageDAO getItem(int itemId) {
		return this.items.get(id);
	}

	@Override
	public StorageDAO updateItem(int itemId, String friendlyName) {
		try {
			this.items.get(itemId).setFriendlyName(friendlyName);
			return this.items.get(itemId);
		} catch (IndexOutOfBoundsException e) {
			return null;
		}
	}

	@Override
	public List<StorageDAO> getItems() {
		return this.items;
	}

	public void setFriendlyName(String friendlyName) {
		this.friendlyName = friendlyName;
	}

	@Override
	public int getId() {
		return this.id;
	}

	@Override
	public String getFriendlyName() {
		return this.friendlyName;
	}

	@Override
	public void setId(int id) {
		this.id = id;
	}

	private static int next() {
		return sequence.getAndIncrement();
	}

}
