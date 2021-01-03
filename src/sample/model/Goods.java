package sample.model;

public class Goods extends GameObject{
    public Goods(int id, String name, String rarity, String rank) {
        super(id, name, rarity, rank);
    }

    @Override
    public String getRank(){
        return "a";
    }
}
