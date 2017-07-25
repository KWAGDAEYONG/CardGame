package model;

public class Weapon {
    private String name;
    private int count;
    private int ap;

    public Weapon(String name, int count, int ap){
        this.name = name;
        this.count = count;
        this.ap = ap;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setAp(int ap) {
        this.ap = ap;
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    public int getAp() {
        return ap;
    }
}
