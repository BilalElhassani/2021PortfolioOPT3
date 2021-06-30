package Controller;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import Model.Login;

import java.io.IOException;
import java.text.ParseException;
import java.util.Objects;


public class WerknemerLoginController {

    @FXML
    private AnchorPane rootPane;

    @FXML
    private TextField gebruikersnaamField;

    @FXML
    private PasswordField wachtwoordField;

    @FXML
    private Label ErrorField;

    public void backToHome() throws IOException {
        AnchorPane pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/HomeScreen.fxml")));
        rootPane.getChildren().setAll(pane);
    }

    @FXML
    void loginButtonPressed() throws IOException{

        if(Login.getInstance().loginCheck(gebruikersnaamField.getText(), wachtwoordField.getText())) {
            AnchorPane pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/HubScreen.fxml")));
            rootPane.getChildren().setAll(pane);
        } else{
            ErrorField.setTextFill(Color.FIREBRICK);
            ErrorField.setText("Wrong password or username...");
        }
    }
}