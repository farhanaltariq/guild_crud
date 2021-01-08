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
import sample.utils.DBConnector;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MainController  {
    @FXML    private Button logoutButton;
    @FXML    private Button memberButton;
    @FXML    private Button questsButton;
    @FXML    private Button herbsButton;
    @FXML    private Button goodsButton;
    @FXML    private Button monstersButton;
    @FXML    private AnchorPane table;
    private final Quest quest = new Quest();
    @FXML    private TextArea data;


    public void logoutButtonAction(){
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
        String info = quest.getStatus().toString().replace("[","\n").replace("]","\n");
        data.clear();
        data.setText("ID\tTitle\t\t\t\tRank\t\t\tType\t\t\tMax. Hunter \t\tMin. Power\t\tReward\t\tStatus\n");
        data.appendText(info);
    }
    public void memberButtonOnAction(){
        String memberData = null;
        DBConnector db = new DBConnector();
        Connection con  = db.getConnection();
        data.clear();
        try {
            Statement st = con.createStatement();
            String sql = ("SELECT * FROM hunter ORDER BY id;");
            ResultSet rs = st.executeQuery(sql);
            int x = 0;
            while (rs.next()) {
                memberData = "\n";
                memberData+="ID\t\t: "+rs.getInt("id")+"\n";
                memberData+="Name\t: "+rs.getString("name")+"\n";
                memberData+="Rank\t\t: "+rs.getString("rank");
                data.appendText("\n"+memberData);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void herbsButtonOnAction(){
        data.clear();
    }
    public void goodsButtonOnAction(){
        data.clear();
    }
    public void monstersButtonOnAction(){
        data.clear();
    }
    public void clearButtonOnAction(){
        data.clear();
    }
}
