package contents;

import model.Weapon;

import java.util.HashMap;
import java.util.Map;

public class Weapons {
    private Map<String, Weapon> weaponList;

    public void setWeaponList(){
        weaponList = new HashMap<String, Weapon>();
        weaponList.put("도적영능", new Weapon("도적기본칼",2,1));
        weaponList.put("드루영능", new Weapon("드루발톱",1,1));
    }

    public Map<String, Weapon> getWeaponList() {
        return weaponList;
    }
}
