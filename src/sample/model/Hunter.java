package sample.model;

import sample.utils.DBConnector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Hunter {
    private String rank;
    private int power;
    private int money;
    private ArrayList<Quest> quests;
    private String party;

    public void readQuest(){

    }
    public void takeQuest(){

    }
    public void submitQuest(){

    }
    public String getRank(){
        if (power<100)
            if (power>80)
                rank = "S";
            if (power>60)
                rank = "A";
            if (power>40)
                rank = "B";
            if (power>20)
                rank = "C";

        return rank;
    }
    public static String getData(){
        String memberData = "";
        DBConnector db = new DBConnector();
        Connection con  = db.getConnection();
        try {
            Statement st = con.createStatement();
            String sql = ("SELECT * FROM hunter ORDER BY id;");
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                memberData+="\nID\t\t: "+rs.getInt("id")+"\n";
                memberData+="Name\t: "+rs.getString("name")+"\n";
                memberData+="Rank\t\t: "+rs.getString("rank")+"\n";
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return memberData;
    }
    public static String getInfo(String username){
        String info = "";
        DBConnector db = new DBConnector();
        Connection con  = db.getConnection();
        try {
            ResultSet rs;
            Statement st = con.createStatement();
            String sql =
                    "SELECT * FROM hunter WHERE hunter.id " +
                            "LIKE (SELECT id FROM users WHERE " +
                            "users.username='"+username+"')";
            rs = st.executeQuery(sql);
            while (rs.next()) {
                info+="\nName\t: "+rs.getString("name")+"\n";
                info+="Rank\t\t: "+rs.getString("rank")+"\n";
                System.out.println("GET DATA SUCCESS");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println(username);
        System.out.println("You Here");
        return info;
    }
}
