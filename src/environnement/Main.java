package environnement;

import bank.Account;
import entity.Person;
import entity.User;
import menu.DepositMoneyCommand;
import menu.WithdrawMoneyCommand;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Person michel = new Person(50f);

        michel.createAccount();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choisissez une action :");
            System.out.println("1 - Déposer de l'argent");
            System.out.println("2 - Retirer de l'argent");
            System.out.println("0 - Quitter");

            int choix = User.getSaisieInt(3);

            if (choix == 0) {
                break;
            } else if (choix == 1 || choix == 2) {
                switch (choix) {
                    case 1 -> michel.makeAction(new DepositMoneyCommand());
                    case 2 -> michel.makeAction(new WithdrawMoneyCommand());
                }
            } else {
                System.out.println("Choix invalide. Veuillez sélectionner une option valide.");
            }
        }

        List<Account> comptes = michel.getComptes();
        for (int i = 0; i < comptes.size(); i++)
            System.out.printf(comptes.get(i).toString());

        scanner.close();
    }
}
