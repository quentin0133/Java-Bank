package entity;

import bank.Account;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Person implements Serializable {
    private List<Account> accounts = new ArrayList<>();
    private String name;
    private float money;

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, float money) {
        this.name = name;
        this.money = money;
    }

    public List<Account> getAccounts() {
        return this.accounts;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void createAccount() {
        String code = String.format("%04d", new Random().nextInt(0, 10000));
        Account newAccount = new Account(0.0F, code);
        this.accounts.add(newAccount);
        System.err.printf("Code pour le compte n°%d : %s%n", newAccount.getId(), code);
    }

    @Override
    public String toString() {
        return "%s has %.2f $".formatted(name, money);
    }

    public String recap() {
        StringBuilder result = new StringBuilder(toString()).append("\nHis accounts :\n");
        accounts.forEach(result::append);
        return result.toString();
    }
}
