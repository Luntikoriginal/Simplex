package ru.ac.uniyar.simplex.windows;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ru.ac.uniyar.simplex.controllers.MainController;
import ru.ac.uniyar.simplex.controllers.DataController;

import java.io.IOException;

public class MainWindow {

    private final DataController dataController;

    public MainWindow(DataController dataController) {
        this.dataController = dataController;
    }

    public void display() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("main-window-view.fxml"));

            Scene scene = new Scene(fxmlLoader.load(), 320, 200);

            Stage stage = new Stage();
            stage.setTitle("Simplex - меню");
            stage.setScene(scene);

            MainController controller = fxmlLoader.getController();
            controller.setProperties(stage, dataController);

            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
