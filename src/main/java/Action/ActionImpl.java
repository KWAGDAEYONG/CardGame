package Action;

import user.User;


/**
 * Created by user on 2017-07-18.
 */
public class ActionImpl implements Actions {

    @Override
    public void useHand(User player){
        player.useHand(player);
    }

    @Override
    public void draw(User player){
        player.draw(player);
    }

    @Override
    public void useField(User player, User waiter){
        player.useField(player,waiter);

    }

}
