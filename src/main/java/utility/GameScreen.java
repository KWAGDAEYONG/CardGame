package utility;

import model.User;

/**
 * Created by user on 2017-07-18.
 */
public class GameScreen {
    private User my;
    private User other;

    public GameScreen(User my, User other){
        this.my = my;
        this.other = other;
    }

    public void show(){
        System.out.println("********************************************");
        System.out.println(other.getInGameDeck().getHero().getClassName());
        System.out.println("         Other's hp:"+other.getHp()+"/cost:"+other.getTotalCost()+"           ");
        if(other.getWeapon()!=null){
            System.out.println("Other's weapon:"+other.getWeapon().getName()+"(회수:"+other.getWeapon().getCount()+"/공격력:"+other.getWeapon().getAp()+")");
        }
        if(other.getArmor()!=0){
            System.out.println("Other's armor:"+other.getArmor());
        }
        System.out.print("*");
        if(other.getField().isEmpty()){
            System.out.print("                빈 필드                 *");
        }else {
            for (int i = 0; i < other.getField().size(); i++) {
                System.out.print(other.getField().get(i).getName()+"(hp:"+other.getField().get(i).getHp()+"/ap:"+other.getField().get(i).getAp()+")  ");
            }
            System.out.print("*");
        }
        System.out.println();
        System.out.println("==============================================");
        System.out.print("*");
        if(my.getField().isEmpty()){
            System.out.print("                빈 필드                 *");
        }else {
            for (int i = 0; i < my.getField().size(); i++) {
                System.out.print(my.getField().get(i).getName()+"(hp:"+my.getField().get(i).getHp()+"/ap:"+my.getField().get(i).getAp()+")  ");
            }
            System.out.print("*");
        }
        System.out.println();
        if(my.getArmor()!=0){
            System.out.println("my armor:"+my.getArmor());
        }
        if(my.getWeapon()!=null){
            System.out.println("my weapon:"+my.getWeapon().getName()+"(회수:"+my.getWeapon().getCount()+"/공격력:"+my.getWeapon().getAp()+")");
        }
        System.out.println("         my hp:"+my.getHp()+"/cost:"+my.getUseCost()+"           ");
        System.out.println(my.getInGameDeck().getHero().getClassName());
        System.out.println("********************************************");

    }
}
