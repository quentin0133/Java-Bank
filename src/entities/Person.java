package entities;

import menus.commands.Command;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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

    public void makeAction(Command command) {
        command.optionAction(this);
    }

    public String recap() {
        StringBuilder result = new StringBuilder(toString()).append("\nHis accounts :\n");
        return result.toString();
    }

    @Override
    public String toString() {
        return "%s has %.2f $".formatted(name, money);
    }
}
