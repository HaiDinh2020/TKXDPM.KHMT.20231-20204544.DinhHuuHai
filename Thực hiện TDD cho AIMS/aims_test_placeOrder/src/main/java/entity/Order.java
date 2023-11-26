package entity;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private List<Media> medias ;
    private DeliveryInfor deliveryInfo;
    private int id;
    private boolean isRushOrder = false;

    public Order() {
        this.medias = new ArrayList<>();
    }

    public List<Media> getMedias() {
        return medias;
    }

    public void setMedias(List<Media> medias) {
        this.medias = medias;
    }
    public boolean isRushOrder() {
        return isRushOrder;
    }
    public void setRushOrder(boolean rushOrder) {
        isRushOrder = rushOrder;
    }
    public DeliveryInfor getDeliveryInfo() {
        return this.deliveryInfo;
    }
    public void setDeliveryInfo(DeliveryInfor deliveryInfo) {
        this.deliveryInfo = deliveryInfo;
    }
    public void addMedia (Media media) {
        medias.add(media);
    }

}
