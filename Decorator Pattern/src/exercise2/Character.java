package exercise2;

import static java.lang.System.*;

/*
Mistakes at first attempt:
Any instance variable cannot be put together. They have to function
by themselves. I cannot allow the health, strength, and speed to share
one abstract function. They need to have their own method.
 */
public abstract class Character {
    private int health = 0;
    private int strength = 0;
    private int speed = 0;

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
    public abstract String getDescription();

    public void displayStatus()
    {
        out.println(getDescription() + ":\n" +
                "Health: " + getHealth() + " points\n" +
                "Strength: " + getStrength() + " points\n" +
                "Speed: " + getSpeed() + " points\n");
    }
}

class Knight extends Character
{
    @Override
    public String getDescription()
    {
        return "Knight";
    }
}

class Merchant extends Character
{
    @Override
    public String getDescription()
    {
        return "Merchant";
    }
}

abstract class CharacterEnhancer extends Character
{
    private Character character;

    public CharacterEnhancer(Character character)
    {
        this.character = character;
    }

    public Character getCharacter() {
        return character;
    }

    @Override
    public int getHealth() {
        return character.getHealth();
    }

    @Override
    public int getStrength() {
        return character.getStrength();
    }

    @Override
    public int getSpeed() {
        return character.getSpeed();
    }
}

class Armor extends CharacterEnhancer
{
    public Armor(Character character)
    {
        super(character);
    }

    @Override
    public int getHealth() {
        return getCharacter().getHealth() + 50;
    }

    @Override
    public String getDescription() {
        return getCharacter().getDescription() + ", equipped with Armor";
    }
}

class Sword extends CharacterEnhancer
{
    public Sword(Character character)
    {
        super(character);
    }

    @Override
    public int getStrength() {
        return getCharacter().getStrength() + 30;
    }

    @Override
    public String getDescription() {
        return getCharacter().getDescription() + ", equipped with Sword";
    }
}

class Boots extends CharacterEnhancer
{
    public Boots(Character character)
    {
        super(character);
    }

    @Override
    public int getSpeed() {
        return getCharacter().getSpeed() + 10;
    }

    @Override
    public String getDescription() {
        return getCharacter().getDescription() + ", equipped with Boots";
    }
}

class Main
{
    public static void main(String[] args)
    {
        Character knight = new Knight();
        knight.displayStatus();
        knight.setHealth(40);
        knight.setStrength(40);
        knight.setSpeed(40);
        knight.displayStatus();

        knight = new Armor(new Armor((new Sword(new Boots(knight)))));
        knight.displayStatus();

        Character merchant = new Merchant();
        merchant.displayStatus();
        merchant.setHealth(30);
        merchant.setStrength(30);
        merchant.setSpeed(30);
        merchant.displayStatus();

        merchant = new Armor(new Boots(merchant));
        merchant.displayStatus();

    }
}