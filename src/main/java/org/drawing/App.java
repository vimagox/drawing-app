package org.drawing;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.drawing.components.FxBox;
import org.drawing.components.FxButton;
import org.drawing.components.FxShape;

public class App extends Application {
    @Override
    public void start(Stage stage) {
        DrawingArea drawingArea = new DrawingArea();
        Toolbar toolbar = new Toolbar(
            FxButton.button("button-circle", () -> drawingArea.add(FxShape.circle())),
            FxButton.button("button-rect", () -> drawingArea.add(FxShape.rect()))
        );
        Scene scene = new Scene(FxBox.v(toolbar, drawingArea), 800, 600);
        stage.setTitle("Drawing App");
        stage.setScene(scene);
        stage.getScene().getStylesheets().addAll("styles/app.css");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}