//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package entity.payment;

public class CreditCard {
    private String cardCode;
    private String owner;
    private int cvvCode;
    private String dateExpired;

    public CreditCard(String cardCode, String owner, int cvvCode, String dateExpired) {
        this.cardCode = cardCode;
        this.owner = owner;
        this.cvvCode = cvvCode;
        this.dateExpired = dateExpired;
    }
}
