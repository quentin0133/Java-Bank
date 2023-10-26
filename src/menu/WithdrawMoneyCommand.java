package menu;

import entity.User;

public class WithdrawMoneyCommand implements Command {
    @Override
    public void optionAction(User user) {
        // Withdraw money, need to ask account and money
    }
}
