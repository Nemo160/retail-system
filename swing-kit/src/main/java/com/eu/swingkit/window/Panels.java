package com.eu.swingkit.window;

import javax.swing.*;
import java.awt.*;

public final class Panels {
    private Panels() {}

    public static JPanel flow(int align, int hgap, int vgap) {
        return new JPanel(new FlowLayout(align, hgap, vgap));
    }

    public static JPanel border(int hgap, int vgap) {
        return new JPanel(new BorderLayout(hgap, vgap));
    }

    public static JPanel grid(int rows, int cols, int hgap, int vgap) {
        return new JPanel(new GridLayout(rows, cols, hgap, vgap));
    }
}