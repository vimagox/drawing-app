package org.drawing;

import org.drawing.components.FxBox;
import org.drawing.components.FxButton;

class Toolbar extends FxBox.H {
    Toolbar(FxButton... buttons) {
        super("toolbar", buttons);
    }
}
