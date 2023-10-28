package menus;

import entities.Person;
import menus.commands.Command;
import menus.commands.GoBankCommand;
import menus.commands.WorkCommand;

import java.util.List;

public class LifeMenu extends Menu {
    protected Person person;

    @Override
    public List<Command> getCommands() {
        return List.of(
                new WorkCommand(),
                new GoBankCommand()
        );
    }
}
