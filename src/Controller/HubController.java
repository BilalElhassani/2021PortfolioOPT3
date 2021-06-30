package Controller;

import Model.Werkgever;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
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
    private Label userProfile;

    @FXML
    private AnchorPane rootPane;

    @FXML
    private Label BadgeLabel;

    public HubController() throws FileNotFoundException {
    }

    public void logout() throws IOException {
        Login.getInstance().logout();
        AnchorPane pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/HomeScreen.fxml")));
        rootPane.getChildren().setAll(pane);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    //hier komt agenda
}