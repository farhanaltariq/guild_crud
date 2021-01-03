package sample.model;

public class Quest {
    private String title;
    private String rank;
    private String type;
    private int maxHunter;
    private  int minPower;
    private int reward;
    private String status;
    public Quest(String title, String rank, String type, int maxHunter, int minPower, int reward){
        this.title = title;
        this.rank = rank;
        this.type = type;
        this.maxHunter = maxHunter;
        this.minPower = minPower;
        this.reward = reward;
        this.status = "Not Taken";
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getMaxHunter() {
        return maxHunter;
    }

    public void setMaxHunter(int maxHunter) {
        this.maxHunter = maxHunter;
    }

    public int getMinPower() {
        return minPower;
    }

    public void setMinPower(int minPower) {
        this.minPower = minPower;
    }

    public int getReward() {
        return reward;
    }

    public void setReward(int reward) {
        this.reward = reward;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus(){
        return status;
    }
}
