package exercise2;

public interface AttackStrategy
{
    public void performAttack(Character attacker, Character target);
    public int calculateDamage();
}

class SwordAttack implements AttackStrategy
{
    @Override
    public void performAttack(Character attacker, Character target) {
        int damage = calculateDamage();
        System.out.println(attacker + " attacks " + target + " with sword " + damage + " damage");
        target.receiveDamage(damage);
    }

    @Override
    public int calculateDamage() {
        return 10;
    }
}

class BowAndArrowAttack implements AttackStrategy
{
    @Override
    public void performAttack(Character attacker, Character target) {
        int damage = calculateDamage();
        System.out.println(attacker + " attacks " + target + " with bow and arrow " + damage + " damage");
        target.receiveDamage(damage);
    }

    @Override
    public int calculateDamage() {
        return 8;
    }
}

class MagicSpellAttack implements AttackStrategy
{
    @Override
    public void performAttack(Character attacker, Character target) {
        int damage = calculateDamage();
        System.out.println(attacker + " attacks " + target + " with magic spell and deals " + damage + " damage");
        target.receiveDamage(damage);
    }

    @Override
    public int calculateDamage() {
        return 12;
    }
}