package Utility;

import card.Card;
import card.Cards;
import user.Deck;
import user.User;

import java.util.*;

import static java.util.Collections.shuffle;

public class SetTempDeck {
    public static void setDeck(User user){
        Cards cards = new Cards();
        cards.setCardList();
        //카드 리스트 로드

        Deck deck = new Deck();
        System.out.println("덱을 생성합니다.");

        List<Card> deckList = new ArrayList<Card>();

        Map<String,Card> cardList = cards.getCardList();

        deckList.add(cardList.get("병아리"));
        deckList.add(cardList.get("지렁이"));
        deckList.add(cardList.get("붕어"));
        deckList.add(cardList.get("닭"));
        deckList.add(cardList.get("강아지"));
        deckList.add(cardList.get("고양이"));
        deckList.add(cardList.get("큰개"));
        deckList.add(cardList.get("살쾡이"));
        deckList.add(cardList.get("여우"));
        deckList.add(cardList.get("늑대"));
        deckList.add(cardList.get("타조"));
        deckList.add(cardList.get("사냥개"));
        deckList.add(cardList.get("곰"));
        deckList.add(cardList.get("하마"));
        deckList.add(cardList.get("상어"));
        deckList.add(cardList.get("호랑이"));
        deckList.add(cardList.get("사자"));
        deckList.add(cardList.get("치타"));
        deckList.add(cardList.get("코끼리"));
        deckList.add(cardList.get("코뿔소"));
        deckList.add(cardList.get("독수리"));
        deckList.add(cardList.get("총잡이"));
        deckList.add(cardList.get("헌터"));
        deckList.add(cardList.get("사육사"));
        deckList.add(cardList.get("용"));
        deckList.add(cardList.get("불사조"));
        deckList.add(cardList.get("십장생"));
        deckList.add(cardList.get("개발자"));
        deckList.add(cardList.get("엔지니어"));
        deckList.add(cardList.get("곽대용"));

        deck.setDeckname(user.getPlayer()+"'s basic deck");
        deck.setCards(deckList);
        user.addDeck(deck);
    }

    public static void choiceIngameDeck(User user, Scanner scanner)throws CloneNotSupportedException{


        System.out.println(user.getPlayer()+"님, 사용하실 덱을 선택해주세요");
        for(int i = 0; i<user.getDeckList().size(); i++){
            System.out.println(i+". "+user.getDeckList().get(i).getDeckname());
        }
        int sc = scanner.nextInt();

        List<Card> DeckForUse = user.getDeckList().get(sc).getCards();

        shuffle(DeckForUse);
        Stack<Card> inGameDeck = new Stack<Card>();

        for(int i = 0; i<DeckForUse.size(); i++){
            inGameDeck.add((Card)DeckForUse.get(i).clone());
        }
        user.setUseDeck(inGameDeck);
    }
}
