package exercise2;

import static java.lang.System.*;

public class Character
{
    private int health = 0;
    private int strength = 0;
    private int speed = 0;

    private String description = "Character";

    public int getHealth() {
        return health;
    }
    public int getStrength() {
        return strength;
    }

    public int getSpeed() {
        return speed;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void displayStatus()
    {
        out.println(getDescription() + "\n" +
                "Health: " + getHealth() + "\n" +
                "Strength: " + getStrength() + "\n" +
                "Speed: " + getSpeed() + "\n");
    }
}

class CharacterDecorator extends Character
{
    private Character character;
    public CharacterDecorator(Character character)
    {
        this.character = character;
    }

    @Override
    public int getHealth() {
        return character.getHealth();
        // If we use super we pertain to health that we had
        // initialized which is 0.
        // Thus, we must use character, so it pertains to the character
        // that is being decorated.
    }

    @Override
    public int getStrength() {
        return character.getStrength();
    }

    @Override
    public String getDescription() {
        return character.getDescription();
        // If we use super we pertain to description that we had
        // initialized which is "Character"
        // Thus, we must use character, so it pertains to the character
        // that is being decorated.
    }
}

class Knight extends Character
{
    public Knight()
    {
        setDescription("Knight");
    }
}

class Merchant extends Character
{
    public Merchant()
    {
        setDescription("Merchant");
    }
}
class Armor extends CharacterDecorator
{
    public Armor(Character character) {
        super(character);
    }

    @Override
    public int getHealth() {
        return super.getHealth() + 50;
        // Super here refers to the CharacterDecorator's character
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Armor";
        // Super here refers to the CharacterDecorator's character
    }
}

class Sword extends CharacterDecorator
{
    public Sword(Character character) {
        super(character);
    }

    @Override
    public int getStrength() {
        return super.getStrength() + 30;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Sword";
    }
}

class Boots extends CharacterDecorator
{
    public Boots(Character character) {
        super(character);
    }

    @Override
    public int getSpeed() {
        return super.getSpeed() + 10;
    }


}
class Main
{
    public static void main(String[] args)
    {
        Character knight = new Knight();
        knight = new Armor(new Sword(knight));
        knight.displayStatus();
    }
}