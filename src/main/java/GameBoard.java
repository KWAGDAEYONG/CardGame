import Action.ActionImpl;
import Action.Actions;
import card.Card;
import card.Cards;
import user.Deck;
import user.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

import static java.util.Collections.shuffle;


/**
 * Created by user on 2017-07-18.
 */
public class GameBoard {
    public static void main(String[]args)throws CloneNotSupportedException{
        Scanner scanner = new Scanner(System.in);
        Actions action = new ActionImpl();
        Cards cards = new Cards();
        cards.setCardList();
        System.out.println("카드 리스트 로드");

        System.out.println("Player 셋팅");
        User player1 = new User();
        User player2 = new User();

        System.out.println("덱 셋팅");

        System.out.println("player1 덱 생성");
        Deck player1Deck = new Deck();

        List<Card> player1s = new ArrayList<Card>();
        player1s.add(cards.cardList.get("병아리"));
        player1s.add(cards.cardList.get("지렁이"));
        player1s.add(cards.cardList.get("붕어"));
        player1s.add(cards.cardList.get("닭"));
        player1s.add(cards.cardList.get("강아지"));
        player1s.add(cards.cardList.get("고양이"));
        player1s.add(cards.cardList.get("큰개"));
        player1s.add(cards.cardList.get("살쾡이"));
        player1s.add(cards.cardList.get("여우"));
        player1s.add(cards.cardList.get("늑대"));
        player1s.add(cards.cardList.get("타조"));
        player1s.add(cards.cardList.get("사냥개"));
        player1s.add(cards.cardList.get("곰"));
        player1s.add(cards.cardList.get("하마"));
        player1s.add(cards.cardList.get("상어"));
        player1s.add(cards.cardList.get("호랑이"));
        player1s.add(cards.cardList.get("사자"));
        player1s.add(cards.cardList.get("치타"));
        player1s.add(cards.cardList.get("코끼리"));
        player1s.add(cards.cardList.get("코뿔소"));
        player1s.add(cards.cardList.get("독수리"));
        player1s.add(cards.cardList.get("총잡이"));
        player1s.add(cards.cardList.get("헌터"));
        player1s.add(cards.cardList.get("사육사"));
        player1s.add(cards.cardList.get("용"));
        player1s.add(cards.cardList.get("불사조"));
        player1s.add(cards.cardList.get("십장생"));
        player1s.add(cards.cardList.get("개발자"));
        player1s.add(cards.cardList.get("엔지니어"));
        player1s.add(cards.cardList.get("곽대용"));

        player1Deck.setDeckname("basic deck");
        player1Deck.setCards(player1s);
        player1.addDeck(player1Deck);

        //사용할 덱 선택
        List<Card> p1UseDeck = player1.getDeckList().get(0).getCards();

        //인게임 덱 구성
        shuffle(p1UseDeck);

        Stack<Card> player1GameDeck = new Stack<Card>();
        for(int i = 0; i<p1UseDeck.size(); i++){
            player1GameDeck.add((Card)p1UseDeck.get(i).clone());
        }
        player1.setUseDeck(player1GameDeck);

        System.out.println("player2 덱 생성");
        Deck player2Deck = new Deck();

        List<Card> player2s = new ArrayList<Card>();
        player2s.add(cards.cardList.get("병아리"));
        player2s.add(cards.cardList.get("지렁이"));
        player2s.add(cards.cardList.get("붕어"));
        player2s.add(cards.cardList.get("닭"));
        player2s.add(cards.cardList.get("강아지"));
        player2s.add(cards.cardList.get("고양이"));
        player2s.add(cards.cardList.get("큰개"));
        player2s.add(cards.cardList.get("살쾡이"));
        player2s.add(cards.cardList.get("여우"));
        player2s.add(cards.cardList.get("늑대"));
        player2s.add(cards.cardList.get("타조"));
        player2s.add(cards.cardList.get("사냥개"));
        player2s.add(cards.cardList.get("곰"));
        player2s.add(cards.cardList.get("하마"));
        player2s.add(cards.cardList.get("상어"));
        player2s.add(cards.cardList.get("호랑이"));
        player2s.add(cards.cardList.get("사자"));
        player2s.add(cards.cardList.get("치타"));
        player2s.add(cards.cardList.get("코끼리"));
        player2s.add(cards.cardList.get("코뿔소"));
        player2s.add(cards.cardList.get("독수리"));
        player2s.add(cards.cardList.get("총잡이"));
        player2s.add(cards.cardList.get("헌터"));
        player2s.add(cards.cardList.get("사육사"));
        player2s.add(cards.cardList.get("용"));
        player2s.add(cards.cardList.get("불사조"));
        player2s.add(cards.cardList.get("십장생"));
        player2s.add(cards.cardList.get("개발자"));
        player2s.add(cards.cardList.get("엔지니어"));
        player2s.add(cards.cardList.get("곽대용"));

        player2Deck.setDeckname("basic deck");
        player2Deck.setCards(player2s);
        player2.addDeck(player2Deck);

        //사용할 덱 선택
        List<Card> p2UseDeck = player2.getDeckList().get(0).getCards();

        //인게임 덱 구성
        shuffle(p2UseDeck);

        Stack<Card> player2GameDeck = new Stack<Card>();
        for(int i = 0; i<p2UseDeck.size(); i++){
            player2GameDeck.add((Card)p2UseDeck.get(i).clone());
        }
        player2.setUseDeck(player2GameDeck);

        System.out.println("덱 셋팅 완료");


        //필드 셋팅
        List<Card> player1Field = new ArrayList<Card>();
        player1.setField(player1Field);
        List<Card> player2Field = new ArrayList<Card>();
        player2.setField(player2Field);

        //선플레이어 지정
        player1.setTurn(true);
        player2.setTurn(false);

        //핸드 셋팅
        System.out.println("첫 핸드 선택");
        List<Card> player1sHand = new ArrayList<Card>();

        for(int i = 0; i<4; i++){
            player1sHand.add(player1.getUseDeck().pop());
        }
        player1.setHand(player1sHand);

        List<Card> player2sHand = new ArrayList<Card>();
        for(int i = 0; i<4; i++){
            player2sHand.add(player2.getUseDeck().pop());
        }
        player2.setHand(player2sHand);
        //핸드 셋팅 끝

        System.out.println("게임 시작");
        int i = 1;
        while(!isGameOver(player1,player2)){
            System.out.println(i+"번째 턴");
            if(player1.isTurn()) {
                System.out.println("player1의 턴!");
                System.out.println("player1 드로우");
                gamePlay(player1,player2,action,scanner);
            }else{
                System.out.println("player2의 턴!");
                System.out.println("player2 드로우");
                action.draw(player2);
                gamePlay(player2,player1,action,scanner);
            }
            i++;
        }

        System.out.println("게임끝");
        if(player1.getHp()>0){
            System.out.println("player1 승리");
        }else{
            System.out.println("player2 승리");
        }
    }

