package sample.model;

public abstract class GameObject {
    private String name;
    private String rank;
    private int id;
    private String rarity;
    public GameObject(int id, String name, String rarity, String rank) {
        this.name = name;
        this.id = id;
        this.rarity = rarity;
        this.rank = rank;
    }

    public abstract String getRank();
}
