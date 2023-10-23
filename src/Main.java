import capitalisme.Personne;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BiConsumer;

public class Main {
    private static Personne personne = new Personne(50.0F, new ArrayList());
    private static final Map<String, BiConsumer<Float, Integer>> listAction = Map.of("Déposer de l'argent", (argent, idCompte) -> {
        personne.deposerArgent(argent, idCompte);
    }, "Retirer de l'argent", (argent, idCompte) -> {
        personne.retirerArgent(argent, idCompte);
    }, "Virer de l'argent", (argent, idCompte) -> {
        personne.virerArgent(argent, idCompte, 0);
    });
    private static final String[] listActionLabel;

    public static void main(String[] args) {
        personne.addCompte();
        displayActionMenu();
    }

    private static void displayActionMenu() {
        System.out.println("Veuillez choisir une action :");

        for(int i = 0; i < listActionLabel.length; ++i) {
            System.out.printf(" %d\t->\t%s\n", i, listActionLabel[i]);
        }

        System.out.println("-1\t->\t Quitter");
        startBankLife(getSaisieInt());
    }

    private static void startBankLife(int idAction) {
        if (idAction != -1) {
            try {
                displayComptes();
                int idCompte = getSaisieInt();
                System.out.println("Veuillez saisir l'argent :");
                float argent = getSaisieFloat();
                ((BiConsumer)listAction.get(listActionLabel[idAction])).accept(argent, idCompte);
            } catch (ArrayIndexOutOfBoundsException var6) {
                System.err.println("L'index saisi ne corresponds à aucun programme");
            } finally {
                displayActionMenu();
            }

        }
    }

    private static void displayComptes() {
        System.out.printf("Veuillez saisir le compte :");

        for(int i = 0; i < personne.getComptes().size(); ++i) {
            System.out.printf(" %d\t->\t%s\n", i, personne.getComptes().get(i));
        }

    }

    public static int getSaisieInt() {
        Scanner scanner = new Scanner(System.in);

        int saisie;
        try {
            saisie = scanner.nextInt();
        } catch (InputMismatchException var3) {
            System.err.println("La saisie est invalide, veuillez réessayer");
            saisie = getSaisieInt();
        }

        return saisie;
    }

    public static float getSaisieFloat() {
        Scanner scanner = new Scanner(System.in);

        float saisie;
        try {
            saisie = scanner.nextFloat();
        } catch (InputMismatchException var3) {
            System.err.println("La saisie est invalide, veuillez réessayer");
            saisie = getSaisieFloat();
        }

        return saisie;
    }

    static {
        listActionLabel = (String[])listAction.keySet().toArray(new String[0]);
    }
}
