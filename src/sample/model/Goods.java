package sample.model;

public class Goods extends GameObject{
    //aku nambahin price, setter,getter price, body dr override, sama kaya bpknya
    private int price;

    public Goods(){}

    public Goods(int id, String name, String rarity, String rank) {
        super(id, name, rarity, rank);
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String getRank(){
        String rank = "C";
        if (getPrice() > 1000000) rank = "S";
        else if (getPrice() > 500000) rank = "A";
        else if (getPrice() > 100000) rank = "B";
        else if (getPrice() > 10000) rank = "C";
        setRank(rank);
        return rank;
    }
}
