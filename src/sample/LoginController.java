package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.model.User;

public class LoginController  {
    @FXML private Button exitButton;
    @FXML protected TextField unameField;
    @FXML private PasswordField passwordField;
    @FXML private Label loginMessage;
    MainController mainController;

    public void exitButtonAction(){
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }

    public void resetButtonAction(){
        unameField.setText("");
        passwordField.setText("");
    }

    public void loginButtonAction(){
        if (!unameField.getText().isBlank() && !passwordField.getText().isBlank()) {
            validateLogin();
        }else {
            loginMessage.setText("Please enter username and password");
        }
    }

    public void validateLogin(){
                if (User.getLogin(unameField.getText(),passwordField.getText())){
                    try {
                        Stage stage = (Stage) exitButton.getScene().getWindow();
                        stage.close();
                        mainController = new MainController();
                        mainController.start(unameField.getText());
                    } catch(Exception e) {
                        e.printStackTrace();
                    }
                }else {
                    loginMessage.setText("Wrong username or password");
                }
            }
}
