package GUI;

import Main.MainAppClass;

import javax.swing.*;
import java.awt.*;


public class AFrame extends JFrame {

    protected AbstractPanel panel;

    public AFrame(AbstractPanel panel) {
        setLocationRelativeTo(null);

        setTitle(MainAppClass.title);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setPanel(panel);
        setVisible(true);
        pack();
        setMinimumSize(new Dimension(500, 600));
    }


    public void setPanel(AbstractPanel panel) {
        Dimension dimension = getSize();
        if(this.panel != null)
            remove(this.panel);
        this.panel = panel;
        add(panel);
        pack();
        setSize(dimension);
    }

    public AbstractPanel getPanel() {
        return panel;
    }
}
