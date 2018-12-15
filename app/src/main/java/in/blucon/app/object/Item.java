package in.blucon.app.object;


public class Item {

    private ItemType itemType_;
    private String itemName_;
    private Integer itemPrice_;
    private Integer itemId_;
    private double itemTax_;
    private String description_;

    public Item(ItemType itemType, String itemName, Integer itemPrice, Integer itemId, double itemTax, String description) {
        itemType_ = itemType;
        itemName_ = itemName;
        itemPrice_ = itemPrice;
        itemId_ = itemId;
        itemTax_ = itemTax;
        description_ = description;
    }

    public ItemType getItemType() {
        return itemType_;
    }

    public String getItemName() {
        return itemName_;
    }

    public Integer getItemPrice() {
        return itemPrice_;
    }

    public Integer getItemId() {
        return itemId_;
    }

    public double getItemTax() {
        return itemTax_;
    }

    public String getDescription() {
        return description_;
    }
}
