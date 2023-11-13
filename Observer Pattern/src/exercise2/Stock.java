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
        System.out.println(this.name);
        for (Observer observer : investors)
        {
            observer.update(price);
        }
    }

    // The reason why we call the notifyInvestors inside the stockUpdate
    // is because we override the interface method.
    public void stockUpdate()
    {
        notifyInvestors();
    }


}
