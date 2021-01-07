package sample.model;

public class Herb extends GameObject{
    private int id;
    private String name;
    private String rank;
    private String rarity;
    public Herb(int id, String name, String rarity){

    }
    @Override
    public String getRank(){
        if (rarity=="Mythical")
            rank = "s";
        else if (rarity=="Legendary")
            rank = "A";
        else if (rarity=="Epic")
            rank = "B";
        else if(rarity=="Rare")
            rank = "C";
        return rank;
    }
}
