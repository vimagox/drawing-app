package org.drawing.components;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.css.SimpleStyleableBooleanProperty;
import javafx.css.StyleableBooleanProperty;
import javafx.css.StyleableProperty;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

/**
 * Common place for convenient Shape defaults and abstractions
 */
public class FxShape  {

    // Selectable Circle
    public static class FxCircle extends Circle implements FxSelectable {
        private final BooleanProperty selectedProperty;
        private FxCircle() {
            super(25, 25, 25, Color.WHITE);
            getStyleClass().add("fx-circle");
            this.selectedProperty = new SimpleBooleanProperty();
            setOnMouseClicked(_ -> selectedProperty.set(!selectedProperty.get()));
            this.selectedProperty.addListener((o, ov, nv) -> {
                if(nv) {
                    getStyleClass().add("selected");
                } else {
                    getStyleClass().remove("selected");
                }
            });
        }
        public BooleanProperty selectedProperty() { return selectedProperty; }
    }

    // Selectable Rectangle
    public static class FxRectangle extends Rectangle implements FxSelectable {
        private final BooleanProperty selectedProperty;
//        private final StyleableProperty styleableProperty;
        private FxRectangle() {
            super(150, 30, Color.WHITE);
            getStyleClass().add("fx-rect");
            this.selectedProperty = new SimpleBooleanProperty();
//            this.styleableProperty = new SimpleStyleableBooleanProperty(null, this, "selected");
            setOnMouseClicked(_ -> selectedProperty.set(!selectedProperty.get()));
            this.selectedProperty.addListener((o, ov, nv) -> {
                if(nv) {
                    getStyleClass().add("selected");
                } else {
                    getStyleClass().remove("selected");
                }
            });
        }
        public BooleanProperty selectedProperty() { return selectedProperty; }
    }

    /**
     * Provides with a draggable circle
     * @return circle
     */
    public static FxCircle circle() {
        FxCircle fxCircle = new FxCircle();
        FxNode.makeDraggable(fxCircle);
        return fxCircle;
    }

    /**
     * Provides with a draggable rectangle
     * @return rectangle
     */
    public static FxRectangle rect() {
        FxRectangle fxRect = new FxRectangle();
        FxNode.makeDraggable(fxRect);
        return fxRect;
    }
}