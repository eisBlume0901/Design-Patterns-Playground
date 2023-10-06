package exercise2;
import java.util.*;

import static java.lang.System.*;

public class Main
{
    public static void main(String[] args)
    {

        out.println("""
                Choose what character are you:
                [1] Knight
                [2] Archer
                [3] Wizard
                """);

        int characterChoice = choice(1, 3);

        Character knight = new Knight();
        Character archer = new Archer();
        Character wizard = new Wizard();

        Map<Integer, Character> userCharacter = new HashMap<>();
        userCharacter.put(1, knight);
        userCharacter.put(2, archer);
        userCharacter.put(3, wizard);

        out.println("""
                Choose who are you against to:
                [1] Knight
                [2] Archer
                [3] Wizard
                """);

        int targetChoice = choice(1, 3);

        Character targetKnight = new Knight();
        Character targetArcher = new Archer();
        Character targetWizard = new Wizard();

        Map<Integer, Character> targetCharacter = new HashMap<>();
        targetCharacter.put(1, targetKnight);
        targetCharacter.put(2, targetArcher);
        targetCharacter.put(3, targetWizard);

        Character attacker = userCharacter.get(characterChoice);
        Character target = targetCharacter.get(targetChoice);

        while (attacker.getHp() > 0 && target.getHp() > 0)
        {
            attacker.performAttack(target);
            target.performAttack(attacker);
            attacker.displayHealthStatus();
            target.displayHealthStatus();

            if (attacker.getHp() <= 0)
            {
                out.println(attacker.toString() + " loses");
                break;
            }
            else if (target.getHp() <= 0)
            {
                out.println(attacker.toString() + " wins");
                break;
            }
            else if (attacker.getHp() == target.getHp())
            {
                out.println("Ended with a tie");
                break;
            }
        }
    }

    public static int choice(int min, int max)
    {
        while(true)
        {
            try
            {
                Scanner scanner = new Scanner(in);
                int choice = Integer.parseInt(scanner.nextLine());

                if (choice >= min && choice <= max)
                    return choice;
                else throw new IllegalArgumentException();
            }
            catch (Exception e)
            {
                err.println("Invalid input, please choose only from " + min + " to " + max);
            }
        }
    }
}
