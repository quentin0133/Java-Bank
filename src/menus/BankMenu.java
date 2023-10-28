package menus;

import menus.commands.Command;
import menus.commands.DepositMoneyCommand;
import menus.commands.WithdrawMoneyCommand;

import java.util.List;

public class BankMenu extends Menu {
    @Override
    public List<Command> getCommands() {
        return List.of(
                new DepositMoneyCommand(),
                new WithdrawMoneyCommand()
        );
    }
}
