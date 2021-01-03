package sample.model;

public class Herb extends GameObject{

    public Herb(int id, String name, String rarity, String rank){
        super(id, name, rarity, rank);
    }
    @Override
    public String getRank(){
        return "a";
    }
}
