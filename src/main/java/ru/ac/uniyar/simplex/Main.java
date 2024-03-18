package ru.ac.uniyar.simplex;

import javafx.application.Application;
import javafx.stage.Stage;
import ru.ac.uniyar.simplex.controllers.DataController;
import ru.ac.uniyar.simplex.windows.MainWindow;


public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        DataController dataController = new DataController();
        dataController.refresh();
        MainWindow window = new MainWindow(dataController);
        window.display();
    }
}