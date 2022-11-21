package GUI;

import javax.swing.*;
import java.awt.*;

import static Main.MainAppClass.labelFont;

public class ButtonOfMine extends JButton {
    public ButtonOfMine(String s) {
        super(s);
        setPreferredSize(new Dimension(300, 130));
        setFocusPainted(false);
        setFont(labelFont);
    }
}
