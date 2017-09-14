package com.example.template4fx;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;

public class Keys
{
    public static final KeyCombination ALT_LEFT = new KeyCodeCombination( KeyCode.LEFT, KeyCombination.ALT_DOWN );

    public static final KeyCombination ALT_RIGHT = new KeyCodeCombination( KeyCode.RIGHT, KeyCombination.ALT_DOWN );

    public static final KeyCombination CTRL_E = new KeyCodeCombination( KeyCode.E, KeyCombination.CONTROL_DOWN );

    public static final KeyCombination F5 = new KeyCodeCombination( KeyCode.F5 );
}
