package menu;

import entity.User;

public class WithdrawMoneyCommand extends BankCommand {
    @Override
    public void optionAction(User user) {
        // Withdraw money, need to ask account and money
    }

    @Override
    public String toString() {
        return "Withdraw money into an account";
    }
}
