package exercise2;
import java.util.*;

public class Stock implements Subject
{
    private String name;
    private double price;
    private List<Observer> investors;

    public Stock(String name, double price)
    {
        this.name = name;
        this.price = price;
        this.investors = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setPriceChange(double price)
    {
        this.price = price;
        stockUpdate();
    }

    @Override
    public void registerInvestor(Observer observer) {
        investors.add(observer);
    }

    @Override
    public void removeInvestor(Observer observer) {
        investors.remove(observer);
    }

    @Override
    public void notifyInvestors()
    {
        for (Observer observer : investors)
        {
            System.out.println(this.name);
            observer.update(price);
        }
    }

    public void stockUpdate()
    {
        notifyInvestors();
    }
}
