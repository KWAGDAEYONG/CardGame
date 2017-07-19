package user;

import card.Card;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 2017-07-18.
 */
public class Field {
    List<Card> fieldCard = new ArrayList<Card>();

    public void setFieldCard(List<Card> fieldCard) {
        this.fieldCard = fieldCard;
    }

    public List<Card> getFieldCard() {
        return fieldCard;
    }
}
