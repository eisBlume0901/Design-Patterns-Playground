package exercise1.userinterface;

import exercise1.customer.Customer;
import exercise1.customer.ShoppingCart;
import exercise1.inventory.Inventory;
import exercise1.inventory.Item;
import exercise1.payment.CreditCard;
import exercise1.payment.GCash;
import exercise1.payment.PaymentStrategy;

import static java.lang.System.*;

public class Main
{
    public static void main(String[] args)
    {
        Item item128924 = new Item("Dove Bar Regular 135g", 71.00f);
        Item item384193 = new Item("Great Value Farm Fresh Eggs Medium 12's", 103.00f);
        Item item127841 = new Item("Head & Shoulders Shampoo Cool Menthol 70 mL", 79.35f);
        Item item126457 = new Item("Downy Garden Bloom 24 mL 6 pcs Get 1 Free", 36.00f);
        Item item345187 = new Item("Nestle Fresh Milk 1L", 106.55f);
        Item item311578 = new Item("Betty Crocker Supreme Original Brownie Mix 435g", 229.95f);
        Item item118799 = new Item("Ariel Power Gel with Downy 810 mL Refill", 160.15f);
        Item item314701 = new Item("Golden Oats Plus Chocolate 35 g", 15.00f);
        Item item131447 = new Item("Dalan Cocoa Butter Cream Soap 270g", 149.95f);
        Item item114788 = new Item("Act II Movie Theater Butter Popcorn 11 oz", 219.95f);

        Inventory mariaInventory = new Inventory();
        mariaInventory.addItem(item114788,3);
        mariaInventory.addItem(item131447,4);
        mariaInventory.addItem(item118799,2);
        mariaInventory.addItem(item126457,3);
        mariaInventory.addItem(item128924,2);
        mariaInventory.addItem(item127841,7);
        mariaInventory.addItem(item384193,3);
        mariaInventory.addItem(item114788,4);
        mariaInventory.addItem(item345187,2);
        mariaInventory.addItem(item311578,3);
        mariaInventory.addItem(item314701,3);

        Customer mary = new Customer("Mary Ethereal", "123 Street Lively City");
        PaymentStrategy maryCreditCard = new CreditCard("3782822463100056", 789, "07/2027");

        ShoppingCart maryShoppingCart = new ShoppingCart(mariaInventory, mary, maryCreditCard);

        maryShoppingCart.addItem(item114788);
        maryShoppingCart.addItem(item311578);
        maryShoppingCart.addItem(item345187);
        maryShoppingCart.addItem(item126457);

        maryShoppingCart.displayReceipt();

        out.println();

        Customer odette = new Customer("Odette Pedersen", "456 Hope City");
        PaymentStrategy odetteGCash = new GCash("09123456789", 4457);

        ShoppingCart odetteShoppingCart = new ShoppingCart(mariaInventory, odette, odetteGCash);

        odetteShoppingCart.addItem(item311578);
        odetteShoppingCart.addItem(item127841);
        odetteShoppingCart.addItem(item311578);
        odetteShoppingCart.addItem(item114788);
        odetteShoppingCart.addItem(item128924);

        odetteShoppingCart.displayReceipt();

    }
}
