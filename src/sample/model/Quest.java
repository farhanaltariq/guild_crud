package sample.model;

import sample.utils.DBConnector;
import java.sql.*;
import java.util.ArrayList;

public class Quest {
    private String title;
    private String rank;
    private String type;
    private int maxHunter;
    private int minPower;
    private double reward;

    public Quest(String title, String rank, String type){
        this.title = title;
        this.rank = rank;
        this.type = type;
        switch (rank) {
            case "S" -> {
                this.maxHunter = 5;
                this.reward = 10;
            }
            case "A" -> {
                this.maxHunter = 3;
                this.reward = 2;
            }
            case "B" -> {
                this.maxHunter = 2;
                this.reward = 0.5;
            }
            case "C" -> {
                this.maxHunter = 1;
                this.reward = 0.05;
            }
        }
        setData();
    }
    public Quest(){

    }

    private void setData(){
        if (rank.equals("S")){
            this.minPower=300;
            this.maxHunter=5;
            this.reward=1000;
        }
    }
    private final ArrayList<String> status = new ArrayList<>();

    public ArrayList<String> getStatus(){
        DBConnector db = new DBConnector();
        Connection con  = db.getConnection();
        this.status.clear();
        try {
            Statement st = con.createStatement();
            String sql = ("SELECT * FROM quest ORDER BY id;");
            ResultSet rs = st.executeQuery(sql);
            int x = 0;
            while (rs.next()) {
                int id = rs.getInt("id");
                title = rs.getString("title");
                rank = rs.getString("rank");
                type = rs.getString("type");
                maxHunter = rs.getInt("maxhunter");
                minPower = rs.getInt("minpower");
                reward = rs.getDouble("reward");
                String availability = rs.getString("availability");
                String temp = "\n" + id + "\t" + title + "\t\t\t" + rank + "\t\t" + type + "\t\t\t" +
                        maxHunter + "\t\t\t" + minPower + "\t\t\t\t" + reward + "\t\t\t" + availability;
                this.status.add(x, temp);
                x++;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return this.status;
    }
}
