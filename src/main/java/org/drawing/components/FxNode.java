package org.drawing.components;

import javafx.scene.Node;

public class FxNode {
    private static class Draggable<T extends Node> {
        private double startX;
        private double startY;

        private Draggable(T node) {
            node.setOnMousePressed(e -> {
                startX = e.getSceneX() - node.getTranslateX();
                startY = e.getSceneY() - node.getTranslateY();
            });

            node.setOnMouseDragged(e -> {
                node.setTranslateX(e.getSceneX() - startX);
                node.setTranslateY(e.getSceneY() - startY);
            });
        }
    }

    public static void makeDraggable(Node node) {
        new Draggable<>(node);
    }
}
