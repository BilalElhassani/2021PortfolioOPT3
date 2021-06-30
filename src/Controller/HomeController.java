package Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;
import java.util.Objects;

public class HomeController {

    @FXML
    private AnchorPane rootPane;

    @FXML
    void registerWerkgeverButton() throws IOException {
        AnchorPane pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/RegisterWerkgeverScreen.fxml")));
        rootPane.getChildren().setAll(pane);
    }

    @FXML
    void registerWerknemerButton() throws IOException {
        AnchorPane pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/RegisterWerknemerScreen.fxml")));
        rootPane.getChildren().setAll(pane);
    }

    public void werkgeverLogin() throws IOException {
        AnchorPane pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/WerkgeverLoginScreen.fxml")));
        rootPane.getChildren().setAll(pane);
    }

    public void werknemerLogin() throws IOException {
        AnchorPane pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/WerknemerLoginScreen.fxml")));
        rootPane.getChildren().setAll(pane);
    }
}