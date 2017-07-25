package model;

/**
 * Created by user on 2017-07-18.
 */
public class Card implements Cloneable{
    private String name;
    private int hp;
    private int cost;
    private int ap;
    private int maxhp;
    private boolean alreadyAttack;
    private boolean firstTurn=true;


    public Card(String name,int hp, int cost, int ap){
        this.name = name;
        this.hp = hp;
        this.cost = cost;
        this.ap = ap;
        this.maxhp = hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
        if(this.hp > maxhp){
            this.hp = maxhp;
            System.out.println("이미 최대체력 입니다!");
        }
    }

    public void setFirstTurn(boolean firstTurn) {
        this.firstTurn = firstTurn;
    }

    public boolean isFirstTurn() {
        return firstTurn;
    }

    public void setAlreadyAttack(boolean alreadyAttack) {
        this.alreadyAttack = alreadyAttack;
    }

    public boolean isAlreadyAttack() {
        return alreadyAttack;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public int getCost() {
        return cost;
    }

    public int getAp() {
        return ap;
    }

    public void attackEffect(Card attacker, Card target){
        attacker.hp = attacker.hp-target.ap;
        target.hp = target.hp-attacker.ap;
    }

    public void heal(Card card, int ap){
        card.setHp(card.hp+ap);
    }

    @Override
    public Object clone()throws CloneNotSupportedException{
        return super.clone();
    }
}
