package entity;

public class Invoice {
    private Order order;
    private int amount;

    public Invoice() {
    }

    public Invoice(Order order) {
        this.order = order;
    }

    public Order getOrder() {
        return this.order;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return this.amount;
    }

    public boolean saveInvoice() {
        return true;
    }
}
