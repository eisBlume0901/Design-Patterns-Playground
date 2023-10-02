package exercise1.inventory;
import java.util.*;
public class Inventory
{
    private List<Item> itemList;
    private int stock;

    public Inventory()
    {
        this.stock = 0;
        this.itemList = new ArrayList<>();
    }

    public void addItem(Item item, int quantity)
    {
        for (int i = 0; i < quantity; i++)
        {
            this.itemList.add(item);
            stock++;
        }
    }


    public boolean itemExists(String itemName)
    {
        for (Item item : itemList)
            if (item.getName().equalsIgnoreCase(itemName))
                return true;
        return false;
    }

    public Item retrieveItem(String itemName)
    {
        for (Item item : itemList)
            if (item.getName().equalsIgnoreCase(itemName))
                return item;
        return null;
    }
}
