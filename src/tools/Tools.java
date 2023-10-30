package tools;

import entities.Person;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Tools {
    public static int getAccountEntry(int accountSize, Person person) {
        Scanner scanner = new Scanner(System.in);
        try {
            int value = scanner.nextInt();
            if (accountSize > value && 0 <= value)
                return value;
            System.out.println("Error, select an valid option");
        }
        catch (InputMismatchException e) {
            System.out.println("Error, enter an number");
        }
        return getAccountEntry(accountSize, person);
    }

    public static float getMoneyEntry(Person person, float maxEntry) {
        Scanner scanner = new Scanner(System.in);
        try {
            float value = scanner.nextFloat();
            if (value >= 0 && value <= maxEntry)
                return value;
            else if (value > person.getMoney())
                System.out.println("You don't have enough money, try again");
            else
                System.out.println("Error, enter an positive number");
        }
        catch (InputMismatchException e) {
            System.out.println("Error, enter an number");
        }
        return getMoneyEntry(person, maxEntry);
    }
}
