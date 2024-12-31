package org.drawing.components;

import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * Common place for convenient HBox/VBox defaults and abstractions
 */
public class FxBox {
    public static final class H extends HBox {
        H(String style, Node... nodes) {
            getStyleClass().add(style);
            add(nodes);
        }
        H(Node... nodes) {
            add(nodes);
        }
        H(int prefHeight, Node... nodes) {
            setPrefHeight(prefHeight);
            add(nodes);
        }
        public H(int prefWidth, int prefHeight, Node... nodes) {
            setPrefSize(prefWidth, prefHeight);
            add(nodes);
        }
        public void add(Node node) { getChildren().add(node); }
        public void add(Node... nodes) { for(Node node: nodes) add(node); }
    }

    public static final class V extends VBox {
        public V(String style, Node... nodes) {
            getStyleClass().add(style);
            add(nodes);
        }
        public V(Node... nodes) {
            super(nodes);
        }
        public V(int prefWidth, int prefHeight, Node... nodes) {
            setPrefSize(prefWidth, prefHeight);
        }
        public void add(Node node) { getChildren().add(node); }
        public void add(Node... nodes) { for(Node node: nodes) add(node); }
    }

    public static H h(int prefHeight, Node... nodes) {
        return new H(prefHeight, nodes);
    }

    public static H h(String style, Node... nodes) {
        return new H(style, nodes);
    }

    public static H h(Node... nodes) {
        return new H(nodes);
    }

    public static V v(int prefWidth, int prefHeight, Node... nodes) {
        return new V(prefWidth, prefHeight, nodes);
    }

    public static V v(String style, Node... nodes) {
        return new V(style, nodes);
    }

    public static V v(Node... nodes) {
        return new V(nodes);
    }
}
