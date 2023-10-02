package exercise2;

public abstract class Character
{
    private int hp;
    private AttackStrategy attackStrategy;

    public Character(int hp, AttackStrategy attackStrategy)
    {
        this.hp = hp;
        this.attackStrategy = attackStrategy;
    }

    public int getHp() {
        return hp;
    }

    public void performAttack(Character target)
    {
        attackStrategy.performAttack(this, target);
    }

    public void receiveDamage(int damage)
    {
        hp -= damage;

        if (hp <= damage)
            hp = 0;
    }

    public abstract void displayHealthStatus();

    public abstract String toString();
}

class Knight extends Character
{
    public Knight()
    {
        super(15, new SwordAttack());
    }
    @Override
    public void displayHealthStatus() {
        System.out.println("Knight health points is " + getHp());
    }

    @Override
    public String toString() {
        return "Knight";
    }
}

class Archer extends Character
{
    public Archer()
    {
        super(15, new BowAndArrowAttack());
    }

    @Override
    public void displayHealthStatus() {
        System.out.println("Archer health points is " + getHp());
    }

    @Override
    public String toString() {
        return "Archer";
    }
}

class Wizard extends Character
{
    public Wizard()
    {
        super(15, new MagicSpellAttack());
    }
    @Override
    public void displayHealthStatus() {
        System.out.println("Wizard health points is " + getHp());
    }

    @Override
    public String toString() {
        return "Wizard";
    }

}