package org.team42.inventory_system.persistence;

public interface StorageDAOInterface {
    
    public void insertItem(int id, String friendlyName);
    public String getItem (int id);

}
