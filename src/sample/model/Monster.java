package sample.model;

public class Monster extends GameObject{
    //aku nambahin power, setter,getter price, body dr override, sama kaya bpknya
    private int power;

    public Monster(){}
    public Monster(int id, String name, String rarity, String rank) {
        super(id, name, rarity, rank);
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getPower() {
        return power;
    }

    @Override
    public String getRank() {
        String rank = "C";
        if (getPower() > 300) rank = "S";
        else if (getPower() > 200) rank = "A";
        else  if (getPower() > 80) rank = "B";
        else if (getPower() > 30) rank = "C";
        setRank(rank);
        return rank;
    }
}
