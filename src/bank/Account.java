package bank;

import java.io.Serializable;

public class Account implements Serializable {
    private static int staticId = 0;

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

    /**
     * @param money money to be deposed on the account
     */
    public void depositMoney(float money) {
        // if (!checkSecretCode(personne)) return;

        this.money += money;
    }


    /**
     * @param money money to be withdrawn from accoubt
     * @return Retourne si l'opération a été réussi
     */
    public void withdrawMoney(float money) {
        this.money -= money;
    }

    private boolean hasMoney(float argent) {
        return this.money >= argent;
    }

    @Override
    public String toString() {
        return "Account n°%d : %.2f $".formatted(id, money);
    }
}
