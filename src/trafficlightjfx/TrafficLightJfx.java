/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trafficlightjfx;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Traffic Lights radio button example
 * @author I. Bennett 2/4/2018
 */
public class TrafficLightJfx extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        RadioButton rbRed = new RadioButton();
        rbRed.setText("Red light");
        rbRed.setUserData("Red");
        rbRed.setSelected(true);
        RadioButton rbAmber = new RadioButton();
        rbAmber.setText("Amber");
        rbAmber.setUserData("Amber");
        RadioButton rbGreen = new RadioButton();
        rbGreen.setText("Green");
        rbGreen.setUserData("Green");
        ToggleGroup tgRb = new ToggleGroup();
        rbRed.setToggleGroup(tgRb);
        rbAmber.setToggleGroup(tgRb);
        rbGreen.setToggleGroup(tgRb);
        
        Label lblSelection = new Label();
        /*Button btn = new Button();
        btn.setText("Show selection");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                lblSelection.setText("You have selected " + tgRb.getSelectedToggle().getUserData());
                
            }
        });     */   
        
        tgRb.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                //lblSelection.setText("You have selected " + tgRb.getSelectedToggle().getUserData());
                lblSelection.setText("You have selected " + newValue.getUserData());
                switch (newValue.getUserData().toString()) {
                    case "Red":
                        lblSelection.setTextFill(Color.RED);
                        break;
                    case "Amber":
                        lblSelection.setTextFill(Color.YELLOW);
                        break;
                    case "Green":
                        lblSelection.setTextFill(Color.GREEN);
                        break;
                    default:
                        lblSelection.setTextFill(Color.BLACK);
                        break;
                }                
            }                        
        });
        
        VBox root = new VBox();
        root.setSpacing(10);
        //root.getChildren().addAll(rbRed, rbAmber, rbGreen, btn, lblSelection);
        root.getChildren().addAll(rbRed, rbAmber, rbGreen, lblSelection);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Traffic lights");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
