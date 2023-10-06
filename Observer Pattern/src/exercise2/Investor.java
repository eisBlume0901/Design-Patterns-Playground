package exercise2;
public class Investor implements Observer
{
    private String name;
    public Investor(String name)
    {
        this.name = name;
    }
    @Override
    public void update(double price) {
        System.out.println(this.name + ", there is a price change: " + price);
    }

    public void subscribe(Stock stock)
    {
        stock.registerInvestor(this);
        System.out.println(this.name + " subscribing to " + stock.getName());
    }

    public void unsubscribe(Stock stock)
    {
        stock.removeInvestor(this);
        System.out.println(this.name + " unsubscribing to " + stock.getName());
    }

    @Override
    public String toString() {
        return this.name;
    }
}
