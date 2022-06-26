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
    void registerManagerButton() throws IOException {
        AnchorPane pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/RegisterManagerScreen.fxml")));
        rootPane.getChildren().setAll(pane);
    }

    @FXML
    void registerShiftleaderButton() throws IOException {
        AnchorPane pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/RegisterShiftleaderScreen.fxml")));
        rootPane.getChildren().setAll(pane);
    }

    public void managerLogin() throws IOException {
        AnchorPane pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/ManagerLoginScreen.fxml")));
        rootPane.getChildren().setAll(pane);
    }

    public void shiftleaderLogin() throws IOException {
        AnchorPane pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/ShiftleaderLoginScreen.fxml")));
        rootPane.getChildren().setAll(pane);
    }
}