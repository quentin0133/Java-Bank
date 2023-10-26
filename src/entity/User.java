package entity;

import menu.Command;

import java.util.Scanner;
import java.util.function.Supplier;

public class User {
    private Scanner scanner = new Scanner(System.in);
    private Person currentPersonControlled;

    public Person getCurrentPersonControlled() {
        return currentPersonControlled;
    }

    public void setCurrentPersonControlled(Person currentPersonControlled) {
        this.currentPersonControlled = currentPersonControlled;
    }

    public void makeAction(Command command) {
        command.optionAction(this);
    }

    public int getSaisieInt() {
        return scanner.nextInt();
    }

    public float getSaisieFloat() {
        return scanner.nextFloat();
    }

    public static float checkPositiveFloat(Supplier<Float> method) {
        return checkPositiveFloat(method, "Error, you need to enter an positive value");
    }

    public static float checkPositiveFloat(Supplier<Float> method, String errMsg) {
        float value = method.get();
        if (value >= 0f) return value;
        System.out.println(errMsg);
        return checkPositiveFloat(method, errMsg);
    }

    public float checkMaxFloat(int max, Supplier<Float> method) {
        return checkMaxFloat(max, method, "Error, you need to enter an positive value");
    }

    public float checkMaxFloat(int max, Supplier<Float> method, String errMsg) {
        float value = method.get();
        if (value < max) return value;
        System.out.println(errMsg);
        return checkMaxFloat(max, method, errMsg);
    }

    public static int checkPositiveInt(Supplier<Integer> method) {
        return checkPositiveInt(method, "Error, you need to enter an positive value");
    }

    public static int checkPositiveInt(Supplier<Integer> method, String errMsg) {
        int value = method.get();
        if (value >= 0f) return value;
        System.out.println(errMsg);
        return checkPositiveInt(method, errMsg);
    }

    public int checkMaxInt(int max, Supplier<Integer> method) {
        return checkMaxInt(max, method, "Error, you need to enter an positive value");
    }

    public int checkMaxInt(int max, Supplier<Integer> method, String errMsg) {
        int value = method.get();
        if (value < max) return value;
        System.out.println(errMsg);
        return checkMaxInt(max, method, errMsg);
    }

    public int getSaisieInt(int bound) {
        return getSaisieInt(bound, "Veuillez saisir un nombre valide");
    }

    public int getSaisieInt(int bound, String errMsg) {
        return getSaisieInt(0, bound, errMsg);
    }

    public int getSaisieInt(int min, int max) {
        return getSaisieInt(min, max, "Veuillez saisir un nombre valide");
    }

    public int getSaisieInt(int min, int max, String errMsg) {
        int value = getSaisieInt();
        if (value < min || value >= max) {
            System.out.println(errMsg);
            value = getSaisieInt(min, max, errMsg);
        }

        return value;
    }

    public float getSaisieFloatAbsolute() {
        return getSaisieFloatAbsolute("Veuillez saisir un nombre valide");
    }

    public float getSaisieFloatAbsolute(String errMsg) {
        return getSaisieFloatAbsolute(Float.MAX_VALUE, errMsg);
    }

    public float getSaisieFloatAbsolute(float maxValue, String errMsg) {
        float value = getSaisieFloat();
        if (value < 0f || value > maxValue) {
            System.out.println(errMsg);
            value = getSaisieFloatAbsolute(maxValue, errMsg);
        }
        return value;
    }
}
