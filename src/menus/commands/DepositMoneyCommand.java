package menus.commands;

import entities.Account;
import entities.Person;
import menus.LifeMenu;
import menus.Menu;

public class DepositMoneyCommand implements Command, AccountFunction {

    @Override
    public void optionAction(Person person) {

    }

    @Override
    public Menu getNextMenu() {
        return new LifeMenu();
    }

    @Override
    public String toString() {
        return "Deposit money into an account";
    }
}
