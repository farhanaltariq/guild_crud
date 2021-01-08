package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sample.model.*;
import sample.utils.DBConnector;

import java.io.IOException;

public class MainController  {
    @FXML    private Button logoutButton;
    @FXML    private TextArea data;
    @FXML    private TextField tableField;
    @FXML    private TextField titleField;
    @FXML    private TextField rankField;
    @FXML    private TextField typeField;
    @FXML    private TextField idField;
    @FXML    private TextField maxHunterField;
    @FXML    private TextField minPowerField;
    @FXML    private TextField rewardField;
    @FXML    private TextField availabilityField;
    DBConnector dbConnector = new DBConnector();
    public MainController() {
    }

    public void logoutButtonAction(){
        try{
            Stage stage = (Stage) logoutButton.getScene().getWindow();
            stage.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("layout/Login.fxml"));
            Parent root1;
            root1 = fxmlLoader.load();
            stage = new Stage();
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void start(String username) throws Exception{
        Stage primaryStage = new Stage();
        Parent root;
        if (username.equals("admin"))
            root = FXMLLoader.load(MainController.class.getResource("layout/Main.fxml"));
        else
            root = FXMLLoader.load(MainController.class.getResource("layout/MainUser.fxml"));
        primaryStage.setTitle("Guild");
        primaryStage.setScene(new Scene(root, 850, 550));
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.show();
    }
    public void questsButtonOnAction(){
        Quest quest = new Quest();
        String info = quest.getStatus().toString().replace("[","\n").replace("]","\n");
        data.setText("ID\tTitle\t\t\t\tRank\t\t\tType\t\t\tMax. Hunter \t\tMin. Power\t\tReward\t\tStatus\n");
        data.appendText(info);
    }
    public void memberButtonOnAction(){
        data.setText("REGISTERED HUNTER INFORMATION\n");
        data.appendText(Hunter.getData());
    }
    public void herbsButtonOnAction(){
        data.setText("HERBS DATA\n");
        data.appendText(Herb.getData());
    }
    public void goodsButtonOnAction(){
        data.setText("GOODS DATA\n");
        data.appendText(Goods.getData());
    }
    public void monstersButtonOnAction(){
        data.setText("MONSTERS\n");
        data.appendText(Monster.getData());
    }
    public void createButtonOnAction(){
        idField.setText("NULL");
        String command;
        try {
            command = "INSERT INTO "+tableField.getText()+" (id,title,rank,type,minPower,maxHunter,reward,availability) VALUES ("+
                    idField.getText()+",'"+titleField.getText()+"','"+rankField.getText()+"','"+typeField.getText()+"','"+
                    minPowerField.getText()+"','"+maxHunterField.getText()+"','"+rewardField.getText()+"','"+availabilityField.getText()+"');";
            dbConnector.insert(command);
        }catch (Exception e){
            try {
                System.out.println("OK");
            } catch (Exception ex){
                System.out.println("Failed Gan");
            }
        }
    }
    public void updateButtonOnAction(){

    }
    public void deleteButtonOnAction(){

    }
}
