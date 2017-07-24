package user;

import Utility.GameScreen;
import card.Card;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by user on 2017-07-18.
 */
public class User {
    final int maxCost = 10;
    private int hp = 30;
    private int totalCost = 0;
    private int useCost;
    private String player;
    private List<Deck> deckList = new ArrayList<Deck>();
    private Stack<Card> useDeck;
    private List<Card> hand;
    private List<Card> field;
    private boolean turn;
    private GameScreen gameScreen;

    public void setPlayer(String player) {
        this.player = player;
    }

    public String getPlayer() {
        return player;
    }

    public void addDeck(Deck deck){
        deckList.add(deck);
    }

    public List<Deck> getDeckList() {
        return deckList;
    }

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

    public void setField(List<Card> field) {
        this.field = field;
    }

    public List<Card> getField() {
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


    public void setHand(List<Card> hand) {
        this.hand = hand;
    }

    public void useHand(User user){
        hand = user.hand;
        if(hand.isEmpty()){
            System.out.println("핸드가 없습니다");
            return;
        }
        Scanner scanner = new Scanner(System.in);
        int i;
        System.out.println("어떤 카드를 사용하시겠습니까?"+"사용할 수 있는 코스트:"+user.getUseCost());
        for(i = 0; i<hand.size(); i++){
            System.out.println(i+". "+hand.get(i).getName()+"(hp:"+hand.get(i).getHp()+"/ap:"+hand.get(i).getAp()+"/cost:"+hand.get(i).getCost()+")");
        }
        System.out.println(i+". 돌아가기");
        int cardNum = scanner.nextInt();

        //돌아가기
        if(cardNum==hand.size()){
            return;
        }
        Card target = hand.get(cardNum);
        if(!canUseHandCard(user, target)){
            return;
        }
        user.field.add(target);
        user.setUseCost(user.getUseCost()-target.getCost());
        System.out.println("필드에 " + target.getName() + "을(를) 소환합니다.");
        hand.remove(cardNum);
    }

    public void draw(User user){
        Card drawed = user.useDeck.pop();
        if(user.hand.size()>9){
            System.out.println("더 이상 카드를 가질 수 없습니다. 카드가 타버립니다.");
            return;
        }
        user.hand.add(drawed);
    }

    public void useField(User player, User waiter){
        Scanner scanner = new Scanner(System.in);

        if(player.field.isEmpty()){
            System.out.println("필드에 하수인이 없습니다");
            return;
        }
        System.out.println("어떤 카드를 사용하시겠습니까?");
        int i;
        for(i = 0; i<player.field.size(); i++) {
            System.out.println(i+". "+player.field.get(i).getName()+"(hp:"+player.field.get(i).getHp()+"/ap:"+player.field.get(i).getAp()+")");
        }
        System.out.println(i+". 돌아가기");

        int cardNum = scanner.nextInt();
        if(cardNum==player.field.size()){
            return;
        }
        Card attacker = player.field.get(cardNum);

        if(!canAttack(attacker)){
            return;
        }

        attack(player,cardNum,attacker,waiter,scanner);

    }

    public boolean canUseHandCard(User player, Card card){

        if(card.getCost()>player.getUseCost()){
            System.out.println("사용할 수 있는 코스트가 모자랍니다.");
            return false;
        }
        if(player.field.size()>=7){
            System.out.println("더이상 필드에 하수인을 소환할 수 없습니다");
            return false;
        }

        return true;
    }


    public void attack(User player,int cardNum, Card attacker, User waiter, Scanner scanner){
        System.out.println("어디를 공격하시겠습니까?");
        int k;
        for(k = 0; k<waiter.field.size(); k++) {
            System.out.println(k+". "+waiter.field.get(k).getName()+"(hp:"+waiter.field.get(k).getHp()+"/ap:"+waiter.field.get(k).getAp()+")");
        }
        System.out.println(k+". 명치");
        System.out.println(++k+". 돌아가기");
        scanner.nextLine();

        int targetNum = scanner.nextInt();
        if(targetNum==waiter.field.size()+1){
            return;
        }
        if(waiter.field.size()==targetNum){
            //명치 공격
            waiter.setHp(waiter.getHp()-attacker.getAp());
            attacker.setAlreadyAttack(true);
        }else{
            //필드 공격
            attacker.attackEffect(attacker,waiter.field.get(targetNum));
            attacker.setAlreadyAttack(true);
            if(attacker.getHp()<=0){
                player.field.remove(cardNum);
            }
            if(waiter.field.get(targetNum).getHp()<=0){
                waiter.field.remove(targetNum);
            }
        }
    }

    public boolean canAttack(Card attacker){
        if(attacker.isFirstTurn()){
            System.out.println("소환 후 다음 턴 부터 공격할 수 있습니다");
            return false;
        }
        if(attacker.isAlreadyAttack()){
            System.out.println("이미 공격한 하수인입니다");
            return false;
        }
        return true;
    }
}
