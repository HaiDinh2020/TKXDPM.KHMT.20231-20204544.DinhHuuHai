//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package controller;

import entity.cart.Cart;
import entity.cart.CartMedia;
import entity.Media;
import java.util.List;

public class BaseController {
    public BaseController() {
    }

    public CartMedia checkMediaInCart(Media media) {
        return Cart.getCart().checkMediaInCart(media);
    }

    public List getListCartMedia() {
        return Cart.getCart().getListMedia();
    }
}
