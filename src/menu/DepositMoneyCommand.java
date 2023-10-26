package menu;

import entity.Person;
import entity.User;

public class DepositMoneyCommand implements Command {
    @Override
    public void optionAction(User user) {
        Person person = user.getCurrentPersonControlled();

        System.out.println("Choose an account :");
        person.getAccounts().forEach(System.out::println);
        int accountEntry = user.getSaisieInt(person.getAccounts().size());

        System.out.println("Choose the amount you want to deposit :");
        System.out.println(person);
        System.out.println(person.getAccounts().get(accountEntry));
        float moneyEntry = user.getSaisieFloatAbsolute(person.getMoney(), "Vous n'avez pas assez d'argent");

        person.setMoney(person.getMoney() - moneyEntry);
        person.getAccounts().get(accountEntry).depositMoney(moneyEntry);
    }
}
