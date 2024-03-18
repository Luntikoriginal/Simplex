package ru.ac.uniyar.simplex.controllers;

import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import ru.ac.uniyar.simplex.domain.Row;

public class EnterMatrixController {

    private Stage primaryStage;

    private DataController dataController;

    public void setProperties(Stage primaryStage, DataController dataController) {
        this.primaryStage = primaryStage;
        this.dataController = dataController;
        initialize();
    }

    @FXML
    private TableView<Row> matrixTable;

    private void initialize() {

        matrixTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        matrixTable.getItems().clear();

        addColumns();
        addEmptyRows();

        matrixTable.setFixedCellSize(30);
        matrixTable.setPrefHeight(matrixTable.getFixedCellSize() * dataController.getLimitations() + 26);
        matrixTable.setEditable(true);
    }

    private void addEmptyRows() {
        for (int i = 0; i < dataController.getLimitations(); i++) {
            matrixTable.getItems().add(new Row(dataController.getVariables() + 1));
        }
    }

    private void addColumns() {
        for (int i = 0; i < dataController.getVariables() + 1; i++) {
            final int index = i;

            if (i == dataController.getVariables()) {
                TableColumn<Row, String> column = new TableColumn<>("x" + (i + 1));
            }
            TableColumn<Row, String> column = new TableColumn<>("x" + (i + 1));
            column.setCellValueFactory(cellData -> {
                String[] rowData = cellData.getValue().getStrings();
                return new SimpleStringProperty(rowData[index]);
            });
            column.setCellFactory(TextFieldTableCell.forTableColumn());

            column.setOnEditStart(event -> {
                Row row = event.getTableView().getItems().get(event.getTablePosition().getRow());
                String[] rowData = row.getStrings();
                rowData[index] = event.getNewValue();
                row.setStrings(rowData);
            });

            matrixTable.getColumns().add(column);
        }

        addConstantColumn();
    }

    private void addConstantColumn() {
        TableColumn<Row, String> bColumn = new TableColumn<>("b");
        bColumn.setCellValueFactory(cellData -> {
            String[] rowData = cellData.getValue().getStrings();
            return new SimpleStringProperty(rowData[dataController.getVariables()]);
        });
        bColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        bColumn.setOnEditCommit(event -> {
            Row row = event.getTableView().getItems().get(event.getTablePosition().getRow());
            String[] rowData = row.getStrings();
            rowData[dataController.getVariables()] = event.getNewValue();
            row.setStrings(rowData);
        });

        matrixTable.getColumns().add(bColumn);
    }
}
