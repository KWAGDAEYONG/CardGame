import Action.ActionImpl;
import Action.Actions;
import card.Card;
import card.Cards;
import user.Field;
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
        player1.setDeckList(player1s);

        //사용할 덱 선택
        List<Card> p1UseDeck = player1.getDeckList();

        //인게임 덱 구성
        shuffle(p1UseDeck);

        Stack<Card> player1GameDeck = new Stack<Card>();
        for(int i = 0; i<p1UseDeck.size(); i++){
            player1GameDeck.add((Card)p1UseDeck.get(i).clone());
        }
        player1.setUseDeck(player1GameDeck);

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
        player2.setDeckList(player2s);

        //사용할 덱 선택
        List<Card> p2UseDeck = player2.getDeckList();

        //인게임 덱 구성
        shuffle(p2UseDeck);

        Stack<Card> player2GameDeck = new Stack<Card>();
        for(int i = 0; i<p2UseDeck.size(); i++){
            player2GameDeck.add((Card)p2UseDeck.get(i).clone());
        }
        player2.setUseDeck(player2GameDeck);

        System.out.println("덱 셋팅 완료");
        System.out.println("게임 시작");

        Field player1Field = new Field();
        player1.setField(player1Field);
        Field player2Field = new Field();
        player2.setField(player2Field);
        player1.setTurn(true);
        player2.setTurn(false);

        System.out.println("핸드 선택");
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
        int i = 1;
        while(player1.getHp()>0&&player2.getHp()>0){
            System.out.println(i+"번째 턴");
            if(player1.isTurn()) {
                System.out.println("player1의 턴!");
                System.out.println("player1 드로우");
                action.draw(player1);


                //사용코스트 업
                int cost = player1.getTotalCost();
                player1.setTotalCost(cost+1);
                player1.setUseCost(player1.getTotalCost());
                player1.setGameScreen(player1,player2);
                player1.getGameScreen();

                //필드의 하수인들을 공격할 수 있도록 셋팅
                if(!player1.getField().getFieldCard().isEmpty()){
                    for(int k = 0; k<player1.getField().getFieldCard().size(); k++){
                        player1.getField().getFieldCard().get(k).setAlreadyAttack(false);
                        player1.getField().getFieldCard().get(k).setFirstTurn(false);
                    }
                }

                int c = 0;
                while (c!=-1) {
                    System.out.println("어떻게 하시겠습니까?");
                    System.out.println("1.핸드카드 사용");
                    System.out.println("2.필드카드 사용");
                    System.out.println("3.턴 넘기기");
                    c = scanner.nextInt();
                    switch (c) {
                        case 1:
                            System.out.println("핸드카드 사용");
                            action.useHand(player1);
                            break;
                        case 2:
                            System.out.println("필드카드 사용");
                            action.useField(player1,player2);
                            break;
                        case 3:
                            System.out.println("턴 넘기기");
                            c = -1;
                            action.next(player1,player2);
                            break;
                    }
                    if(player1.getHp()<=0||player2.getHp()<=0){
                        break;
                    }
                }
            }else{
                System.out.println("player2의 턴!");
                System.out.println("player2 드로우");
                action.draw(player2);


                //코스트업
                int cost = player2.getTotalCost();
                player2.setTotalCost(cost+1);
                player2.setUseCost(player2.getTotalCost());
                player2.setGameScreen(player2,player1);
                player2.getGameScreen();

                //필드의 하수인들을 공격할 수 있도록 셋팅
                if(!player2.getField().getFieldCard().isEmpty()){
                    for(int k = 0; k<player2.getField().getFieldCard().size(); k++){
                        player2.getField().getFieldCard().get(k).setAlreadyAttack(false);
                        player2.getField().getFieldCard().get(k).setFirstTurn(false);
                    }
                }

                int c = 0;
                while (c!=-1) {
                    System.out.println("어떻게 하시겠습니까?");
                    System.out.println("1.핸드카드 사용");
                    System.out.println("2.필드카드 사용");
                    System.out.println("3.턴 넘기기");

                    c = scanner.nextInt();
                    switch (c) {
                        case 1:
                            System.out.println("핸드카드 사용");
                            action.useHand(player2);
                            break;
                        case 2:
                            System.out.println("필드카드 사용");
                            action.useField(player2,player1);
                            break;
                        case 3:
                            System.out.println("턴 넘기기");
                            c = -1;
                            action.next(player1,player2);
                            break;
                    }
                    if(player1.getHp()<=0||player2.getHp()<=0){
                        break;
                    }
                }
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
}
