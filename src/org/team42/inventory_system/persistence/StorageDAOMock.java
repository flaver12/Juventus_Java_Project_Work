package org.team42.inventory_system.persistence;

public class StorageDAOMock implements StorageDAOInterface {

    private int[] id;
    private String[] friendlyName;
    private int itemCounter;
    private final int MAX_ITEMS = 10;

    public StorageDAOMock(){
        id = new int[MAX_ITEMS];
        friendlyName = new String[MAX_ITEMS];
        itemCounter = 0;
    }

    @Override
    public void insertItem(int id, String friendlyName) {
        this.id[itemCounter] = id;
        this.friendlyName[itemCounter] = friendlyName;
        itemCounter++;
    }

    @Override
    public String getItem(int itemId) {
        return friendlyName[itemId];
    }
    
}
