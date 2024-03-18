package ru.ac.uniyar.simplex.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;
import ru.ac.uniyar.simplex.windows.EnterMatrixWindow;

public class EnterTaskSettingsController {

    private Stage primaryStage;

    private DataController dataController;

    public void setProperties(Stage primaryStage, DataController dataController) {
        this.primaryStage = primaryStage;
        this.dataController = dataController;
    }

    @FXML
    private Label debugText;
    @FXML
    private TextField variablesField;
    @FXML
    private TextField limitationsField;
    @FXML
    private ChoiceBox<String> choiceTaskBox;

    @FXML
    private void initialize() {
        variablesField.setTextFormatter(new TextFormatter<>(new IntegerStringConverter()));

        variablesField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                variablesField.setText(oldValue);
            }
        });

        limitationsField.setTextFormatter(new TextFormatter<>(new IntegerStringConverter()));

        limitationsField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                limitationsField.setText(oldValue);
            }
        });
    }

    @FXML
    protected void changeVariablesField() {
        if (!variablesField.getText().isEmpty()) {
            dataController.setVariables(Integer.parseInt(variablesField.getText()));
        } else {
            dataController.setVariables(null);
        }
        debugText.setText(String.valueOf(variablesField.getText()));
    }

    @FXML
    protected void changeLimitationsField() {
        if (!limitationsField.getText().isEmpty()) {
            dataController.setLimitations(Integer.parseInt(limitationsField.getText()));
        } else {
            dataController.setLimitations(null);
        }
        debugText.setText(String.valueOf(limitationsField.getText()));
    }

    @FXML
    protected void changeChoiceTaskBox() {
        dataController.setTaskType(choiceTaskBox.getValue());
        debugText.setText(dataController.getTaskType());
    }

    @FXML
    protected void onSubmitButtonClick() {
        if (dataController.isSettingsGot()) {
            debugText.setText("Принято");
            EnterMatrixWindow window = new EnterMatrixWindow(dataController);
            window.display();
            primaryStage.close();
        }
        debugText.setText("Не принято");
    }
}
