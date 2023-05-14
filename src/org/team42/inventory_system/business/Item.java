package org.team42.inventory_system.business;

public class Item extends AbstractItem {

    private int id;
    private String friendlyName;

    //Constructor
    public Item(int id, String friendlyName){
        this.id = id;
        this.friendlyName = friendlyName;

    }
}
