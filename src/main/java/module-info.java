module org.example.drawingapp {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens org.example.drawingapp to javafx.fxml;
    exports org.example.drawingapp;
}