//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package entity;

import bank.Compte;

import java.io.Serializable;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

public class Personne implements Serializable {
    private List<Compte> comptes;

    public Personne() {
    }

    public Personne(float argent, List<Compte> comptes) {
        this.comptes = comptes;
    }

    public List<Compte> getComptes() {
        return this.comptes;
    }

    public void setComptes(List<Compte> comptesBancaire) {
        this.comptes = comptesBancaire;
    }

    public void addCompte() {
        int code = (new Random()).nextInt(0, 10000);
        int id = this.comptes.size();
        this.comptes.add(new Compte(id, 0.0F, code));
        System.err.printf("Code pour le compte n°%d : %d%n", id, code);
    }

    public void deposerArgent(float argent, int idCompte) {
        Compte compte = this.getCompte(idCompte);
        if (compte != null) {
            if (!compte.addArgent(argent)) {
                System.err.println("Vous n'avez pas assez d'argent sur vous");
            }

        }
    }

    public void retirerArgent(float argent, int idCompte) {
        Compte compte = this.getCompte(idCompte);
        if (compte != null) {
            if (!compte.removeArgent(argent)) {
                System.out.println("Vous n'avez pas assez d'argent sur ce compte");
            }

        }
    }

    public void virerArgent(float argent, int idCompteRetirer, int idCompteDeposer) {
    }

    private Compte getCompte(int idCompte) {
        try {
            return (Compte)this.comptes.stream().filter((compte) -> {
                return compte.getId() == idCompte;
            }).findFirst().orElseThrow();
        } catch (NoSuchElementException var3) {
            System.err.printf("Le compte n°%d n'existe pas%n", idCompte);
            return null;
        }
    }
}
