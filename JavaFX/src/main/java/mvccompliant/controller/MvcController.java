package mvccompliant.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.AmbientLight;
import javafx.scene.Node;
import javafx.scene.PointLight;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Cylinder;

public class MvcController implements Initializable {
    private static final String SELECT_LIGHT1 = "selectLight1";
    private static final String SELECT_LIGHT2 = "selectLight2";
    @FXML
    private Button buttonLight1;
    @FXML
    private Button buttonLight2;
    @FXML
    private PointLight light1;
    @FXML
    private AmbientLight light2;
    @FXML
    private Cylinder cylinder;
    @FXML
    private Circle circleLight1;
    @FXML
    private Circle circleLight2;
    @FXML
    private Slider sliderX;
    @FXML
    private Slider sliderY;
    @FXML
    private Pane pane3D;
    @FXML
    private ToggleGroup sliderToggle;
    @FXML
    private RadioButton selectLight1;
    @FXML
    private RadioButton selectLight2;

    @Override // This method is called by the FXMLLoader when initialization is complete
    public void initialize(URL location, ResourceBundle resources) {
        assertNode(pane3D, "pane3D");
        assertNode(buttonLight1, "buttonLight1");
        assertNode(buttonLight2, "buttonLight2");
        assertNode(light1, "light1");
        assertNode(light2, "light2");
        assertNode(cylinder, "cylinder");
        assertNode(circleLight1, "circleLight1");
        assertNode(circleLight2, "circleLight2");
        assertNode(sliderX, "sliderX");
        assertNode(sliderY, "sliderY");
        assertNode(sliderToggle, "sliderToggle");
        assertNode(selectLight1, SELECT_LIGHT1);
        assertNode(selectLight2, SELECT_LIGHT2);

        buttonLight1.setOnAction(this::toggleLight1);
        buttonLight2.setOnAction(this::toggleLight2);
        sliderX.valueProperty().addListener(this::hScroll);
        sliderY.valueProperty().addListener(this::vScroll);
        sliderX.setMax(pane3D.getPrefWidth());
        sliderY.setMax(pane3D.getPrefHeight());
        selectLight1.setOnAction(this::light1Selected);
        selectLight2.setOnAction(this::light2Selected);
        // setSliderColors(getSliderToggle());
    }

    private void light1Selected(ActionEvent event) {
        sliderX.setValue(light1.getLayoutX());
        sliderY.setValue(invertValue(light1.getLayoutY()));
        setSliderColors(SliderToggle.LIGHT1);
    }

    private void light2Selected(ActionEvent event) {
        sliderX.setValue(light2.getLayoutX());
        sliderY.setValue(invertValue(light2.getLayoutY()));
        setSliderColors(SliderToggle.LIGHT2);
    }

    private void setSliderColors(SliderToggle selection) {
        Node thumbX = (Node) sliderX.getChildrenUnmodifiable().stream().filter(node -> node.getStyleClass().toString().equals("thumb"))
                .findFirst().get();
        Node thumbY = (Node) sliderY.getChildrenUnmodifiable().stream().filter(node -> node.getStyleClass().toString().equals("thumb"))
                .findFirst().get();
        String color;
        switch (selection) {
        case LIGHT1:
            color = getColor(circleLight1);
            break;
        case LIGHT2:
            color = getColor(circleLight2);
            break;
        default:
            color = "#ffffff";
        }
        thumbX.setStyle("-fx-background-color: " + color + ";");
        thumbY.setStyle("-fx-background-color: " + color + ";");
    }

    private String getColor(Circle circle) {
        Color c = (Color) circle.getFill();
        String hex = String.format("#%02X%02X%02X", (int) (c.getRed() * 255), (int) (c.getGreen() * 255), (int) (c.getBlue() * 255));
        return hex;
    }

    private void toggleLight1(ActionEvent event) {
        light1.setLightOn(!light1.isLightOn());
        circleLight1.setVisible(light1.isLightOn());
    }

    private void toggleLight2(ActionEvent event) {
        light2.setLightOn(!light2.isLightOn());
        circleLight2.setVisible(light2.isLightOn());
    }

    private void hScroll(ObservableValue<? extends Number> ov, Number oldValue, Number newValue) {
        if (getSliderToggle() == SliderToggle.LIGHT1) {
            light1.setLayoutX((Double) newValue);
            circleLight1.setLayoutX(light1.getLayoutX());
        } else if (getSliderToggle() == SliderToggle.LIGHT2) {
            light2.setLayoutX((Double) newValue);
            circleLight2.setLayoutX(light2.getLayoutX());
        }
    }

    private void vScroll(ObservableValue<? extends Number> ov, Number oldValue, Number newValue) {
        Double invertedValue = invertValue((Double) newValue);
        if (getSliderToggle() == SliderToggle.LIGHT1) {
            light1.setLayoutY(invertedValue);
            circleLight1.setLayoutY(light1.getLayoutY());
        } else if (getSliderToggle() == SliderToggle.LIGHT2) {
            light2.setLayoutY(invertedValue);
            circleLight2.setLayoutY(light2.getLayoutY());
        }
    }

    private double invertValue(Double value) {
        return pane3D.getPrefHeight() - value;
    }

    private void assertNode(Object fxmlObject, String name) {
        assert fxmlObject != null : "fx:id=\"" + name + "\" was not injected: check your FXML file 'MainView.fxml'.";
    }

    private SliderToggle getSliderToggle() {
        RadioButton rb = (RadioButton) sliderToggle.getSelectedToggle();
        switch (rb.getId()) {
        case SELECT_LIGHT1:
            return SliderToggle.LIGHT1;
        case SELECT_LIGHT2:
            return SliderToggle.LIGHT2;
        default:
            return SliderToggle.NONE;
        }
    }

    private enum SliderToggle {
        LIGHT1, LIGHT2, NONE
    }
}
