package com.GeoApp.App;

import java.awt.Color;

import javax.swing.JComponent;
import javax.swing.JToolTip;

public class ApplicationCustomJToolTip extends JToolTip {

    public ApplicationCustomJToolTip(JComponent component) {
        super();
        setComponent(component);
        setBackground(Color.black);
        setForeground(Color.black);
    }
}
