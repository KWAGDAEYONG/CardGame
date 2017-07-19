package user;

import card.Card;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 2017-07-18.
 */
public class Deck {
    private List<Card> deckList = new ArrayList<Card>();

    public void setDeckList(List<Card> deckList) {
        this.deckList = deckList;
    }

    public List<Card> getDeckList() {
        return deckList;
    }
}
