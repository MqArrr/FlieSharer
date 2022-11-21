package GUI.Share;

import GUI.AbstractPanel;
import GUI.FirstPanel;
import Main.AsMaster;
import Main.MainAppClass;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class SharingFile extends AbstractPanel {

    JLabel label;

    public SharingFile() {
        super(MainAppClass.frame);

        label = new JLabel("Передача файла");
        label.setFont(MainAppClass.labelFont);

        northPanel.add(label);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().getClass() == AsMaster.class){
            JOptionPane.showMessageDialog(null, "Файл был отправлен.");
            frame.setPanel(new FirstPanel());
        }
    }
}
