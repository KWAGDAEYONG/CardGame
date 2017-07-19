package Utility;

import user.User;

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
        System.out.println("         Other's hp:"+other.getHp()+"/cost:"+other.getTotalCost()+"           ");
        System.out.print("*");
        if(other.getField().getFieldCard().isEmpty()){
            System.out.print("                빈 필드                 *");
        }else {
            for (int i = 0; i < other.getField().getFieldCard().size(); i++) {
                System.out.print(other.getField().getFieldCard().get(i).getName()+"(hp:"+other.getField().getFieldCard().get(i).getHp()+"/ap:"+other.getField().getFieldCard().get(i).getAp()+")  ");
            }
            System.out.print("*");
        }
        System.out.println();
        System.out.println("==============================================");
        System.out.print("*");
        if(my.getField().getFieldCard().isEmpty()){
            System.out.print("                빈 필드                 *");
        }else {
            for (int i = 0; i < my.getField().getFieldCard().size(); i++) {
                System.out.print(my.getField().getFieldCard().get(i).getName()+"(hp:"+my.getField().getFieldCard().get(i).getHp()+"/ap:"+my.getField().getFieldCard().get(i).getAp()+")  ");
            }
            System.out.print("*");
        }
        System.out.println();
        System.out.println("         my hp:"+my.getHp()+"/cost:"+my.getUseCost()+"           ");
        System.out.println("********************************************");

    }
}
