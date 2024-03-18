package ru.ac.uniyar.simplex.windows;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ReferenceWindow {

    public void display() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("reference-window-view.fxml"));

            Scene scene = new Scene(fxmlLoader.load(), 500, 300);

            Stage stage = new Stage();
            stage.setTitle("Simplex - справка");
            stage.setScene(scene);

            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
