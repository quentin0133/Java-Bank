package entities;

import tools.Tools;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Account> accounts = new ArrayList<>();
    private Person person;

    // Connect person
    public void receiveClient(Person person) {
        this.person = person;
    }

    // Disconnect person
    public void dischargeClient() {
        this.person = null;
    }

    // deposit
    public void deposit(Person person) {
        displayAccountEntry(person);
        int accountEntry = Tools.getAccountEntry(accounts.size(), person);
        Account account = accounts.get(accountEntry);

        person.displayMoneyEntry(account, "deposit");
        float moneyEntry = Tools.getMoneyEntry(person, person.getMoney());

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
        int accountEntry = Tools.getAccountEntry(accounts.size(), person);
        Account account = accounts.get(accountEntry);

        person.displayMoneyEntry(account, "withdraw");
        float moneyEntry = Tools.getMoneyEntry(person, person.getMoney());

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
}
