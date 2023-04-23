package org.team42.inventory_system.persistence;

public interface StorageDAOInterface {
    
    public void createItem(int id, String friendlyName);
    public void getItem (int id);

}
