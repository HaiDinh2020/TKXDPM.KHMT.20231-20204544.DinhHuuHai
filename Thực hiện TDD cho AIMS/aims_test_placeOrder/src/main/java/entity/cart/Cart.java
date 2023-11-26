//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package entity.cart;

import common.exception.MediaNotAvailableException;
import entity.Media;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Cart {
    private List<CartMedia> lstCartMedia = new ArrayList();
    private static Cart cartInstance;

    public static Cart getCart() {
        if (cartInstance == null) {
            cartInstance = new Cart();
        }

        return cartInstance;
    }

    private Cart() {
    }

    public void addCartMedia(CartMedia cm) {
        this.lstCartMedia.add(cm);
    }

    public void removeCartMedia(CartMedia cm) {
        this.lstCartMedia.remove(cm);
    }

    public List getListMedia() {
        return this.lstCartMedia;
    }

    public void emptyCart() {
        this.lstCartMedia.clear();
    }

    public int getTotalMedia() {
        int total = 0;

        CartMedia cm;
        for(Iterator var3 = this.lstCartMedia.iterator(); var3.hasNext(); total += cm.getQuantity()) {
            Object obj = var3.next();
            cm = (CartMedia)obj;
        }

        return total;
    }

    public int calSubtotal() {
        int total = 0;

        CartMedia cm;
        for(Iterator var3 = this.lstCartMedia.iterator(); var3.hasNext(); total += cm.getPrice() * cm.getQuantity()) {
            Object obj = var3.next();
            cm = (CartMedia)obj;
        }

        return total;
    }

    public void checkAvailabilityOfProduct() throws SQLException {
        boolean allAvai = true;
        Iterator var3 = this.lstCartMedia.iterator();

        while(var3.hasNext()) {
            Object object = var3.next();
            CartMedia cartMedia = (CartMedia)object;
            int requiredQuantity = cartMedia.getQuantity();
            int availQuantity = cartMedia.getMedia().getQuantity();
            if (requiredQuantity > availQuantity) {
                allAvai = false;
            }
        }

        if (!allAvai) {
            throw new MediaNotAvailableException("Some media not available");
        }
    }

    public CartMedia checkMediaInCart(Media media) {
        Iterator var3 = this.lstCartMedia.iterator();

        while(var3.hasNext()) {
            CartMedia cartMedia = (CartMedia)var3.next();
            if (cartMedia.getMedia().getId() == media.getId()) {
                return cartMedia;
            }
        }

        return null;
    }
}
