package Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import Model.Manager;
import Model.Login;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.ResourceBundle;

public class RegisterManagerController implements Initializable {

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
    private TextField afdelingField;

    @FXML
    private DatePicker myBirthDate;

    @FXML
    private Label ErrorField;

    public RegisterManagerController() throws FileNotFoundException {
    }

    @FXML
    void backToHome() throws IOException {
        AnchorPane pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/HomeScreen.fxml")));
        rootPane.getChildren().setAll(pane);
    }

    @FXML
    void registerManager() throws IOException {
        Manager manager = new Manager(naamField.getText());
        manager.setAfdeling(afdelingField.getText());
        manager.setGebruikersnaam(gebruikersnaamField.getText());
        manager.setWachtwoord(wachtwoordField.getText());
        manager.setGeboortedatum(myBirthDate.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        manager.setFiliaal("1530D");
        Login.getInstance().getDbs().managerFileWriter(manager);
        login.getDbs().addManagerToList(manager);
        backToHome();
    }

    public void register() throws IOException{
        if (gebruikersnaamField.getText() != null && wachtwoordField.getText() != null && naamField.getText() != null ) {

            if (!login.registerCheck(gebruikersnaamField.getText())) {
                registerManager();
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