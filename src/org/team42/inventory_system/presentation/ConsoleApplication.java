package org.team42.inventory_system.presentation;

import org.team42.inventory_system.business.ItemFactory;
import org.team42.inventory_system.business.Item;

public class ConsoleApplication {
	public static void main(String[] args) {
		System.out.println("App started!");

		//create factories
		ItemFactory itemFactory = ItemFactory.getInstance();

		Item item = ItemFactory.createItem(42, "Canon EOS 5DIV");
		itemFactory.saveItem(item);

		System.out.println("Item ID is " + item.getId());
		System.out.println("Item name is " + item.getFriendlyName());

	}
}
