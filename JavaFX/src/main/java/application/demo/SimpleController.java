package application.demo;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;

public class SimpleController implements Initializable {
    @FXML // fx:id="button1"
    private Button button1; // Value injected by FXMLLoader

    @FXML // fx:id="button2"
    private Button button2; // Value injected by FXMLLoader

    @Override // This method is called by the FXMLLoader when initialization is complete
    public void initialize(URL location, ResourceBundle resources) {
        assert button1 != null : "fx:id=\"button1\" was not injected: check your FXML file 'MainGUI.fxml'.";
        assert button2 != null : "fx:id=\"button2\" was not injected: check your FXML file 'MainGUI.fxml'.";

        // Event for button1 assigned via code - better, because Controller and View are separated
        button1.setOnAction(this::handleButtonClicked);

        // Event for button2 assigned via FXML
    }

    @FXML
    private void handleButtonClicked(ActionEvent event) {
        System.out.println("Handling Button clicked" + event.getSource().toString());
        String text = ((Button) event.getSource()).getId();
        new Alert(AlertType.INFORMATION, text + " clicked").showAndWait();
    }

}
