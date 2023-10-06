package exercise2;

public class Main
{
    public static void main(String[] args)
    {
        Stock appleStock = new Stock("AAPL", 150.0);
        Stock googleStock = new Stock("GOOGL", 2500.0);

        Investor emerald = new Investor("Emerald");
        Investor claire = new Investor("Claire");

        emerald.subscribe(appleStock);
        claire.subscribe(googleStock);
        emerald.subscribe(googleStock);

        appleStock.stockUpdate();
        googleStock.stockUpdate();

        appleStock.setPriceChange(3750.0);
    }
}
