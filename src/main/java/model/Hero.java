package model;

import action.Actions;

public class Hero {
    private String className;
    public Hero(String name){
        this.className = name;
    }

    public String getClassName() {
        return className;
    }

    public void useAbility(User player, User waiter, Hero hero, Actions actions){

        if(player.getUseCost()<2){
            System.out.println("영웅능력을 사용하기 위해서는 2코스트가 필요합니다.");
            return;
        }
        switch (hero.className){
            case "마법사" : break;
            case "사냥꾼" :
                waiter.setHp(waiter.getHp()-2);
                player.useCost(player,2);
                System.out.println("화살 쏘기");
                break;
            case "전사" : break;
            case "사제" : break;
            case "드루이드" : break;
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
    }
}
