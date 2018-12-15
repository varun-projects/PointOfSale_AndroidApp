package in.blucon.app.object;


public class ItemType {
    private int itemTypeId_;
    private String itemTypeName_;

    public ItemType(int itemType, String itemTypeName) {
        itemTypeId_ = itemType;
        itemTypeName_ = itemTypeName;
    }

    public int getItemTypeId() {
        return itemTypeId_;
    }

    public String getItemTypeName() {
        return itemTypeName_;
    }
}
