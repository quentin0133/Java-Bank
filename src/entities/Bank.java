package entities;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Bank {
    private List<Account> accounts = new ArrayList<>();

    // Connect person

    // Disconnect person

    // deposit
    public void deposit(Person person) {
        displayAccountEntry(person);
        int accountEntry = getAccountEntry(person);
        Account account = accounts.get(accountEntry);

        displayMoneyEntry(person, accountEntry, "deposit");
        float moneyEntry = getMoneyEntry(person, person.getMoney());

        person.setMoney(person.getMoney() - moneyEntry);
        account.depositMoney(moneyEntry);
        System.out.println(
                new StringBuilder(person.getName())
                        .append(" has deposit ")
                        .append("%.2f".formatted(moneyEntry))
                        .append(" $ from the account n°")
                        .append("%03d".formatted(account.getId()))
        );
    }

    // withdraw
    public void withdraw(Person person) {
        displayAccountEntry(person);
        int accountEntry = getAccountEntry(person);
        Account account = accounts.get(accountEntry);

        displayMoneyEntry(person, accountEntry, "withdraw");
        float moneyEntry = getMoneyEntry(person, person.getMoney());

        person.setMoney(person.getMoney() + moneyEntry);
        account.withdrawMoney(moneyEntry);
        System.out.println(
                new StringBuilder(person.getName())
                        .append(" has deposit ")
                        .append("%.2f".formatted(moneyEntry))
                        .append(" $ from the account n°")
                        .append("%03d".formatted(account.getId()))
        );
    }

    private void displayAccountEntry(Person person) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < accounts.size(); i++)
            result.append(i).append(" - ").append(accounts.get(i)).append('\n');
        result.append("Choose an account : ");
        System.out.print(result);
    }

    private void displayMoneyEntry(Person person, int accountEntry, String action) {
        System.out.print(new StringBuilder(person.toString())
                .append('\n')
                .append(accounts.get(accountEntry))
                .append('\n')
                .append("Choose the amount you want to %s : ".formatted(action)));
    }

    private int getAccountEntry(Person person) {
        Scanner scanner = new Scanner(System.in);
        try {
            int value = scanner.nextInt();
            if (accounts.size() > value && 0 <= value)
                return value;
            System.out.println("Error, select an valid option");
        }
        catch (InputMismatchException e) {
            System.out.println("Error, enter an number");
        }
        return getAccountEntry(person);
    }

    private float getMoneyEntry(Person person, float maxEntry) {
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
