package in.blucon.app.datasource;

import java.util.ArrayList;

import in.blucon.app.object.Item;
import in.blucon.app.object.ItemType;


public class ItemDataSource {
    private static ArrayList<Item> items = new ArrayList<>();

    public static void addItem(Item item) {
        items.add(item);
    }

    public static void removeItem(Item item) {
        items.remove(item);
    }

    public static boolean checkItemExist(Item item) {
        return items.contains(item);
    }

    public static ArrayList<Item> getItems() {
        return items;
    }

    public static ArrayList<Item> getItemsOfItemType(ItemType itemType) {
        ArrayList<Item> tempItems = new ArrayList<>();
        for (Item item : items) {
            if (item.getItemType().equals(itemType)) {
                tempItems.add(item);
            }
        }
        return tempItems;
    }

}
