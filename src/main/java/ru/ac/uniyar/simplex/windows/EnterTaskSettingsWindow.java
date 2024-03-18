package ru.ac.uniyar.simplex.windows;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ru.ac.uniyar.simplex.controllers.EnterTaskSettingsController;
import ru.ac.uniyar.simplex.controllers.DataController;

import java.io.IOException;

public class EnterTaskSettingsWindow {

    private final DataController dataController;

    public EnterTaskSettingsWindow(DataController dataController) {
        this.dataController = dataController;
    }

    public void display() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("enter-task-settings-window-view.fxml"));

            Scene scene = new Scene(fxmlLoader.load(), 500, 500);

            Stage stage = new Stage();
            stage.setTitle("Simplex - ручной ввод задачи 1");
            stage.setScene(scene);

            EnterTaskSettingsController controller = fxmlLoader.getController();
            controller.setProperties(stage, dataController);

            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
