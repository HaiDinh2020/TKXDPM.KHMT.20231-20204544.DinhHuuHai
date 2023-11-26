package controller;

import entity.DeliveryInfor;
import entity.Invoice;
import entity.Media;
import entity.Order;

public class OrderController {

    private Order order;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public boolean placeOrder(Order order) {
        return  true;
    }

    public void processDeliveryInfo(Order order, DeliveryInfor deliveryInfor) {
        order.setDeliveryInfo(deliveryInfor);
    }

    public void placeRushOrder (Order order) {
        order.setRushOrder(true);
    }

    public Invoice createInvoice(Order order) {
        return new Invoice(order);
    }

    public int calculateShippingFee(Order order) {
        int total = 0;

        for (Media media : order.getMedias()) {
            total += media.getPrice()*media.getQuantity();
        }
        return total;
    }

}
