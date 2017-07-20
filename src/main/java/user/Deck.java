package user;

import card.Card;

import java.util.List;

/**
 * Created by user on 2017-07-18.
 */
public class Deck {
    private String Deckname;
    private List<Card> cards;

    public String getDeckname() {
        return Deckname;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setDeckname(String deckname) {
        Deckname = deckname;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }
}
