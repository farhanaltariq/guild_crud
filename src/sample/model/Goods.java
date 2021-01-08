package sample.model;

import sample.utils.DBConnector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
    public static String getData(){
        String temp= "";
        DBConnector db = new DBConnector();
        Connection con  = db.getConnection();
        try {
            Statement st = con.createStatement();
            String sql = ("SELECT * FROM goods ORDER BY id;");
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                temp+="\nID\t\t: "+rs.getInt("id")+"\n";
                temp+="Name\t: "+rs.getString("name")+"\n";
                temp+="Rank\t\t: "+rs.getString("rank")+"\n";
                temp+="Value\t: "+rs.getDouble("value")+"\n";
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return temp;
    }
}
