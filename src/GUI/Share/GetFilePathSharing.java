package GUI.Share;

import GUI.AbstractPanel;
import GUI.ButtonOfMine;
import GUI.FirstPanel;
import Main.AsMaster;
import Main.MainAppClass;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class GetFilePathSharing extends AbstractPanel {

        JLabel label;
        JButton toFile, back;
        JFileChooser jfc;

        public GetFilePathSharing() {
            super(MainAppClass.frame);
            label = new JLabel("Выберите файл");
            northPanel.add(label);
            toFile = new ButtonOfMine("Выбрать");
            toFile.addActionListener(this);
            centerPanel.add(toFile);

            back = new ButtonOfMine("Назад");
            back.addActionListener(this);
            centerPanel.add(back);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == toFile){
                jfc = new JFileChooser();
                if(jfc.showOpenDialog(null)== 0) {
                    String path = jfc.getSelectedFile().getAbsolutePath();
                    System.out.println(path);
                    try {
                        MainAppClass.transmitting = new AsMaster(path);
                        frame.setPanel(new WaitingForConnection());

                    }
                    catch (IOException ioe){
                        System.out.println(ioe);
                        System.exit(2501);
                    }
                }


            }
            else if(e.getSource() == back){
                frame.setPanel(new FirstPanel());
            }
        }
}

