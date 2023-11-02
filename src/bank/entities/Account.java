package bank.entities;

import java.io.Serializable;

public class Account implements Serializable {
    private static int staticId = 1;

    private float money;
    private String code;
    private int id;

    public Account() {
    }

    public Account(float money, String code) {
        id = staticId;
        this.money = money;
        this.code = code;

        staticId++;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getMoney() {
        return this.money;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void depositMoney(float money) {
        // if (!checkSecretCode(personne)) return;
        this.money += money;
    }

    public void withdrawMoney(float money) {
        // if (!checkSecretCode(personne)) return;
        this.money -= money;
    }

    @Override
    public String toString() {
        return "Account n°%d : %.2f $".formatted(id, money);
    }
}
