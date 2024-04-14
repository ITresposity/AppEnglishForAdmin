package com.englishforadmin;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/com/englishforadmin/fxml/main.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 900 , 640);
        stage.setTitle("English application management for administrator ");
        String cssFile = "./com.englishforadmin/fxml/styles.css";
        scene.getStylesheets().add("");

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}