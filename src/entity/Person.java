//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package entity;

import bank.Account;
import menu.Command;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Person implements Serializable {
    private List<Account> accounts = new ArrayList<>();
    private float argent;

    public Person() {
    }

    public Person(float argent) {
        this.argent = argent;
    }

    public List<Account> getComptes() {
        return this.accounts;
    }

    public float getArgent() {
        return argent;
    }

    public void createAccount() {
        String code = String.format("%04d", new Random().nextInt(0, 10000));
        Account newAccount = new Account(0.0F, code);
        this.accounts.add(newAccount);
        System.err.printf("Code pour le compte n°%d : %s%n", newAccount.getId(), code);
    }

    public void makeAction(Command command) {
        command.optionAction(this);
    }
}
