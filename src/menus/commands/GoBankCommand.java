package menus.commands;

import entities.Person;
import menus.BankMenu;
import menus.Menu;

public class GoBankCommand implements Command {

    // Je sais, ce n'est pas bien mais je ne vois pas comment faire autrement
    @Override
    public void optionAction(Person person) {
        System.out.println("You go to your bank account");
    }

    @Override
    public Menu getNextMenu() {
        return new BankMenu();
    }

    @Override
    public String toString() {
        return "Go to your bank account";
    }
}
