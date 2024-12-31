package org.drawing;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.drawing.components.FxBox;
import org.drawing.components.FxButton;

import java.io.IOException;

public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Scene scene = new Scene(FxBox.v(
            FxBox.h("toolbar", new FxButton[] {
                FxButton.button("button-circle", () -> {}),
                FxButton.button("button-rect", () -> {}),
            }),
            FxBox.v("drawing-area")
        ), 800, 600);
        stage.setTitle("Drawing App");
        stage.setScene(scene);
        stage.getScene().getStylesheets().addAll("styles/app.css");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}