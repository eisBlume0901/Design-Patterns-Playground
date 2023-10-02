package exercise1.customer;

import java.util.*;

import exercise1.inventory.Inventory;
import exercise1.inventory.Item;
import exercise1.payment.PaymentStrategy;
import static java.lang.System.out;

public class ShoppingCart
{
    private List<Item> shoppingList;
    private Customer customer;
    private PaymentStrategy paymentStrategy;
    private Inventory inventory;

    public ShoppingCart(Inventory inventory, Customer customer, PaymentStrategy paymentStrategy)
    {
        this.customer = customer;
        this.paymentStrategy = paymentStrategy;
        this.shoppingList = new ArrayList<>();
        this.inventory = inventory;
    }

    public void addItem(Item item)
    {
        if (inventory.itemExists(item.getName()))
            this.shoppingList.add(item);
        else out.println(item.getName() + " not available");
    }

    public void removeItem(Item item)
    {
        if (!this.shoppingList.isEmpty())
            this.shoppingList.remove(item);
        else throw new IllegalArgumentException("Shopping Cart is Empty");
    }
    public double calculateTotal()
    {
        return this.shoppingList.stream().mapToDouble(Item::getPrice).sum();
    }

    public void displayReceipt()
    {
        out.println("Name: " + customer.getName());
        out.println("Address: " + customer.getAddress());

        int maxItemNameLength = this.shoppingList.stream()
                .mapToInt(Item -> Item.getName().length())
                .max()
                .orElse(0);

        int maxItemPriceLength = this.shoppingList.stream()
                .mapToInt(Item -> String.valueOf(Item.getPrice()).length())
                .max()
                .orElse(0);

        String format = "%-" + (maxItemNameLength + 15) + "s%-" + (maxItemPriceLength + 5) + "s%n";
        out.println();
        out.printf(format, "Item", "Price");
        out.println("".repeat(maxItemNameLength + maxItemPriceLength + 20));

        for (Item item : shoppingList)
            out.printf(format, item.getName(), item.getPrice());

        out.println();
        paymentStrategy.pay(calculateTotal());
    }
}
