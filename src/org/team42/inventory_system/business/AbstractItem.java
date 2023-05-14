package org.team42.inventory_system.business;

public class AbstractItem implements ItemInterface {

    private int id;
    private String friendlyName;

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getFriendlyName() {
        return friendlyName;
    }
    
}
