package Controller;

import Model.Planning;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import Model.Login;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class HubController implements Initializable {

    private final Login login = Login.getInstance();

    @FXML
    private Label eindTijd;

    @FXML
    private AnchorPane rootPane;

    @FXML
    private TextField colliesField;

    @FXML
    private TextField medewerkersField;

    @FXML
    void bereken() throws IOException {
        Planning planning = new Planning();
        planning.setCollies(Integer.parseInt(colliesField.getText()));
        planning.setMedewerkers(Integer.parseInt(medewerkersField.getText()));
        planning.berekenEindTijd(Integer.parseInt(colliesField.getText()), Integer.parseInt(medewerkersField.getText()));
        eindTijd.setText(Double.toString(planning.getEindtijd()));
    }

    public HubController() throws FileNotFoundException {
    }

    public void logout() throws IOException {
        login.getInstance().logout();
        AnchorPane pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/HomeScreen.fxml")));
        rootPane.getChildren().setAll(pane);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


}