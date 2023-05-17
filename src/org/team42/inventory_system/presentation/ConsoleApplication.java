package org.team42.inventory_system.presentation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.team42.inventory_system.business.Item;
import org.team42.inventory_system.business.ItemFactory;

public class ConsoleApplication {

	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static ItemFactory itemFactory = ItemFactory.getInstance();

	public static void main(String[] args) throws IOException {
		System.out.println("App started!");
		selectAction();
	}

	private static void selectAction() throws IOException {
		System.out.println("What would you like to do?");
		System.out.println("[C]reate an item");
		System.out.println("[U]pdate an item");
		System.out.println("[G]et an item");
		System.out.println("[L]ist all items");
		System.out.println("[E]xit application");
		String action = reader.readLine();

		switch (action.toUpperCase()) {
			case "C":
				createItem();
				break;
			case "U":
				updateItem();
				break;
			case "G":
				getItem();
				break;
			case "L":
				listItems();
				break;
			case "E":
				System.out.println("Goodbye!");
				System.exit(0);
				break;
			default:
				System.out.println("Please enter a valid option");
		}
		System.out.println("Press enter to continue...");
		reader.readLine();
		selectAction();
	}

	private static void createItem() throws IOException {
		System.out.println("Enter a friendlyName for the item: ");
		String friendlyName = reader.readLine();

		switch (friendlyName) {
			case "":
				System.out.println("No name entered, exiting action...");
				break;
			default:
				Item item = itemFactory.saveItem(ItemFactory.createItem(friendlyName));
				System.out.println("Created new item: " + item.getId() + " - " + item.getFriendlyName());
		}

	}

	private static void updateItem() throws IOException {
		System.out.println("Enter the id of the item you want to update: ");
		int itemId;

		try {
			itemId = Integer.parseInt(reader.readLine());
		} catch (NumberFormatException e) {
			System.out.println("provided invalid id, exiting action...");
			return;
		}
		System.out.println("Enter a friendlyName for the item: ");
		String friendlyName = reader.readLine();

		switch (friendlyName) {
			case "":
				System.out.println("No name entered, exiting action...");
				break;
			default:
				try {
					Item item = itemFactory.updateItem(ItemFactory.createItem(itemId, friendlyName));
					System.out.println("Updated item: " + item.getId() + " - " + item.getFriendlyName());
				} catch (NullPointerException e) {
					System.out.println("No item found with provided id=" + itemId + ", exiting action...");
				}
		}
	}

	private static void getItem() throws IOException {
		System.out.println("Enter the id of the item you want: ");
		int itemId;

		try {
			itemId = Integer.parseInt(reader.readLine());
		} catch (NumberFormatException e) {
			System.out.println("provided invalid id, exiting action...");
			return;
		}
		try {
			Item item = itemFactory.getItem(itemId);
			System.out.println("Item: " + item.getId() + " - " + item.getFriendlyName());
		} catch (NullPointerException e) {
			System.out.println("No item found with provided id=" + itemId + ", exiting action...");
		}
	}

	private static void listItems() {
		for (Item item : itemFactory.getItems()) {
			System.out.println(item.getId() + " - " + item.getFriendlyName());
		}
	}
}
