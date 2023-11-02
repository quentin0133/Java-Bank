package bank.entities;

import java.io.Serializable;
import java.util.Random;

public class Person implements Serializable {
    private String name;
    private float money;
    //private float salary;

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, float money) {
        this.name = name;
        this.money = money;
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
        Account newAccount = new Account(0.0f, code);
        System.err.printf("The code for the account n°%03d : %s%n", newAccount.getId(), code);
    }

    public void displayMoneyEntry(Account account, String action) {
        System.out.print(new StringBuilder(toString())
                .append('\n')
                .append(account)
                .append('\n')
                .append("Choose the amount you want to %s : ".formatted(action)));
    }

    @Override
    public String toString() {
        return "%s has %.2f $".formatted(name, money);
    }
}
