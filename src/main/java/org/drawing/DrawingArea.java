package org.drawing;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.Node;
import javafx.scene.input.KeyCode;
import org.drawing.components.FxBox;
import org.drawing.components.FxScrollPane;
import org.drawing.components.FxSelectable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class DrawingArea extends FxScrollPane {
    private final List<FxSelectable> selectables; // Tracks all selectables/shapes
    private ObjectProperty<FxSelectable> selected = null; // Tracks single selected shape

    private final List<KeyCode> DELETE_KEY_CODES = Arrays.asList(KeyCode.DELETE, KeyCode.BACK_SPACE);

    DrawingArea() {
        super(FxBox.v("drawing-area"));
        this.selectables = new ArrayList<>();
        this.selected = new SimpleObjectProperty<>();
        this.selected.addListener((o, ov, nv) -> {
            if (nv != null) { // Something has been selected. Sets any other selectables to false.
                selectables.stream().filter(s -> !nv.equals(s)).forEach(s -> s.selectedProperty().set(false));
                nv.selectedProperty().set(true);
            } else { // Something has been unselected. Set all selectables to false.
                selectables.forEach(s -> s.selectedProperty().set(false));
            }
        });
        setOnKeyPressed(e -> {
            // Deletes whatever is selected
            if(selected.get() != null && DELETE_KEY_CODES.contains(e.getCode())) {
                removeContent((Node) selected.get());
                selected.set(null);
            }
        });
    }

    void add(Node node) {
        addContent(node);
        node.setManaged(false);
        if(node instanceof FxSelectable selectable) {
            selectables.add(selectable);
            selectable.selectedProperty()
              .addListener((_, _, nv) -> selected.set(nv ? selectable : null));
//            selected.set(selectable);
        }
    }
}
