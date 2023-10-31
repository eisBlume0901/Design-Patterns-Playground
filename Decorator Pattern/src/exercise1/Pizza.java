package exercise1;

import static java.lang.System.*;

public abstract class Pizza {
    public enum SIZE {
        SMALL, MEDIUM, LARGE, EXTRALARGE;
    }

    private SIZE size = SIZE.SMALL;
    private String description = "Pizza";

    private double cost = 0;

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

    public double getCost() {
        return cost;
    }

    public void displayStatus()
    {
        out.println(getDescription() + "\n" +
                "Cost: " + getCost());
    }

}

class AddOnIngredients extends Pizza
{
    private Pizza pizza;

    public AddOnIngredients(Pizza pizza)
    {
        this.pizza = pizza;
    }

    @Override
    public SIZE getSize() {
        return pizza.getSize();
    }

    @Override
    public double getCost() {
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
    public double getCost() {
        double cost = super.getCost();

        if (super.getSize() == SIZE.SMALL)
            cost = 300;
        if (super.getSize() == SIZE.MEDIUM)
            cost = 400;
        if (super.getSize() == SIZE.LARGE)
            cost = 500;
        if (super.getSize() == SIZE.EXTRALARGE)
            cost = 600;

        return cost;
    }
}

class Pepperoni extends Pizza
{
    public Pepperoni()
    {
        setDescription("Pepperoni");
    }

    @Override
    public double getCost() {
        double cost = super.getCost();

        if (super.getSize() == SIZE.SMALL)
            cost = 350;
        if (super.getSize() == SIZE.MEDIUM)
            cost = 450;
        if (super.getSize() == SIZE.LARGE)
            cost = 550;
        if (super.getSize() == SIZE.EXTRALARGE)
            cost = 650;

        return cost;
    }
}

class Veggie extends Pizza
{
    public Veggie()
    {
        setDescription("Veggie");
    }

    @Override
    public double getCost() {
        double cost = super.getCost();

        if (super.getSize() == SIZE.SMALL)
            cost = 325;
        if (super.getSize() == SIZE.MEDIUM)
            cost = 425;
        if (super.getSize() == SIZE.LARGE)
            cost = 525;
        if (super.getSize() == SIZE.EXTRALARGE)
            cost = 625;

        return cost;
    }
}
class Cheese extends AddOnIngredients
{
    public Cheese(Pizza pizza) {
        super(pizza);
    }

    @Override
    public double getCost() {
        return super.getCost() + 50;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Cheese";
    }
}

class Olives extends AddOnIngredients
{
    public Olives(Pizza pizza) {
        super(pizza);
    }

    @Override
    public double getCost() {
        return super.getCost() + 40;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Olives";
    }
}

class Chicken extends AddOnIngredients
{
    public Chicken(Pizza pizza)
    {
        super(pizza);
    }

    @Override
    public double getCost() {
        return super.getCost() + 60;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Chicken";
    }
}

class Mushrooms extends AddOnIngredients
{

    public Mushrooms(Pizza pizza) {
        super(pizza);
    }

    @Override
    public double getCost() {
        return super.getCost() + 35;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Mushrooms";
    }
}
class Main
{
    public static void main(String[] args)
    {
        Pizza margherita = new Margherita();
        margherita.setSize(Pizza.SIZE.MEDIUM);
        margherita.displayStatus();

        margherita.setSize(Pizza.SIZE.LARGE);
        margherita = new Mushrooms(new Olives(new Cheese(new Chicken(margherita))));
        margherita.displayStatus();
    }
}