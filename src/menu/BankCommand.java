package menu;

import entity.Person;
import entity.User;

public abstract class BankCommand implements Command {
    protected static int getAccountEntry(User user, Person person) {
        // Check if the entry is between 0 and the number of account - 1
        return user.checkBoundInt(0, person.getAccounts().size(), user::getSaisieInt, "Error, select an valid account").get();
    }

    protected static float getMoneyEntry(User user, Person person) {
        // Check if the entry is between 0 and the money the person has
        return user.checkMinFloat(
                0f, user.checkMaxFloat(
                        person.getMoney(), user::getSaisieFloat, "Error, you don't have enough money"
                ), "Error, you don't have enough money"
        ).get();
    }
}
