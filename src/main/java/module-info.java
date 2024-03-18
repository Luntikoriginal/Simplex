module ru.ac.uniyar.simplex {
    requires javafx.controls;
    requires javafx.fxml;


    opens ru.ac.uniyar.simplex to javafx.fxml;
    exports ru.ac.uniyar.simplex;
    exports ru.ac.uniyar.simplex.controllers;
    opens ru.ac.uniyar.simplex.controllers to javafx.fxml;
}