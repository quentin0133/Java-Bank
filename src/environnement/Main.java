package environnement;

import bank.entities.Person;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final int QUIT = -1;

    public static void main(String[] args) {
        //Menu currentMenu = new LifeMenu();

        Person person1 = new Person("Michael", 50f);
        person1.createAccount();

        Person currentPerson = person1;

        while (true) {
            int entry = startMenu(currentPerson, new ArrayList<>());
            if (entry == QUIT) break;
        }
    }

    private static int startMenu(Person person, List<String> listCommand) {
        displayMenuAction(listCommand);
        Scanner scanner = new Scanner(System.in);
        try {
            int entry = scanner.nextInt();
            if (entry == QUIT) return QUIT;
            //person.makeAction(listCommand.get(entry));
            return entry;
        }
        catch (InputMismatchException e) {
            System.out.println("Error, enter an number");
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error, select an valid option");
        }
        return startMenu(person, listCommand);
    }

    private static void displayMenuAction(List<String> accountCommands) {
        StringBuilder menuAction = new StringBuilder();
        for (int i = 0; i < accountCommands.size(); i++)
            menuAction.append(i).append(" - ").append(accountCommands.get(i)).append('\n');
        menuAction.append("-1 - Quit\n").append("Choose an action : ");
        System.out.print(menuAction);
    }
}
