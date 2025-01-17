//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package entity.payment;

public class PaymentTransaction {
    private String errorCode;
    private CreditCard card;
    private String transactionId;
    private String transactionContent;
    private int amount;
    private String createdAt;

    public PaymentTransaction(String errorCode, CreditCard card, String transactionId, String transactionContent, int amount, String createdAt) {
        this.errorCode = errorCode;
        this.card = card;
        this.transactionId = transactionId;
        this.transactionContent = transactionContent;
        this.amount = amount;
        this.createdAt = createdAt;
    }

    public String getErrorCode() {
        return this.errorCode;
    }
}
