package model;

import contents.Heros;

import java.util.List;
import java.util.Scanner;

/**
 * Created by user on 2017-07-18.
 */
public class Deck {
    private String Deckname;
    private List<Card> cards;
    private Hero hero;

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

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public Hero getHero() {
        return hero;
    }

    public void choiceHeroClass(User player, Deck deck, Scanner scanner){
        Heros heros = new Heros();
        heros.setHeroList();
        System.out.println(player.getPlayer()+"님, 직업을 선택해주세요");

        for(int i = 0; i<heros.getHeroList().size(); i++){
            System.out.println(i+". "+heros.getHeroList().get(i).getClassName());
        }
        int sc = scanner.nextInt();

        deck.hero = heros.getHeroList().get(sc);
    }

}
