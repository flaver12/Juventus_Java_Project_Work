package business;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.team42.inventory_system.business.ItemFactory;
import org.team42.inventory_system.business.Item;

class ItemFactoryTest {

	@Test
	void testGetInstance() {
		ItemFactory itemFactory = ItemFactory.getInstance();
		assertTrue("Is not an instance of ItemFactory", itemFactory instanceof ItemFactory);
	}

	@Test
	void testCreateItemString() {
		Item item = ItemFactory.createItem("My Test Item");
		assertEquals(0, item.getId());
		assertEquals("My Test Item", item.getFriendlyName());
	}

	@Test
	void testSaveItem() {
		ItemFactory itemFactory = ItemFactory.getInstance();
		Item itemToCreate = ItemFactory.createItem("My Test Item");
		Item itemCreated = itemFactory.saveItem(itemToCreate);

		assertEquals("My Test Item", itemCreated.getFriendlyName());
	}

	@Test
	void testUpdateItem() {
		ItemFactory itemFactory = ItemFactory.getInstance();
		Item itemToCreate = ItemFactory.createItem("My Test Item");
		Item itemCreated = itemFactory.saveItem(itemToCreate);
		
		Item toUpdateItem = itemToCreate;
		toUpdateItem.setFriendlyName("My Cool Item");
		itemFactory.updateItem(toUpdateItem);

		assertEquals("My Cool Item", toUpdateItem.getFriendlyName());
		assertNotEquals(toUpdateItem.getFriendlyName(), itemCreated.getFriendlyName());
	}

	@Test
	void testGetItem() {
		ItemFactory itemFactory = ItemFactory.getInstance();
		Item itemToCreate = ItemFactory.createItem("My Test Item");
		itemFactory.saveItem(itemToCreate);
		
		assertTrue(itemFactory.getItems().size() > 0);
		assertNotEquals(null, itemFactory.getItem(0));
	}

	@Test
	void testGetItems() {
		ItemFactory itemFactory = ItemFactory.getInstance();
		Item itemToCreate = ItemFactory.createItem("My Test Item");
		itemFactory.saveItem(itemToCreate);
		
		assertTrue(itemFactory.getItems().size() > 0);
	}

}
