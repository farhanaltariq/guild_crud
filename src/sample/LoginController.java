package sample;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import sample.utils.DBConnector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginController  {
    @FXML private Button loginButton;
    @FXML private Button exitButton;
    @FXML private ImageView imgView;
    @FXML private TextField unameField;
    @FXML private PasswordField passwordField;
    @FXML private Label loginMessage;
    @FXML private Button resetButton;


    public void exitButtonAction(ActionEvent event){
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }

    public void resetButtonAction(ActionEvent event){
        unameField.setText("");
        passwordField.setText("");
    }

    public void loginButtonAction(ActionEvent event){
        if (!unameField.getText().isBlank() && !passwordField.getText().isBlank()) {
            validateLogin();
        }else {
            loginMessage.setText("Please enter username and password");
        }
    }

    public void validateLogin(){
        DBConnector connectNow = new DBConnector();
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
