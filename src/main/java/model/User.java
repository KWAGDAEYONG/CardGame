package model;

import utility.GameScreen;
import contents.Cards;

import java.util.*;

import static java.util.Collections.shuffle;

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
    private Deck inGameDeck;

    public void setInGameDeck(Deck inGameDeck) {
        this.inGameDeck = inGameDeck;
    }

    public Deck getInGameDeck() {
        return inGameDeck;
    }

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

    public void useHand(User user, Scanner scanner){
        hand = user.hand;
        if(hand.isEmpty()){
            System.out.println("핸드가 없습니다");
            return;
        }
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
        useCost(user,target.getCost());
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

    public void useField(User player, User waiter, Scanner scanner){
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

    public void makeDeck(User player, Scanner scanner){
        Cards cards = new Cards();
        cards.setCardList();
        //카드 리스트 로드

        Deck deck = new Deck();
        System.out.println("덱을 생성합니다.");
        deck.choiceHeroClass(player, deck ,scanner);

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

        System.out.println("편의상, 덱의 카드리스트는 자동생성합니다.");
        System.out.println("덱의 이름을 입력해주세요");
        String name = scanner.next();
        deck.setDeckname(name);

        if(deckList.size()!=30){
            System.out.println("카드의 장수가 맞지 않습니다");
            //이후 클라이언트에서 다시 카드선택화면으로 돌리면서 덱 리스트에 저장되지 않도록 처리
        }

        deck.setCards(deckList);
        player.addDeck(deck);

    }

    public void choiceDeckForGame(User player, Scanner scanner)throws CloneNotSupportedException{
        System.out.println(player.getPlayer()+"님, 사용하실 덱을 선택해주세요");

        for(int i = 0; i<player.getDeckList().size(); i++){
            System.out.println(i+". "+player.getDeckList().get(i).getDeckname());
        }
        int sc = scanner.nextInt();
        Deck inGameDeck = player.getDeckList().get(sc);
        player.setInGameDeck(inGameDeck);
        List<Card> DeckForUse = player.getDeckList().get(sc).getCards();

        shuffle(DeckForUse);
        Stack<Card> useDeck = new Stack<Card>();

        for(int i = 0; i<DeckForUse.size(); i++){
            useDeck.add((Card)DeckForUse.get(i).clone());
        }
        player.setUseDeck(useDeck);
    }

    public void useCost(User player, int useCost){
        player.useCost -= useCost;
    }


}
