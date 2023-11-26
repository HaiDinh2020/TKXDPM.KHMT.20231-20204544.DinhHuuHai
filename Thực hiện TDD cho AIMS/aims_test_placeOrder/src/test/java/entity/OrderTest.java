package entity;

import junit.framework.TestCase;
import org.junit.Test;

public class OrderTest extends TestCase {

    public void setUp() throws Exception {
        super.setUp();
    }

    // Kiểm tra xem sản phẩm đã được thêm vào đơn hàng chưa
    @Test
    public void testAddMedia() {
        Order order = new Order();
        Media media = new Media(1, "Sách quyển", 20,  2, "Doraemon bóng chày", 3, "https://blogtruyen.vn/2552/doraemon-bong-chay-tt8");
        order.addMedia(media);
        assertTrue(order.getMedias().contains(media));
    }


}