package org.drawing;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import org.drawing.components.FxBox;
import org.drawing.components.FxButton;
import org.drawing.components.FxShape;

public class App extends Application {
    @Override
    public void start(Stage stage) {
        DrawingArea drawingArea = new DrawingArea();
        Toolbar toolbar = new Toolbar(
            FxButton.button("circle",
                    new Circle(25,25,25), () -> drawingArea.add(FxShape.circle())),
            FxButton.button("rect",
                    new Rectangle(150, 30), () -> drawingArea.add(FxShape.rect()))
        );
        Scene scene = new Scene(FxBox.v(toolbar, drawingArea), 800, 600);
        VBox.setVgrow(drawingArea, Priority.ALWAYS);
        stage.setTitle("Drawing App");
        stage.setScene(scene);
        stage.getScene().getStylesheets().addAll("styles/app.css");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}