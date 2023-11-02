package bank.service;

import bank.entities.Account;
import bank.entities.Person;
import tools.Tools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private static final Map<Person, List<Account>> mapPersonToAccounts = new HashMap<>();
    private static List<Account> accountsPerson = new ArrayList<>();
    private static Person person;

    // Connect person
    public void receiveClient(Person person) {
        this.person = person;
        this.accountsPerson = mapPersonToAccounts.get(person);
    }

    // Disconnect person
    public void dischargeClient() {
        this.person = null;
    }

    // deposit
    public static void deposit() {
        displayAccountEntry();
        int accountEntry = Tools.getAccountEntry(accountsPerson.size(), person);
        Account account = accountsPerson.get(accountEntry);

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
    public static void withdraw() {
        displayAccountEntry();
        int accountEntry = Tools.getAccountEntry(accountsPerson.size(), person);
        Account account = accountsPerson.get(accountEntry);

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

    private static void displayAccountEntry() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < accountsPerson.size(); i++)
            result.append(i).append(" - ").append(accountsPerson.get(i)).append('\n');
        result.append("Choose an account : ");
        System.out.print(result);
    }
}
