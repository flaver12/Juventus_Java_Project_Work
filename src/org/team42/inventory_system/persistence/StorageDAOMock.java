package org.team42.inventory_system.persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class StorageDAOMock implements StorageDAO {

	private static final AtomicInteger sequence = new AtomicInteger();
	private List<StorageDAO> items = new ArrayList<StorageDAO>();

	private String friendlyName;
	private int id;

	/** 
	 * @param friendlyName Bezeichnung des BCItems
	 * @return StorageDAO
	 */
	@Override
	public StorageDAO insertItem(String friendlyName) {
		StorageDAO item = new StorageDAOMock();
		item.setId(next());
		item.setFriendlyName(friendlyName);

		items.add(id, item);
		return item;
	}

	/** 
	 * @param itemId Einzigartige ID des BCItems
	 * @return StorageDAO
	 */
	@Override
	public StorageDAO getItem(int itemId) {
		return this.items.get(id);
	}

	/** 
	 * @param itemId Einzigartige ID des BCItems
	 * @param friendlyName Bezeichnung des BCItems
	 * @return StorageDAO
	 */
	@Override
	public StorageDAO updateItem(int itemId, String friendlyName) {
		try {
			this.items.get(itemId).setFriendlyName(friendlyName);
			return this.items.get(itemId);
		} catch (IndexOutOfBoundsException e) {
			return null;
		}
	}

	/** 
	 * @return List<StorageDAO>
	 */
	@Override
	public List<StorageDAO> getItems() {
		return this.items;
	}

	/** 
	 * @param friendlyName Bezeichnung des BCItems
	 */
	public void setFriendlyName(String friendlyName) {
		this.friendlyName = friendlyName;
	}
	
	/** 
	 * @return int
	 */
	@Override
	public int getId() {
		return this.id;
	}

	/** 
	 * @return String
	 */
	@Override
	public String getFriendlyName() {
		return this.friendlyName;
	}
	
	/** 
	 * @param id Einzigartige ID
	 */
	@Override
	public void setId(int id) {
		this.id = id;
	}
	
	/** 
	 * @return int
	 */
	private static int next() {
		return sequence.getAndIncrement();
	}

}
