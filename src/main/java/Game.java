import Action.ActionImpl;
import Action.Actions;
import Utility.SetTempDeck;
import card.Card;
import user.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Game {
    private Scanner scanner = new Scanner(System.in);

    public void play()throws CloneNotSupportedException{
        Actions action = new ActionImpl();

        //플레이어 셋팅
        User player1 = new User();
        player1.setPlayer("player1");
        User player2 = new User();
        player2.setPlayer("player2");

        readyForGame(player1, player2);

        //game start!
        System.out.println("게임 시작");
        int i = 1;
        while(!isGameOver(player1,player2)){
            System.out.println(i+"번째 턴");
            if(player1.isTurn()) {
                System.out.println("player1의 턴!");
                System.out.println("player1 드로우");
                gamePlay(player1,player2,action);
            }else{
                System.out.println("player2의 턴!");
                System.out.println("player2 드로우");
                action.draw(player2);
                gamePlay(player2,player1,action);
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

    public void gamePlay(User player, User waiter, Actions action){

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

    public void turnChange(User player, User waiter){
        player.setTurn(false);
        waiter.setTurn(true);
    }

    public boolean isGameOver(User player1, User player2){
        if(player1.getHp()<=0||player2.getHp()<=0){
            return true;
        }else{
            return false;
        }
    }

    public void readyForGame(User player1, User player2)throws CloneNotSupportedException{

        //덱 셋팅
        SetTempDeck.setDeck(player1);
        SetTempDeck.choiceIngameDeck(player1, scanner);
        SetTempDeck.setDeck(player2);
        SetTempDeck.choiceIngameDeck(player2, scanner);

        //필드 셋팅
        List<Card> player1Field = new ArrayList<Card>();
        player1.setField(player1Field);
        List<Card> player2Field = new ArrayList<Card>();
        player2.setField(player2Field);

        player1.setTurn(true);
        player2.setTurn(false);

        //핸드 셋팅
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
    }

}

