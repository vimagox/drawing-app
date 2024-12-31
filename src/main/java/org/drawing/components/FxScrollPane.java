package org.drawing.components;

import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;

/**
 * Common place for convenient ScrollPane defaults and abstractions
 */
public class FxScrollPane extends ScrollPane {
    public FxScrollPane(Node node) {
        super(node);
        setFitToHeight(true);
        setFitToWidth(true);
    }

    public void addContent(Node node) {
        ((Pane)getContent()).getChildren().add(node);
    }

    public void removeContent(Node node) {
        ((Pane)getContent()).getChildren().remove(node);
    }
}
