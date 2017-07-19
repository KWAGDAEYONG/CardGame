package card;

/**
 * Created by user on 2017-07-18.
 */
public class Card implements Cloneable{
    private String name;
    private int hp;
    private int cost;
    private int ap;
    private boolean alreadyAttack;
    private boolean firstTurn=true;


    Card(String name,int hp, int cost, int ap){
        this.name = name;
        this.hp = hp;
        this.cost = cost;
        this.ap = ap;
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


    public void setHp(int hp) {
        this.hp = hp;
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

    @Override
    public Object clone()throws CloneNotSupportedException{
        return super.clone();
    }
}
