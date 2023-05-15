package org.team42.inventory_system.business;

public class AbstractItem implements ItemInterface {

    protected int id;
    protected String friendlyName;

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getFriendlyName() {
        return friendlyName;
    }
    
}
