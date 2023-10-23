//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package capitalisme;

import java.io.Serializable;

public class Compte implements Serializable {
    private int id;
    private float argent;
    private int code;

    public Compte() {
    }

    public Compte(int id, float argent, int code) {
        this.id = id;
        this.argent = argent;
        this.code = code;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getArgent() {
        return this.argent;
    }

    public void setArgent(float argent) {
        this.argent = argent;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String toString() {
        return "Compte n°%d : %.2f €".formatted(this.id, this.argent);
    }

    public boolean addArgent(float argent) {
        this.argent += argent;
        return true;
    }

    public boolean removeArgent(float argent) {
        if (this.hasArgent(argent)) {
            argent -= argent;
        }

        return this.hasArgent(argent);
    }

    private boolean hasArgent(float argent) {
        return this.argent >= argent;
    }
}
