package menus.commands;

import entities.Person;
import menus.Menu;

public interface Command {
    void optionAction(Person person);
    Menu getNextMenu();
}
