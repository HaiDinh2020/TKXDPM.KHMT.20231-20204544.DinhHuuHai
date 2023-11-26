package subsystem;

import common.exception.PaymentException;
import common.exception.UnrecognizedException;
import entity.payment.CreditCard;
import entity.payment.PaymentTransaction;
import subsystem.vnpay.VnpaySubsystemController;

public class VnpaySubsystem implements VnpayInterface {
    private VnpaySubsystemController ctrl;

    public VnpaySubsystem (){
        String str = new String();
        this.ctrl = new VnpaySubsystemController();
    }

    @Override
    public PaymentTransaction payOrder(CreditCard card, int amount, String contents) throws PaymentException, UnrecognizedException {
        PaymentTransaction transaction = ctrl.payOrder(card, amount, contents);
        return transaction;
    }

    @Override
    public PaymentTransaction refund(CreditCard card, int amount, String contents) throws PaymentException, UnrecognizedException {
        PaymentTransaction transaction = ctrl.refund(card, amount, contents);
        return transaction;
    }
}
