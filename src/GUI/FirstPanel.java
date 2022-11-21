package GUI;

import GUI.Get.GetFilePathPanel;
import GUI.Share.GetFilePathSharing;
import Main.MainAppClass;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

import static java.awt.Frame.NORMAL;


public class FirstPanel extends AbstractPanel {

    JLabel label;

    JButton get, share;

    public FirstPanel(){
        super(MainAppClass.frame);
        label = new JLabel("Выберите опцию");
        label.setFont(new Font("Arial", NORMAL, 25));
        northPanel.add(label);
        share = new ButtonOfMine("Поделиться");
        share.addActionListener(this);
        centerPanel.add(share);
        get = new ButtonOfMine("Получить");
        get.addActionListener(this);
        centerPanel.add(get);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        frame = MainAppClass.frame;
        if(e.getSource() == get){
            frame.setPanel(new GetFilePathPanel());
        }
        else if(e.getSource() == share){
            frame.setPanel(new GetFilePathSharing());
        }
    }
}
