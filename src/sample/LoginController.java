package sample;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import sample.utils.DBConnector;
import sample.utils.DatabaseConnection;

import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import java.net.URL;

public class LoginController implements Initializable {
    @FXML private Button loginButton;
    @FXML private Button exitButton;
    @FXML private ImageView imgView;
    @FXML private TextField unameField;
    @FXML private PasswordField passwordField;
    @FXML private Label loginMessage;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        File file = new File("sample/img/7.jpg");
        Image img = new Image(file.toURI().toString());
        imgView.setImage(img);
    }

    public void exitButtonAction(ActionEvent event){
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }

    public void loginButtonAction(ActionEvent event){
        if (!unameField.getText().isBlank() && !passwordField.getText().isBlank()) {
            validateLogin();
        }else {
            loginMessage.setText("Please enter username and password");
        }
    }

    public void validateLogin(){
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String verifyLogin = "SELECT count(1) FROM useraccount WHERE username = '"+unameField.getText()+"' AND password = md5('"+passwordField.getText()+"');";
        try {
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);
            while (queryResult.next()){
                if (queryResult.getInt(1)==1){
                    loginMessage.setText("Login Successful");
                }else {
                    loginMessage.setText("Wrong username or password");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }
}
