package in.blucon.app.datasource;


import java.util.ArrayList;

import in.blucon.app.object.ItemType;


public class ItemTypeDataSource {
    private static ArrayList<ItemType> itemTypes = new ArrayList<>();

    public static void addItemType(ItemType itemType) {
        itemTypes.add(itemType);
    }

    public static void removeItemType(ItemType itemType) {
        itemTypes.remove(itemType);
    }

    public static boolean checkItemTypeExist(ItemType itemType) {
        if (itemTypes.contains(itemType)) {
            return true;
        }
        return false;
    }

    public static ArrayList<ItemType> getItemTypes() {
        return itemTypes;
    }
}
