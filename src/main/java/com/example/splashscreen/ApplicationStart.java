package com.example.splashscreen;



import com.example.splashscreen.controllers.TitleScreenController;
import com.example.splashscreen.view.TitleScreen;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class ApplicationStart extends Application {
    @Override
    public void start(Stage stage) {

        TitleScreenController titleScreenController = new TitleScreenController(new TitleScreen());

        Scene scene = new Scene(titleScreenController.getView());
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        stage.setScene(scene);
        stage.setTitle("Splash Screen");
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}