    public static void gamePlay(User player, User waiter, Actions action, Scanner scanner){

        //드로우
        action.draw(player);

        //사용코스트 업
        int cost = player.getTotalCost();
        player.setTotalCost(cost+1);
        player.setUseCost(player.getTotalCost());

        //필드의 하수인들을 공격할 수 있도록 셋팅
        if(!player.getField().isEmpty()){
            for(int k = 0; k<player.getField().size(); k++){
                player.getField().get(k).setAlreadyAttack(false);
                player.getField().get(k).setFirstTurn(false);
            }
        }
        int c = 0;
        while (c!=-1) {
            player.setGameScreen(player, waiter);
            player.getGameScreen();
            System.out.println("어떻게 하시겠습니까?");
            System.out.println("1.핸드카드 사용");
            System.out.println("2.필드카드 사용");
            System.out.println("3.턴 넘기기");
            c = scanner.nextInt();
            switch (c) {
                case 1:
                    action.useHand(player);
                    break;
                case 2:
                    action.useField(player,waiter);
                    break;
                case 3:
                    c = -1;
                    turnChange(player,waiter);
                    break;
            }
            if(isGameOver(player,waiter)){
                break;
            }
        }
    }

    public static void turnChange(User player, User waiter){
        player.setTurn(false);
        waiter.setTurn(true);
    }

    public static boolean isGameOver(User player1, User player2){
        if(player1.getHp()<=0||player2.getHp()<=0){
            return true;
        }else{
            return false;
        }
    }

}
