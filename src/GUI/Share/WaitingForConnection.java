package GUI.Share;

import GUI.AbstractPanel;
import GUI.ButtonOfMine;
import GUI.FirstPanel;
import Main.AsMaster;
import Main.MainAppClass;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class WaitingForConnection extends AbstractPanel {

    JLabel waiting;
    ButtonOfMine back;

    public WaitingForConnection() {
        super(MainAppClass.frame);

        waiting = new JLabel("Ожидание подключения...");
        waiting.setFont(MainAppClass.labelFont);

        northPanel.add(waiting);

        back = new ButtonOfMine("Назад");
        back.addActionListener(this);
        centerPanel.add(back);
        MainAppClass.transmitting.connect();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == back){
            MainAppClass.transmitting = null;
            frame.setPanel(new FirstPanel());
        }
        else{
            frame.setPanel(new SharingFile());
        }
    }
}
