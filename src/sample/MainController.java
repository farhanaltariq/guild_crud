package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sample.model.Quest;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController  {
    @FXML private Button logoutButton;

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
}
