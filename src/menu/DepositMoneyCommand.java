package menu;

import entity.Person;
import entity.User;

public class DepositMoneyCommand extends BankCommand {
    @Override
    public void optionAction(User user) {
        Person person = user.getCurrentPersonControlled();

        System.out.println("Choose an account :");
        person.getAccounts().forEach(System.out::println);
        int accountEntry = getAccountEntry(user, person);

        System.out.println("Choose the amount you want to deposit :");
        System.out.println(person);
        System.out.println(person.getAccounts().get(accountEntry));
        float moneyEntry = getMoneyEntry(user, person);

        person.setMoney(person.getMoney() - moneyEntry);
        person.getAccounts().get(accountEntry).depositMoney(moneyEntry);
    }

    @Override
    public String toString() {
        return "Deposit money into an account";
    }
}
