package menus;

import menus.commands.Command;

import java.util.List;

public abstract class Menu {
    public abstract List<Command> getCommands();
}
