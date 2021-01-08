package sample.model;

import sample.utils.DBConnector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Monster extends GameObject{
    //aku nambahin power, setter,getter price, body dr override, sama kaya bpknya
    private int power;

    public Monster(){}
    public Monster(int id, String name, String rarity, String rank) {
        super(id, name, rarity, rank);
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
    public static String getData(){
        String temp = "";
        DBConnector db = new DBConnector();
        Connection con  = db.getConnection();
        try {
            Statement st = con.createStatement();
            String sql = ("SELECT * FROM monster ORDER BY id;");
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                temp+="\nID\t\t: "+rs.getInt("id")+"\n";
                temp+="Name\t: "+rs.getString("name")+"\n";
                temp+="Rank\t\t: "+rs.getString("rank")+"\n";
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return temp;
    }
}
