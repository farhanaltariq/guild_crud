package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sample.model.Quest;

import java.io.IOException;
import java.util.ArrayList;

public class MainController  {
    @FXML    private Button logoutButton;
    @FXML    private Button memberButton;
    @FXML    private Button questsButton;
    @FXML    private Button herbsButton;
    @FXML    private Button goodsButton;
    @FXML    private Button monstersButton;
    @FXML    private AnchorPane table;
    private ArrayList<Quest> quests = new ArrayList<Quest>();
    @FXML    private TextArea data;


    public void logoutButtonAction(ActionEvent event){
        try{
            Stage stage = (Stage) logoutButton.getScene().getWindow();
            stage.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("layout/Login.fxml"));
            Parent root1 = null;
            root1 = (Parent) fxmlLoader.load();
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
        Parent root = FXMLLoader.load(MainController.class.getResource("layout/main.fxml"));
        primaryStage.setTitle("Guild");
        primaryStage.setScene(new Scene(root, 850, 550));
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.show();
        if (!username.equals("admin"))
            System.out.println("im user");
        else
            System.out.println("im admin");
    }
    public void userView(){
        memberButton.setVisible(false);
        questsButton.setVisible(true);
        herbsButton.setVisible(false);
        goodsButton.setVisible(false);
        monstersButton.setVisible(false);
    }
    public void questsButtonOnAction(ActionEvent event){
        quests.add(new Quest("Hunt Kraken","S","Hunting"));
        data.setText("Title\t\t\t\tRank\t\t\tType\t\t\tMax. Hunter \t\tMin. Power\t\tReward\t\tStatus\n\n");
        data.appendText(quests.get(0).getStatus());
    }


}
