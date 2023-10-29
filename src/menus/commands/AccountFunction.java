package menus.commands;

import bank.Account;
import entities.Person;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public interface AccountFunction {
    default void displayAccountEntry(Person person) {
        StringBuilder result = new StringBuilder();
        List<Account> accounts = person.getAccounts();
        for (int i = 0; i < accounts.size(); i++)
            result.append(i).append(" - ").append(accounts.get(i)).append('\n');
        result.append("Choose an account : ");
        System.out.print(result);
    }

    default void displayMoneyEntry(Person person, int accountEntry, String action) {
        System.out.print(new StringBuilder(person.toString())
                .append('\n')
                .append(person.getAccounts().get(accountEntry))
                .append('\n')
                .append("Choose the amount you want to %s : ".formatted(action)));
    }

    default int getAccountEntry(Person person) {
        Scanner scanner = new Scanner(System.in);
        try {
            int value = scanner.nextInt();
            if (person.getAccounts().size() > value && 0 <= value)
                return value;
            System.out.println("Error, select an valid option");
        }
        catch (InputMismatchException e) {
            System.out.println("Error, enter an number");
        }
        return getAccountEntry(person);
    }

    default float getMoneyEntry(Person person, float maxEntry) {
        Scanner scanner = new Scanner(System.in);
        try {
            float value = scanner.nextFloat();
            if (value >= 0 && value <= maxEntry)
                return value;
            else if (value > person.getMoney())
                System.out.println("You don't have enough money, try again");
            else
                System.out.println("Error, enter an positive number");
        }
        catch (InputMismatchException e) {
            System.out.println("Error, enter an number");
        }
        return getMoneyEntry(person, maxEntry);
    }
}
