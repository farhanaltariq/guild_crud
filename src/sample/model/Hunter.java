package sample.model;

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
}
