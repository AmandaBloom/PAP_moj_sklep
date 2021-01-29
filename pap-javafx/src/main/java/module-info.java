module pap.pap_javafx {
    requires javafx.controls;
    requires javafx.fxml;

    opens pap to javafx.fxml;
    opens controllers to javafx.fxml;
    opens dialogs to javafx.fxml;
    requires java.sql;
    requires javafx.graphics;
    requires javafx.base;
    exports pap;
    exports controllers;
    exports dialogs;
}