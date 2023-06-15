package org.team42.inventory_system.business;

public class AbstractItem implements Item {

	protected int id;
	protected String friendlyName;

	/**
	 * 
	 * @return Gibt die ID des BCItems zurück
	 */
	@Override
	public int getId() {
		return id;
	}

	/**
	 * 
	 * @return Gibt die Bezeichnung des BCItems zurück
	 */
	@Override
	public String getFriendlyName() {
		return friendlyName;
	}

	/**
	 * setzt die ID des BCItems
	 */
	@Override
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * setzt die Bezeichnung des BCItems
	 */
	@Override
	public void setFriendlyName(String friendlyName) {
		this.friendlyName = friendlyName;
	}
}
