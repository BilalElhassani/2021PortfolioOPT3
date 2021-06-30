package Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import Model.Werkgever;
import Model.Database;
import Model.Login;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.ResourceBundle;

public class RegisterWerkgeverController implements Initializable {

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
    private TextField werkgeverCodeField;

    @FXML
    private DatePicker myBirthDate;

    @FXML
    private Label ErrorField;

    public RegisterWerkgeverController() throws FileNotFoundException {
    }

    @FXML
    void backToHome() throws IOException {
        AnchorPane pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/HomeScreen.fxml")));
        rootPane.getChildren().setAll(pane);
    }

    @FXML
    void registerWerkgever() throws IOException {
        Werkgever werkgever = new Werkgever(naamField.getText());
        werkgever.setWerkgeverCode(werkgeverCodeField.getText());
        werkgever.setGebruikersnaam(gebruikersnaamField.getText());
        werkgever.setWachtwoord(wachtwoordField.getText());
        werkgever.setGeboortedatum(myBirthDate.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        werkgever.setContract("werkgeverscontract");
        werkgever.setFunctionaliteit("werkgever");
        werkgever.setFiliaal("1530D");
        Login.getInstance().getDbs().werkgeverFileWriter(werkgever);
        login.getDbs().addWerkgeverToList(werkgever);
        backToHome();
    }

    public void register() throws IOException{
        if (gebruikersnaamField.getText() != null && wachtwoordField.getText() != null && naamField.getText() != null ) {

            if (!login.registerCheck(gebruikersnaamField.getText())) {
                registerWerkgever();
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