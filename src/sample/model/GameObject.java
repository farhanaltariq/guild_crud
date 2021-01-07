package sample.model;

public abstract class GameObject {
    private String name;
    private String rank;
    private int id;
    private String rarity;

    //biar bisa kebaca di monster
    public GameObject(){}

    public GameObject(int id, String name, String rarity, String rank) {
        this.name = name;
        this.id = id;
        this.rarity = rarity;
        this.rank = rank;
    }

    //biar bisa set rank di monster
    public void setRank(String rank) {
        this.rank = rank;
    }

    public abstract String getRank();
}
