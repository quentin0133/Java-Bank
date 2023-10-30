package menus.commands;

import entities.Account;
import entities.Person;
import menus.BankMenu;
import menus.LifeMenu;
import menus.Menu;

public class WithdrawMoneyCommand extends BankMenu implements Command, AccountFunction {
    @Override
    public void optionAction(Person person) {
    }

    @Override
    public Menu getNextMenu() {
        return new LifeMenu();
    }

    @Override
    public String toString() {
        return "Withdraw money into an account";
    }
}
