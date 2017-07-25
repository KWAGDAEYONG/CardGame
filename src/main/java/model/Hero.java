package model;

import action.Actions;

import java.util.Scanner;

public class Hero {
    private String className;
    public Hero(String name){
        this.className = name;
    }

    public String getClassName() {
        return className;
    }

    public void useAbility(User player, User waiter, Hero hero, Actions actions, Scanner scanner){

        if(!player.canUseHeroAbility(player)){
            return;
        }

        switch (hero.className){
            case "마법사" :
                player.magicianAbility(player, waiter, scanner);
                player.useCost(player,2);
                System.out.println("화염작렬");
                break;
            case "사냥꾼" :
                player.bodyAttack(waiter,2);
                player.useCost(player,2);
                System.out.println("화살 쏘기");
                break;
            case "전사" :
                player.useCost(player,2);
                player.addArmor(player,2);
                System.out.println("방어력 강화");
                break;
            case "사제" :
                player.priestAbility(player,waiter,scanner);
                player.useCost(player,2);
                System.out.println("하급 치유");
                break;

            case "드루이드" :
                player.useCost(player,2);
                player.addArmor(player,1);
                break;
            case "도적" : break;
            case "흑마법사" :
                actions.draw(player);
                player.setHp(player.getHp()-2);
                player.useCost(player,2);
                System.out.println("생명력 전환");
            case "주술사" : break;
            case "성기사" :
                player.getField().add(new Card("신병",1,1,1));
                player.useCost(player,2);
                System.out.println("신병소환");
                break;
        }
        player.setUseHeroAbility(true);
    }
}
