package org.drawing.components;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

/**
 * Common place for convenient Shape defaults and abstractions
 */
public class FxShape  {

    private final static Color DEFAULT_COLOR = Color.BLACK;

    // Selectable Circle
    public static class FxCircle extends Circle implements FxSelectable {
        private final BooleanProperty selectedProperty;
        private FxCircle() {
            super(25, 25, 25, DEFAULT_COLOR);
            getStyleClass().add("fx-circle");
            this.selectedProperty = new SimpleBooleanProperty();
            //TODO must be a better way to do this. ie: StyleBooleanProperty????
            //TODO reuse this among shapes
            this.selectedProperty.addListener((o, ov, nv) -> {
                if(nv) {
                    getStyleClass().add("selected");
                } else {
                    getStyleClass().remove("selected");
                }
            });
            setOnMouseClicked(_ -> selectedProperty.set(!selectedProperty.get()));
        }
        public BooleanProperty selectedProperty() { return selectedProperty; }
    }

    // Selectable Rectangle
    public static class FxRectangle extends Rectangle implements FxSelectable {
        private final BooleanProperty selectedProperty;
        private FxRectangle() {
            super(100, 30, DEFAULT_COLOR);
            getStyleClass().add("fx-rect");
            this.selectedProperty = new SimpleBooleanProperty();
            setOnMouseClicked(_ -> selectedProperty.set(!selectedProperty.get()));
            //TODO must be a better way to do this. ie: StyleBooleanProperty????
            this.selectedProperty.addListener((o, ov, nv) -> {
                if(nv && ov != nv) {
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