package ru.ac.uniyar.simplex.windows;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ru.ac.uniyar.simplex.controllers.EnterMatrixController;
import ru.ac.uniyar.simplex.controllers.DataController;

import java.io.IOException;

public class EnterMatrixWindow {

    private final DataController dataController;

    public EnterMatrixWindow(DataController dataController) {
        this.dataController = dataController;
    }

    public void display() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("enter-matrix-window-view.fxml"));

            Scene scene = new Scene(fxmlLoader.load(), 500, 500);

            Stage stage = new Stage();
            stage.setTitle("Simplex - ручной ввод задачи 2");
            stage.setScene(scene);

            EnterMatrixController controller = fxmlLoader.getController();
            controller.setProperties(stage, dataController);

            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
