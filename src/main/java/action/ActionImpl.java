package action;

import model.Hero;
import model.User;

import java.util.Scanner;


/**
 * Created by user on 2017-07-18.
 */
public class ActionImpl implements Actions {

    @Override
    public void useHand(User player, Scanner scanner){
        player.useHand(player, scanner);
    }

    @Override
    public void draw(User player){
        player.draw(player);
    }

    @Override
    public void useField(User player, User waiter, Scanner scanner){
        player.useField(player,waiter, scanner);

    }

    @Override
    public void heroAbility(User player, User waiter, Hero hero, Actions actions, Scanner scanner){
        hero.useAbility(player, waiter, hero, actions, scanner);
    }

    @Override
    public void useWeapon(User player, User waiter, Scanner scanner){
        player.useWeapon(player, waiter, scanner);
    }

    @Override
    public void turnChange(User player, User waiter){
        player.turnChange(player, waiter);
    }
}
