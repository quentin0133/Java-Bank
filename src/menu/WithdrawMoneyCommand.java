package menu;

import entity.Person;

public class WithdrawMoneyCommand implements Command {
    @Override
    public void optionAction(Person person) {
        // Withdraw money, need to ask account and money
    }
}
