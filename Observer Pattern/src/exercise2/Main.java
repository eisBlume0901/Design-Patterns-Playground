package exercise2;
import java.util.*;
public class Main
{
    public static void main(String[] args)
    {
        Stock appleStock = new Stock("AAPL", 150.0);
        Stock googleStock = new Stock("GOOGL", 2500.0);

        Investor emerald = new Investor("Emerald");
        Investor claire = new Investor("Claire");
        Investor amelie = new Investor("Amelie");
        Investor mary = new Investor("Mary");

        emerald.subscribe(appleStock);
        claire.subscribe(googleStock);
        emerald.subscribe(googleStock);
        amelie.subscribe(appleStock);
        mary.subscribe(appleStock);

        appleStock.stockUpdate();
        googleStock.stockUpdate();

        mary.unsubscribe(appleStock);
        appleStock.setPriceChange(3750.0);

    }
}
