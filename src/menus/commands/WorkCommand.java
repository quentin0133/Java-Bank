package menus.commands;

import entities.Person;
import menus.LifeMenu;
import menus.Menu;

public class WorkCommand implements Command {
    @Override
    public void optionAction(Person person) {
        person.setMoney(person.getMoney() + 150f);
        System.out.println("After a long day of work, you gained 150 $");
        System.out.println(person);
    }

    @Override
    public Menu getNextMenu() {
        return new LifeMenu();
    }

    @Override
    public String toString() {
        return "Go work (gain 150 $)";
    }
}
