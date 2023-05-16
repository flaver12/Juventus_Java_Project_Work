package org.team42.inventory_system.presentation;

import org.team42.inventory_system.business.ItemFactory;
import org.team42.inventory_system.business.Item;

public class ConsoleApplication {
	public static void main(String[] args) {
		System.out.println("App started!");

		// create factories
		ItemFactory itemFactory = ItemFactory.getInstance();

		// Create and saves items
		Item item = ItemFactory.createItem("Canon EOS 5DIV");
		Item item2 = ItemFactory.createItem("NIKON D850");
		itemFactory.saveItem(item);
		itemFactory.saveItem(item2);

		// Prints out all items
		itemFactory.getItems().stream().map(i -> i.getId() + " - " + i.getFriendlyName()).forEach(System.out::println);

		// Gets and updates items
		Item item3 = itemFactory.getItem(1);
		item3.setFriendlyName("NIKON D750");
		itemFactory.updateItem(item3);

		// Prints out all items with updated value
		itemFactory.getItems().stream().map(i -> i.getId() + " - " + i.getFriendlyName()).forEach(System.out::println);
	}
}
