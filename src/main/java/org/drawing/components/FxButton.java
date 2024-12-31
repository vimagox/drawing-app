package org.drawing.components;

import javafx.scene.control.Button;
import javafx.scene.shape.Shape;

/**
 * Common place for convenient Button defaults and abstractions
 */
public class FxButton extends Button {
    private FxButton(Runnable onAction) {
        this("fx-button", onAction);
    }

    private FxButton(String style, Runnable onAction) {
        this(style, null, onAction);
    }

    private FxButton(String style, Shape shape, Runnable onAction) {
        getStyleClass().add(style);
        setOnAction(_ -> onAction.run());
        if(shape != null) {
            setShape(shape);
        }
    }

    public static FxButton button(String style, Shape shape, Runnable onAction) {
        return new FxButton(style, shape, onAction);
    }

    public static FxButton button(Runnable onAction) {
        return new FxButton(onAction);
    }
}
