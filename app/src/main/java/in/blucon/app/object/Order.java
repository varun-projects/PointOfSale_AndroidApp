package in.blucon.app.object;

import java.sql.Timestamp;


public class Order {
    private Long orderId_;
    private String orderDeviceId_;
    private String description_;
    private Item menuItem_;
    private Integer orderStatusId_;
    private Integer quantity_;
    private Timestamp orderTime_;
    private Integer paymentStatusId_;


    public Order(Long orderId, String orderDeviceId, String description, Item menuItem,
                 Integer orderStatusId,
                 Integer quantity, Timestamp orderTime, Integer paymentStatusId) {
        orderId_ = orderId;
        orderDeviceId_ = orderDeviceId;
        description_ = description;
        menuItem_ = menuItem;
        orderStatusId_ = orderStatusId;
        quantity_ = quantity;
        orderTime_ = orderTime;
        paymentStatusId_ = paymentStatusId;
    }

    public Long getOrderId() {
        return orderId_;
    }

    public String getOrderDeviceId() {
        return orderDeviceId_;
    }

    public String getDescription() {
        return description_;
    }

    public Item getMenuItem() {
        return menuItem_;
    }

    public Integer getOrderStatusId() {
        return orderStatusId_;
    }

    public Integer getQuantity() {
        return quantity_;
    }

    public Timestamp getOrderTime() {
        return orderTime_;
    }

    public Integer getPaymentStatusId() {
        return paymentStatusId_;
    }
}
