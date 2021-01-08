package sample.model;

import sample.utils.DBConnector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Herb extends GameObject{
    private int id;
    private String name;
    private String rank;
    public Herb(int id, String name, String rank){
        this.id = id;
        this.name = name;
        this.rank = rank;
    }
    @Override
    public String getRank(){
        return rank;
    }
    public static String getData(){
        String temp = "";
        DBConnector db = new DBConnector();
        Connection con  = db.getConnection();
        try {
            Statement st = con.createStatement();
            String sql = ("SELECT * FROM herbs ORDER BY id;");
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
