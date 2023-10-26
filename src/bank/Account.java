//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

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

    public String toString() {
        return "Compte n°%d : %.2f €".formatted(this.id, this.money);
    }

    /**
     * @param money argent à ajouter sur le compte
     */
    public void depositMoney(float money) {
        // if (!checkSecretCode(personne)) return;

        this.money += money;
    }


    /**
     * @param money money to be withdrawn from accoubt
     * @return Retourne si l'opération a été réussi
     */
    public boolean withdrawMoney(float money) {
        // if (!checkSecretCode(personne)) return;

        if (this.hasArgent(money)) {
            money -= money;
        }

        return this.hasArgent(money);
    }

    private boolean hasArgent(float argent) {
        return this.money >= argent;
    }
}
