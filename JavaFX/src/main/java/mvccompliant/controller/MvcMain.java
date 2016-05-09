package mvccompliant.controller;

import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MvcMain extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            final URL fxmlUrl = getClass().getResource("../view/MainView.fxml");
            final FXMLLoader fxmlLooader = new FXMLLoader(fxmlUrl);
            fxmlLooader.setController(new MvcController());
            final Parent root = fxmlLooader.load();

            Scene scene = new Scene(root);
            // scene.getStylesheets().add(this.getClass().getResource("application.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.setTitle("MVC Example");
            primaryStage.show();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
