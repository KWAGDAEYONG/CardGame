package Action;

import card.Card;
import user.User;

import java.util.List;
import java.util.Scanner;

/**
 * Created by user on 2017-07-18.
 */
public class ActionImpl implements Actions {

    @Override
    public void useHand(User user){
        List<Card> hand = user.getHand();
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
        int cardNum = scanner.nextInt();
        Card target = hand.get(cardNum);

        if(target.getCost()>user.getUseCost()){
           System.out.println("사용할 수 있는 코스트가 모자랍니다.");
           return;
       }
       if(user.getField().getFieldCard().size()>=7){
           System.out.println("더이상 필드에 하수인을 소환할 수 없습니다");
           return;
       }

       List<Card> field = user.getField().getFieldCard();
        field.add(target);
        user.setUseCost(user.getUseCost()-target.getCost());
        System.out.println("필드에 " + target.getName() + "을(를) 소환합니다.");
        hand.remove(cardNum);

    }
    @Override
    public void next(User player1, User player2){
        if(player1.isTurn()){
            player1.setTurn(false);
            player2.setTurn(true);
        }else{
            player1.setTurn(true);
            player2.setTurn(false);
        }
    }

    @Override
    public void draw(User user){
        Card drawed = user.getUseDeck().pop();
        if(user.getHand().size()>9){
            System.out.println("더 이상 카드를 가질 수 없습니다. 카드가 타버립니다.");
            return;
        }
        user.getHand().add(drawed);
    }

    @Override
    public void useField(User player1, User player2){
        Scanner scanner = new Scanner(System.in);
        if(player1.getField().getFieldCard().isEmpty()){
            System.out.println("필드에 하수인이 없습니다");
            return;
        }
        System.out.println("어떤 카드를 사용하시겠습니까?");
        for(int i = 0; i<player1.getField().getFieldCard().size(); i++) {
            System.out.println(i+". "+player1.getField().getFieldCard().get(i).getName()+"(hp:"+player1.getField().getFieldCard().get(i).getHp()+"/ap:"+player1.getField().getFieldCard().get(i).getAp()+")");
        }

        int cardNum = scanner.nextInt();
        Card attacker = player1.getField().getFieldCard().get(cardNum);
        if(attacker.isFirstTurn()){
            System.out.println("소환 후 다음 턴 부터 공격할 수 있습니다");
            return;
        }
        if(attacker.isAlreadyAttack()){
            System.out.println("이미 공격한 하수인입니다");
            return;
        }
        System.out.println("어디를 공격하시겠습니까?");

        int k;
        for(k = 0; k<player2.getField().getFieldCard().size(); k++) {
            System.out.println(k+". "+player2.getField().getFieldCard().get(k).getName()+"(hp:"+player2.getField().getFieldCard().get(k).getHp()+"/ap:"+player2.getField().getFieldCard().get(k).getAp()+")");
        }
        System.out.println(k+". 명치");
        scanner.nextLine();
        int targetNum = scanner.nextInt();

        if(player2.getField().getFieldCard().size()==targetNum){
            //명치 공격
            player2.setHp(player2.getHp()-attacker.getAp());
            attacker.setAlreadyAttack(true);
        }else{
            //필드 공격
            attackField(attacker,player2.getField().getFieldCard().get(targetNum));
            attacker.setAlreadyAttack(true);
            if(attacker.getHp()<=0){
                player1.getField().getFieldCard().remove(cardNum);
            }
            if(player2.getField().getFieldCard().get(targetNum).getHp()<=0){
                player2.getField().getFieldCard().remove(targetNum);
            }
        }
    }

    public void attackField(Card attacker, Card target){
        int attackerHp = attacker.getHp();
        int attackerAp = attacker.getAp();

        int targetHp = target.getHp();
        int targetAp = target.getAp();

        attackerHp = attackerHp-targetAp;
        targetHp = targetHp-attackerAp;

        attacker.setHp(attackerHp);
        target.setHp(targetHp);
    }
}
