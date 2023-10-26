package entity;

import java.util.Scanner;

public class User {
    public static int getSaisieInt() {
        return new Scanner(System.in).nextInt();
    }

    public static float getSaisieFloat() {
        return new Scanner(System.in).nextFloat();
    }

    public static int getSaisieInt(int bound) {
        return getSaisieInt(bound, "Veuillez saisir un nombre valide");
    }

    public static int getSaisieInt(int bound, String errMsg) {
        int value = getSaisieInt();
        while (value < 0 && value >= bound) {
            System.out.println(errMsg);
            value = getSaisieInt(bound, errMsg);
        }

        return value;
    }

    public static float getSaisieFloatAbsolute() {
        return getSaisieFloatAbsolute("Veuillez saisir un nombre valide");
    }

    public static float getSaisieFloatAbsolute(String errMsg) {
        float value = getSaisieFloat();
        while (value < 0f) {
            System.out.println(errMsg);
            value = getSaisieFloat();
        }
        return value;
    }
}
