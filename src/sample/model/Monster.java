package sample.model;

public class Monster extends GameObject{
    private int id;
    private String name;
    private String rank;
    private int power;
    public Monster(int id, String name, int power) {
        this.id = id;
        this.name = name;
        this.power = power;
    }

    @Override
    public String getRank() {
        if (power>300)
            rank = "S";
        else if (power>200)
            rank = "A";
        else if (power>80)
            rank = "B";
        else if (power>30)
            rank = "C";
        return rank;
    }
}
