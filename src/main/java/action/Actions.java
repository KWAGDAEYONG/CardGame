package action;

import model.Hero;
import model.User;

import java.util.Scanner;

/**
 * Created by user on 2017-07-18.
 */
public interface Actions {
    void useHand(User user, Scanner scanner);
    void draw(User user);
    void useField(User player1, User waiter, Scanner scanner);
    void heroAbility(User player, User waiter, Hero hero, Actions actions, Scanner scanner);
}
