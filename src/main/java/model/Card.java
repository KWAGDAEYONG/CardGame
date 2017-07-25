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
    private String ability;
    private int attackCountForGale=2;
    private boolean alreadyAttack;
    private boolean firstTurn=true;

    public Card(String name,int hp, int cost, int ap, String ability){
        this.name = name;
        this.hp = hp;
        this.cost = cost;
        this.ap = ap;
        this.maxhp = hp;
        this.ability = ability;
    }

    public void setAbility(String ability) {
        this.ability = ability;
    }

    public String getAbility() {
        return ability;
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
        shield(attacker, target.ap);
        shield(target, attacker.ap);
    }

    public void heal(Card card, int ap){
        card.setHp(card.hp+ap);
    }

    public void shield(Card card, int ap){
        if(card.ability=="천상의보호막"){
            card.ability="일반";
        }else{
            card.hp = card.hp-ap;
        }
    }

    public void rush(Card card){
        card.firstTurn = false;
    }

    public void gale(Card attacker){
        System.out.println("질풍!");
        System.out.println(attacker.attackCountForGale);
        if(attacker.attackCountForGale!=1){
            --attacker.attackCountForGale;
        }else{
            attacker.alreadyAttack = true;
        }
    }

    @Override
    public Object clone()throws CloneNotSupportedException{
        return super.clone();
    }
}
