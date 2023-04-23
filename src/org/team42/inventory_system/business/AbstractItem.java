package org.team42.inventory_system.business;

import org.team42.inventory_system.persistence.StorageDAOInterface;
import org.team42.inventory_system.persistence.StorageDAOFactory;

public class AbstractItem implements ItemInterface {

    @Override
    public int getId() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getId'");
    }

    @Override
    public String getFriendlyName() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getFriendlyName'");
    }
    
}
