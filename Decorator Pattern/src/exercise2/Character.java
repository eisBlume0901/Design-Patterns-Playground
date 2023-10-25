package exercise2;

public abstract class Character
{
    private int health = 0;
    private int strength = 0;
    private int speed = 0;
    private String description = "Character";

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public abstract void increasePoints();
    public void displayStatus()
    {
        System.out.println(getDescription() + ":\n" +
                "Health: " + getHealth() + " points\n" +
                "Strength: "  + getStrength() + " points\n" +
                "Speed: " + getSpeed() + " points\n");
    }
}

class Knight extends Character
{
    public Knight()
    {
        setDescription("Knight");
    }
    @Override
    public void increasePoints() {
        setHealth(getHealth() + 40);
        setStrength(getHealth() + 40);
        setSpeed(getHealth() + 40);
    }
}

class Merchant extends Character
{
    public Merchant()
    {
        setDescription("Merchant");
    }

    @Override
    public void increasePoints()
    {
        setHealth(getHealth() + 30);
        setStrength(getHealth() + 30);
        setSpeed(getHealth() + 30);
    }
}
abstract class EnhancedCharacter extends Character
{
    private Character character;

    public EnhancedCharacter(Character character)
    {
        this.character = character;
    }

    public Character getCharacter() {
        return character;
    }

    public abstract String getDescription();
}

class Armor extends EnhancedCharacter
{
    public Armor(Character character)
    {
        super(character);
    }

    @Override
    public String getDescription() {
        return getCharacter().getDescription() + "\nequipped with Armor";
    }

    @Override
    public void increasePoints() {
        setHealth(getCharacter().getHealth() + 50);
        setStrength(getCharacter().getStrength());
        setSpeed(getCharacter().getSpeed());
    }
}
class Sword extends EnhancedCharacter
{
    public Sword(Character character)
    {
        super(character);
    }

    @Override
    public String getDescription() {
        return getCharacter().getDescription() + "\nequipped with Sword";
    }

    @Override
    public void increasePoints() {
        setHealth(getCharacter().getHealth());
        setStrength(getCharacter().getStrength() + 30);
        setSpeed(getCharacter().getSpeed());
    }
}

class Boots extends EnhancedCharacter
{

    public Boots(Character character) {
        super(character);
    }

    @Override
    public void increasePoints() {
        setHealth(getCharacter().getHealth());
        setStrength(getCharacter().getStrength());
        setSpeed(getCharacter().getSpeed() + 10);
    }

    @Override
    public String getDescription() {
        return getCharacter().getDescription() + "\nequipped with Boots";
    }
}

class Main
{
    public static void main(String[] args)
    {
        Character knight = new Knight();
        knight.increasePoints();
        knight.displayStatus();

        knight = new Sword(knight);
        knight.increasePoints();
        knight.displayStatus();

        knight = new Armor(knight);
        knight.increasePoints();
        knight.displayStatus();

        knight = new Boots(knight);
        knight.increasePoints();
        knight.displayStatus();

        knight = new Armor(knight);
        knight.increasePoints();
        knight.displayStatus();

        Character merchant = new Merchant();
        merchant = new Armor(new Sword(new Boots(merchant)));
        merchant.increasePoints();
        merchant.displayStatus();
    }
}