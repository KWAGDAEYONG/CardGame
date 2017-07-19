package card;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by user on 2017-07-18.
 */
public class Cards {
    public Map<String, Card> cardList;
    public void setCardList(){
        cardList = new HashMap<String, Card>();
        cardList.put("병아리",new Card("병아리",2,1,2));
        cardList.put("지렁이",new Card("지렁이",3,1,1));
        cardList.put("붕어",new Card("붕어",1,1,3));
        cardList.put("닭",new Card("닭",2,2,3));
        cardList.put("강아지",new Card("강아지",3,2,2));
        cardList.put("고양이",new Card("고양이",3,2,2));
        cardList.put("큰개",new Card("큰개",4,3,3));
        cardList.put("살쾡이",new Card("살쾡이",3,3,4));
        cardList.put("여우",new Card("여우",4,3,3));
        cardList.put("늑대",new Card("늑대",4,4,5));
        cardList.put("타조",new Card("타조",5,4,4));
        cardList.put("사냥개",new Card("사냥개",4,4,5));
        cardList.put("곰",new Card("곰",6,5,5));
        cardList.put("하마",new Card("하마",6,5,5));
        cardList.put("상어",new Card("상어",5,5,6));
        cardList.put("호랑이",new Card("호랑이",7,6,6));
        cardList.put("사자",new Card("사자",6,6,7));
        cardList.put("치타",new Card("치타",6,6,7));
        cardList.put("코끼리",new Card("코끼리",7,7,8));
        cardList.put("코뿔소",new Card("코뿔소",8,7,7));
        cardList.put("독수리",new Card("독수리",7,7,8));
        cardList.put("총잡이",new Card("총잡이",9,8,9));
        cardList.put("헌터",new Card("헌터",9,8,9));
        cardList.put("사육사",new Card("사육사",9,8,9));
        cardList.put("용",new Card("용",10,9,11));
        cardList.put("불사조",new Card("불사조",11,9,10));
        cardList.put("십장생",new Card("십장생",11,9,10));
        cardList.put("개발자",new Card("개발자",12,10,12));
        cardList.put("엔지니어",new Card("엔지니어",12,10,12));
        cardList.put("곽대용",new Card("곽대용",12,10,12));

    }

}
