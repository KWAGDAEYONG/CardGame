package Action;

import user.User;

/**
 * Created by user on 2017-07-18.
 */
public interface Actions {
    void useHand(User user);
    void next(User player1, User player2);
    void draw(User user);
    void useField(User player1, User player2);
}
