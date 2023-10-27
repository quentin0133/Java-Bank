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

    public static float checkPositiveFloat(Supplier<Float> method, String errMsg) {
        float value = method.get();
        if (value >= 0f) return value;
        System.out.println(errMsg);
        return checkPositiveFloat(method, errMsg);
    }

    public Supplier<Float> checkMaxFloat(float max, Supplier<Float> method, String errMsg) {
        float value = method.get();
        if (value < max) return method;
        System.out.println(errMsg);
        return checkMaxFloat(max, method, errMsg);
    }

    public Supplier<Float> checkMinFloat(float min, Supplier<Float> method, String errMsg) {
        float value = method.get();
        if (value >= min) return method;
        System.out.println(errMsg);
        return checkMaxFloat(min, method, errMsg);
    }

    public Supplier<Integer> checkBoundInt(int min, int max, Supplier<Integer> method, String errMsg) {
        int value = method.get();
        if (value < max || value >= min) return method;
        System.out.println(errMsg);
        return checkBoundInt(min, max, method, errMsg);
    }
}
