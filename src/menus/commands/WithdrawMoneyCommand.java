package menus.commands;

import bank.Account;
import entities.Person;
import menus.BankMenu;
import menus.LifeMenu;
import menus.Menu;

public class WithdrawMoneyCommand extends BankMenu implements Command, AccountFunction {
    @Override
    public void optionAction(Person person) {
        displayAccountEntry(person);
        int accountEntry = getAccountEntry(person);
        Account account = person.getAccounts().get(accountEntry);

        displayMoneyEntry(person, accountEntry, "withdraw");
        float moneyEntry = getMoneyEntry(person, person.getMoney());

        person.setMoney(person.getMoney() + moneyEntry);
        account.withdrawMoney(moneyEntry);
        System.out.println(
                new StringBuilder(person.getName())
                        .append(" has deposit ")
                        .append("%.2f".formatted(moneyEntry))
                        .append(" $ from the account n°")
                        .append("%03d".formatted(account.getId()))
        );
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
