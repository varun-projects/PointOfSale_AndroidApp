package in.blucon.app.datasource;

import java.util.ArrayList;

import in.blucon.app.object.Order;


public class BillDataSource {

    private static ArrayList<Order> orders = new ArrayList<>();

    public static void addOrderToBill(Order order) {
        if (!orders.contains(order)) {
            orders.add(order);
        }
    }

    public static void removeOrderToBill(Order order) {
        if (orders.contains(order)) {
            orders.remove(order);
        }
    }

    public static ArrayList<Order> getOrders() {
        return orders;
    }
}
