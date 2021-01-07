package sample.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Quest {
    private String title;
    private String rank;
    private String type;
    private int maxHunter;
    private int minPower;
    private int reward;
    private String status;
    public Quest(String title, String rank, String type){
        this.title = title;
        this.rank = rank;
        this.type = type;
        this.status = "Available";
        setData();
    }
    private void setData(){
        if (rank=="S"){
            this.minPower=300;
            this.maxHunter=5;
            this.reward=1000;
        }
    }
    public String getStatus(){
        String data = title + "\t\t\t" + rank + "\t\t" + type + "\t\t\t" +
                maxHunter +"\t\t\t" + minPower + "\t\t\t\t" + reward + "\t\t\t" + status;
        return  data;
    }
}
