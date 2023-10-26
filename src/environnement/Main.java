package environnement;

import entity.Person;
import entity.User;
import menu.DepositMoneyCommand;
import menu.WithdrawMoneyCommand;

public class Main {
    public static void main(String[] args) {
        User user = new User();

        Person person1 = new Person("Michel", 50f);
        person1.createAccount();

        user.setCurrentPersonControlled(person1);

        while (true) {
            System.out.println("Choisissez une action :");
            System.out.println("1 - Déposer de l'argent");
            System.out.println("2 - Retirer de l'argent");
            System.out.println("3 - Retirer de l'argent");
            System.out.println("-1 - Quitter");

            int choix = user.getSaisieInt(-1, 4);

            if (choix == -1) {
                break;
            } else if (choix == 0 || choix == 1 || choix == 2) {
                switch (choix) {
                    case 1 -> user.makeAction(new DepositMoneyCommand());
                    case 2 -> user.makeAction(new WithdrawMoneyCommand());
                }
            } else {
                System.out.println("Choix invalide. Veuillez sélectionner une option valide.");
            }
        }

        System.out.println(person1.recap());
    }
}
