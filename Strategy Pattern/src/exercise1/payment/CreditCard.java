package exercise1.payment;

import java.text.DecimalFormat;

public class CreditCard implements PaymentStrategy
{
    private String creditCardNumber;
    private int cvv;
    private String creditCardExpiry;

    public CreditCard(String creditCardNumber, int cvv, String creditCardExpiry)
    {
        if (creditCardNumber.matches("^[0-9]{16}$"))
            this.creditCardNumber = creditCardNumber;
        else throw new IllegalArgumentException("Credit Card Number Invalid");

        if (cvv > 99 && cvv <= 999)
            this.cvv = cvv;
        else throw new IllegalArgumentException("CVV Format Invalid");

        if (creditCardExpiry.matches("^(0[1-9]|1[0-2])/(20[2-9][0-9])"))
            this.creditCardExpiry = creditCardExpiry;
        else throw new IllegalArgumentException("Credit Card Expiry Format Invalid");
    }

    @Override
    public void pay(double amount)
    {
        DecimalFormat twoDecimals = new DecimalFormat("0.##");
        String formattedNumber = twoDecimals.format(amount);
        System.out.println(formattedNumber + " paid using credit card with cvv of " + this.cvv);
    }
}
