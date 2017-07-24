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

        if(player.getUseCost()<2){
            System.out.println("영웅능력을 사용하기 위해서는 2코스트가 필요합니다.");
            return;
        }
        if(player.isUseHeroAbility()){
            System.out.println("이미 영웅능력을 사용하셨습니다.");
            return;
        }
        switch (hero.className){
            case "마법사" :
                magicianAbility(waiter,scanner);
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
                priestAbility(player,waiter,scanner);
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

    public void magicianAbility(User waiter, Scanner scanner){
        System.out.println("대상을 선택하세요");
        int i;
        for(i = 0; i<waiter.getField().size(); i++){
            System.out.println(i+". "+waiter.getField().get(i).getName());
        }
        System.out.println(i+". 명치");

        int sc = scanner.nextInt();

        if(sc==waiter.getField().size()){
            //명치공격
            waiter.bodyAttack(waiter, 1);
        }else{
            //필드공격
            waiter.getField().get(sc).setHp(waiter.getField().get(sc).getHp()-1);
            if(waiter.getField().get(sc).getHp()<=0){
                waiter.getField().remove(sc);
            }
        }
    }

    public void priestAbility(User player, User waiter, Scanner scanner){
        System.out.println("대상을 선택하세요");
        int i=0;
        if(player.getField().isEmpty()){
            //내 필드가 비어있는 경우
            System.out.println(i+". 자신 본체");
            if(waiter.getField().isEmpty()){
                //상대 필드가 비어있는 경우
                i++;
                System.out.println(i+". 상대 본체");
            }else{
                //아닌 경우
                i++;
                for(int j=0; j<waiter.getField().size(); j++){
                    System.out.println(i+". "+waiter.getField().get(j).getName());
                    i++;
                }
                System.out.println(i+". 상대 본체");
            }
        }else{
            //내 필드가 차있는 경우
            for(i=0; i<player.getField().size(); i++){
                System.out.println(i+". "+player.getField().get(i).getName());
            }
            System.out.println(i+". 자신 본체");
            if(waiter.getField().isEmpty()){
                //상대 필드가 비어있는 경우
                i++;
                System.out.println(i+". 상대 본체");

            }else{
                //아닌 경우
                i++;
                for(int j = 0; j<waiter.getField().size(); j++){
                    System.out.println(i+". "+waiter.getField().get(j).getName());
                    i++;
                }
                System.out.println(i+". 상대 본체");
            }
        }

        int sc = scanner.nextInt();

        if(sc<=player.getField().size()){
            //내거에 힐
            if(sc==player.getField().size()){
                //본체 힐
                player.setHp(player.getHp()+2);
            }else{
                //하수인 힐
                player.getField().get(sc).setHp(player.getField().get(sc).getHp()+2);
            }
        }else{
            //상대거에 힐
            if(sc==i){
                //본체힐
                waiter.setHp(waiter.getHp()+2);
            }else{
                //하수인 힐
                waiter.getField().get(sc-(player.getField().size()+1)).setHp(waiter.getField().get(sc-(player.getField().size()+1)).getHp()+2);
            }
        }
    }
}
