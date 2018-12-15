package in.blucon.app.object;


public class Bill {
    private Integer price_;
    private double tax_;
    private long totalAmount_;
    private Order order_;

    public Bill(Integer price, double tax, long totalAmount, Order order) {
        price_ = price;
        tax_ = tax;
        totalAmount_ = totalAmount;
        order_ = order;
    }

    public Integer getPrice() {
        return price_;
    }

    public double getTax() {
        return tax_;
    }

    public long getTotalAmount() {
        return totalAmount_;
    }

    public Order getOrder() {
        return order_;
    }
}
