package exercise1.payment;

import java.text.DecimalFormat;

public class GCash implements PaymentStrategy
{
    private String phoneNumber;
    private int pin;
    public GCash(String phoneNumber, int pin)
    {
        if (phoneNumber.matches("^09\\d{9}"))
            this.phoneNumber = phoneNumber;
        else throw new IllegalArgumentException("Phone Number Invalid");

        if (pin >= 0000 && pin <= 9999)
            this.pin = pin;
        else throw new IllegalArgumentException("Pin Invalid");
    }
    @Override
    public void pay(double amount)
    {
        DecimalFormat twoDecimals = new DecimalFormat("0.##");
        String formattedNumber = twoDecimals.format(amount);
        System.out.println(formattedNumber + " paid using GCash ending with the phone number "
                + phoneNumber.substring(phoneNumber.length() - 4));
    }
}
