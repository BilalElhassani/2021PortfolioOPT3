package Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import Model.Shiftleader;
import Model.Login;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.ResourceBundle;

public class RegisterShiftleaderController implements Initializable {

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

    public RegisterShiftleaderController() throws FileNotFoundException {
    }

    @FXML
    void backToHome() throws IOException {
        AnchorPane pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/HomeScreen.fxml")));
        rootPane.getChildren().setAll(pane);
    }

    @FXML
    void registerShiftleader() throws IOException {
        Shiftleader shiftleader = new Shiftleader(naamField.getText());
        shiftleader.setGebruikersnaam(gebruikersnaamField.getText());
        shiftleader.setWachtwoord(wachtwoordField.getText());
        shiftleader.setGeboortedatum(myBirthDate.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        shiftleader.setFiliaal("1530D");
        Login.getInstance().getDbs().shiftleaderFileWriter(shiftleader);
        login.getDbs().addShiftleaderToList(shiftleader);
        backToHome();
    }

    public void register() throws IOException{
        if (gebruikersnaamField.getText() != null && wachtwoordField.getText() != null && naamField.getText() != null ) {

            if (!login.registerCheck(gebruikersnaamField.getText())) {
                registerShiftleader();
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
