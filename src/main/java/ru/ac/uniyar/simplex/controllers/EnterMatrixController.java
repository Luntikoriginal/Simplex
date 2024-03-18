package ru.ac.uniyar.simplex.controllers;

import javafx.stage.Stage;

public class EnterMatrixController {

    private Stage primaryStage;

    private DataController dataController;

    public void setProperties(Stage primaryStage, DataController dataController) {
        this.primaryStage = primaryStage;
        this.dataController = dataController;
    }
}
