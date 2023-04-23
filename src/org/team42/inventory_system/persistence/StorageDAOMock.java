package org.team42.inventory_system.persistence;

public class StorageDAOMock implements StorageDAOInterface {

    private int[] id;
    private String[] friendlyName;
    private int itemCounter;
    private final int MAX_items = 10;

    public StorageDAOMock(){
        itemCounter = 0;
    }

    @Override
    public void createItem(int id, String friendlyName) {
        itemCounter++;
    }

    @Override
    public void getItem(int id) {
        // TODO Auto-generated method stub
    }
    
}
