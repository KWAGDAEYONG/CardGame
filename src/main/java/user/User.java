package user;

import Utility.GameScreen;
import card.Card;

import java.util.List;
import java.util.Stack;

/**
 * Created by user on 2017-07-18.
 */
public class User {
    final int maxCost = 10;
    private int hp = 30;
    private int totalCost = 0;
    private int useCost;
    private Deck deckList;
    private Stack<Card> useDeck;
    private Hand hand;
    private Field field;
    private boolean turn;
    private GameScreen gameScreen;

    public void setUseCost(int useCost) {
        this.useCost = useCost;
    }

    public int getUseCost() {
        return useCost;
    }

    public Stack<Card> getUseDeck() {
        return useDeck;
    }

    public void setUseDeck(Stack<Card> useDeck) {
        this.useDeck = useDeck;
    }

    public void setGameScreen(User my, User other){
        this.gameScreen = new GameScreen(my, other);
    }

    public void getGameScreen(){
        this.gameScreen.show();
    }

    public void setTurn(boolean turn) {
        this.turn = turn;
    }

    public boolean isTurn() {
        return turn;
    }

    public void setField(Field field) {
        this.field = field;
    }

    public Field getField() {
        return field;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setTotalCost(int totalCost) {
        if(totalCost<=maxCost) {
            this.totalCost = totalCost;
        }
    }

    public int getHp() {
        return hp;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public void setDeckList(List<Card> cards) {
        this.deckList = new Deck();
        this.deckList.setDeckList(cards);
    }

    public void setHand(List<Card> cards) {
        this.hand = new Hand();
        this.hand.setHandList(cards);
    }

    public List<Card> getDeckList() {
        return deckList.getDeckList();
    }

    public List<Card> getHand() {
        return hand.getHandList();
    }
}
