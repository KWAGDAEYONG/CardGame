package contents;

import model.Hero;

import java.util.ArrayList;
import java.util.List;


public class Heros {
    private List<Hero> heroList;
    public void setHeroList(){
        heroList = new ArrayList<Hero>();
        heroList.add(new Hero("마법사"));
        heroList.add(new Hero("사냥꾼"));
        heroList.add(new Hero("전사"));
        heroList.add(new Hero("사제"));
        heroList.add(new Hero("드루이드"));
        heroList.add(new Hero("도적"));
        heroList.add(new Hero("흑마법사"));
        heroList.add(new Hero("주술사"));
        heroList.add(new Hero("성기사"));
    }

    public List<Hero> getHeroList() {
        return heroList;
    }
}
