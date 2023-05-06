/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package ludo.king;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author USER
 */
public class LudoKing extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root=FXMLLoader.load(getClass().getResource("main.fxml"));
        Scene scene=new Scene(root,600,600);
        
        
        primaryStage.setScene(scene);
        primaryStage.setTitle("Ludo King");
        primaryStage.getIcons().add(new Image("C:\\Users\\USER\\Desktop\\logo.png"));
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
