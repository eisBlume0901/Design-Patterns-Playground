package exercise1;

public abstract class Pizza {
    public enum SIZE {
        SMALL, MEDIUM, LARGE, EXTRALARGE;
    }

    private SIZE size = SIZE.SMALL;
    private String description = "Pizza";

    private int cost = 0;

    public SIZE getSize() {
        return size;
    }

    public void setSize(SIZE size) {
        this.size = size;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCost() {
        return cost;
    }

}

class PizzaDecorator extends Pizza
{
    private Pizza pizza;

    public PizzaDecorator(Pizza pizza)
    {
        this.pizza = pizza;
    }

    @Override
    public SIZE getSize() {
        return pizza.getSize();
    }

    @Override
    public int getCost() {
        return pizza.getCost();
    }

    @Override
    public String getDescription() {
        return pizza.getDescription();
    }
}

class Margherita extends Pizza
{
    public Margherita()
    {
        setDescription("Margherita");
    }

    @Override
    public int getCost() {
        double cost
        return super.getCost();
    }
}