package Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import Model.Werknemer;
import Model.Database;
import Model.Login;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.ResourceBundle;

public class RegisterWerknemerController implements Initializable {

    Login login = Login.getInstance();

    @FXML
    private AnchorPane rootPane;

    @FXML
    private TextField gebruikersnaamField;

    @FXML
    private PasswordField wachtwoordField;

    @FXML
    private TextField naamField;

    @FXML
    private DatePicker myBirthDate;

    @FXML
    private Label ErrorField;

    public RegisterWerknemerController() throws FileNotFoundException {
    }

    @FXML
    void backToHome() throws IOException {
        AnchorPane pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/HomeScreen.fxml")));
        rootPane.getChildren().setAll(pane);
    }

    @FXML
    void registerWerknemer() throws IOException {
        Werknemer werknemer = new Werknemer(naamField.getText());
        werknemer.setGebruikersnaam(gebruikersnaamField.getText());
        werknemer.setWachtwoord(wachtwoordField.getText());
        werknemer.setGeboortedatum(myBirthDate.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        werknemer.setContract("werknemerscontract");
        werknemer.setFunctionaliteit("werknemer");
        werknemer.setFiliaal("1530D");
        Login.getInstance().getDbs().werknemerFileWriter(werknemer);
        login.getDbs().addWerknemerToList(werknemer);
        backToHome();
    }

    public void register() throws IOException{
        if (gebruikersnaamField.getText() != null && wachtwoordField.getText() != null && naamField.getText() != null ) {

            if (!login.registerCheck(gebruikersnaamField.getText())) {
                registerWerknemer();
                backToHome();
            } else {
                ErrorField.setText("Gebruikersnaam bestaat al.");
            }
        }
        else {
            ErrorField.setText("Niet alles is ingevuld.");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
