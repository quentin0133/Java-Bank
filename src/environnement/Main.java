package environnement;

import entity.Person;
import entity.User;
import menu.Command;
import menu.DepositMoneyCommand;
import menu.WithdrawMoneyCommand;

import java.util.List;

public class Main {
    private static List<Command> accountCommands = List.of(
            new DepositMoneyCommand(),
            new WithdrawMoneyCommand()
    );

    public static void main(String[] args) {
        User user = new User();

        Person person1 = new Person("Michel", 50f);
        person1.createAccount();

        user.setCurrentPersonControlled(person1);

        while (true) {
            System.out.println("Choisissez une action :");
            for (int i = 0; i < accountCommands.size(); i++)
                System.out.printf("%d - %s%n", i, accountCommands.get(i));
            System.out.println("-1 - Quitter");

            int entry = user.checkBoundInt(-1, 4, user::getSaisieInt, "Error, select an valid option").get();

            if (entry == -1) {
                break;
            } else {
                user.makeAction(accountCommands.get(entry));
            }
        }

        System.out.println(person1.recap());
    }
}
