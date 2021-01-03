package sample.model;

public class Monster extends GameObject{
    public Monster(int id, String name, String rarity, String rank) {
        super(id, name, rarity, rank);
    }

    @Override
    public String getRank() {
        return null;
    }
}
