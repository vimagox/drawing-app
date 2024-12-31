package org.drawing.components;

import javafx.scene.control.Button;

/**
 * Common place for convenient Button defaults and abstractions
 */
public class FxButton extends Button {
    private FxButton(Runnable onAction) {
        this("fx-button", onAction);
    }

    private FxButton(String style, Runnable onAction) {
        getStyleClass().add(style);
        setOnAction(_ -> onAction.run());
    }

    public static FxButton button(String style, Runnable onAction) {
        return new FxButton(style, onAction);
    }

    public static FxButton button(Runnable onAction) {
        return new FxButton(onAction);
    }
}
