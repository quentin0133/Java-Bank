package menu;

import entity.Person;

public class DepositMoneyCommand implements Command {
    @Override
    public void optionAction(Person person) {
        // Deposit money, need to ask account and money
    }
}
