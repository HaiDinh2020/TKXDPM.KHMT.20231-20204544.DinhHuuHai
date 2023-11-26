package controller;

import entity.DeliveryInfor;
import entity.Invoice;
import entity.Media;
import entity.Order;
import junit.framework.TestCase;
import org.junit.Test;

public class OrderControllerTest extends TestCase {

    public void setUp() throws Exception {
        super.setUp();
    }


    public void testProcessOrder() {
        Order order = new Order();
        order.addMedia(new Media(1, "Sách quyển", 20,  2, "Doraemon bóng chày", 3, "https://blogtruyen.vn/2552/doraemon-bong-chay-tt8"));
        order.addMedia(new Media(1, "Đĩa CD", 15, 5, "CD nhạc Đan Trường", 15, "https://www.youtube.com/watch?v=h-c7F6XSuh0"));
        OrderController orderController = new OrderController();
        boolean orderResult = orderController.placeOrder(order);
        Invoice invoice = new Invoice(order);

        assertEquals(true,orderResult );
        assertEquals(true, invoice.saveInvoice());
    }

    // Kiểm tra xem thông tin giao hàng và chỉ dẫn đã được cập nhật hay chưa
    @Test
    public void testProcessDeliveryInfo() {
        DeliveryInfor deliveryInfor = new DeliveryInfor(1, "Hai Dinh", "Ha Noi", "wrap carefully", "Hai ba Trung");
        Order order = new Order();
        order.addMedia(new Media(1, "Sách quyển", 20,  2, "Doraemon bóng chày", 3, "https://blogtruyen.vn/2552/doraemon-bong-chay-tt8"));
        order.addMedia(new Media(1, "Đĩa CD", 15, 5, "CD nhạc Đan Trường", 15, "https://www.youtube.com/watch?v=h-c7F6XSuh0"));
        order.setDeliveryInfo(deliveryInfor);

        assertEquals(1, order.getDeliveryInfo().getId());
        assertEquals("Hai Dinh", order.getDeliveryInfo().getName());
        assertEquals("Ha Noi", order.getDeliveryInfo().getProvince());
        assertEquals("wrap carefully", order.getDeliveryInfo().getInstruction());
        assertEquals("Hai ba Trung", order.getDeliveryInfo().getAddress());
    }



    public void testCreateInvoice() {
    }

    @Test
    public void testPlaceRushOrder() {
        Order order = new Order();
        order.addMedia(new Media(1, "Sách quyển", 20,  2, "Doraemon bóng chày", 3, "https://blogtruyen.vn/2552/doraemon-bong-chay-tt8"));
        order.addMedia(new Media(1, "Đĩa CD", 15, 5, "CD nhạc Đan Trường", 15, "https://www.youtube.com/watch?v=h-c7F6XSuh0"));

        OrderController orderController = new OrderController();
        orderController.placeRushOrder(order);

        boolean orderResult = orderController.placeOrder(order);
        assertEquals(true, orderResult);
        assertEquals(true, order.isRushOrder());
    }



    @Test
    public void testCalculateShippingFee() {
        Order order = new Order();
        order.addMedia(new Media(1, "Sách quyển", 20,  2, "Doraemon bóng chày", 3, "https://blogtruyen.vn/2552/doraemon-bong-chay-tt8"));
        order.addMedia(new Media(1, "Đĩa CD", 15, 5, "CD nhạc Đan Trường", 15, "https://www.youtube.com/watch?v=h-c7F6XSuh0"));

        OrderController orderController = new OrderController();

        // Kiểm tra tính đúng đắn của phương thức tính tổng giá cả
        assertEquals(115, orderController.calculateShippingFee(order), 0.001);
    }
}