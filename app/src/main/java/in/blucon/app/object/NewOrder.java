package in.blucon.app.object;


public class NewOrder {
    private String deviceId_;
    private int tableId_;
    private String description_;
    private int itemId_;
    private int quantity_;

    public NewOrder(String deviceId, int tableId, String description, int itemId, int quantity) {
        deviceId_ = deviceId;
        tableId_ = tableId;
        description_ = description;
        itemId_ = itemId;
        quantity_ = quantity;
    }

    public String getDeviceId() {
        return deviceId_;
    }

    public int getTableId() {
        return tableId_;
    }

    public String getDescription() {
        return description_;
    }

    public int getItemId() {
        return itemId_;
    }

    public int getQuantity() {
        return quantity_;
    }

}
