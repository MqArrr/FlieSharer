package GUI.Get;

import GUI.ButtonOfMine;
import GUI.FirstPanel;
import GUI.AbstractPanel;
import Main.AsSlave;
import Main.MainAppClass;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class GetFilePathPanel extends AbstractPanel {

    JLabel label;
    JButton toFile, back;
    JFileChooser jfc;

    public GetFilePathPanel() {
        super(MainAppClass.frame);
        label = new JLabel("Выберите место для сохранения файла");
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
            if(jfc.showSaveDialog(null)== 0) {
                String path = jfc.getSelectedFile().getAbsolutePath();
                try {
                    MainAppClass.transmitting = new AsSlave(path);
                }
                catch (IOException ioe){
                    System.out.println("Error");
                    JOptionPane.showMessageDialog(null, "Error while making file");
                    System.exit(2501);
                }
            }
            frame.setPanel(new GetIPPanel());
        }
        else if(e.getSource() == back){
            frame.setPanel(new FirstPanel());
        }
    }
}
