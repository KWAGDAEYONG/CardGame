package user;

import card.Card;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 2017-07-18.
 */
public class Hand {
    private List<Card> handList = new ArrayList<Card>();

    public List<Card> getHandList() {
        return handList;
    }

    public void setHandList(List<Card> handList) {
        this.handList = handList;
    }
}
