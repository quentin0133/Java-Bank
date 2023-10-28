package environnement;

import entities.Person;
import menus.LifeMenu;
import menus.Menu;
import menus.commands.Command;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final int QUIT = -1;

    public static void main(String[] args) {
        Menu currentMenu = new LifeMenu();

        Person person1 = new Person("Michael", 50f);
        person1.createAccount();

        Person currentPerson = person1;

        while (true) {
            var commands = currentMenu.getCommands();
            int entry = startMenu(currentPerson, commands);
            if (entry == QUIT) break;
            currentMenu = commands.get(entry).getNextMenu();
        }

        System.out.println(person1.recap());
    }

    private static int startMenu(Person person, List<Command> listCommand) {
        displayMenuAction(listCommand);
        Scanner scanner = new Scanner(System.in);
        try {
            int entry = scanner.nextInt();
            if (entry == QUIT) return QUIT;
            person.makeAction(listCommand.get(entry));
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

    private static void displayMenuAction(List<Command> accountCommands) {
        StringBuilder menuAction = new StringBuilder();
        for (int i = 0; i < accountCommands.size(); i++)
            menuAction.append(i).append(" - ").append(accountCommands.get(i)).append('\n');
        menuAction.append("-1 - Quit\n").append("Choose an action : ");
        System.out.print(menuAction);
    }
}
