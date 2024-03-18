package ru.ac.uniyar.simplex.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import ru.ac.uniyar.simplex.domain.TaskEntity;
import ru.ac.uniyar.simplex.windows.EnterTaskSettingsWindow;
import ru.ac.uniyar.simplex.windows.ReferenceWindow;

import static ru.ac.uniyar.simplex.utils.FileUtils.getTaskFromFile;
import static ru.ac.uniyar.simplex.utils.GaussUtils.gauss;

public class MainController {

    private Stage primaryStage;

    private DataController dataController;

    public void setProperties(Stage primaryStage, DataController dataController) {
        this.primaryStage = primaryStage;
        this.dataController = dataController;
    }

    @FXML
    private Label welcomeText;

    @FXML
    protected void onHandButtonClick() {
        EnterTaskSettingsWindow window = new EnterTaskSettingsWindow(dataController);
        window.display();

        primaryStage.close();
    }

    @FXML
    protected void onFileButtonClick() {
        welcomeText.setText("Выбрано чтение из файла");
        TaskEntity task = getTaskFromFile("example.txt");
        if (task == null) {
            welcomeText.setText("Ошибка чтения файла!");
            return;
        }
        gauss(task.getMatrix(), task.getBases());
    }

    @FXML
    protected void onSupportButtonClick() {
        ReferenceWindow window = new ReferenceWindow();
        window.display();
    }
}