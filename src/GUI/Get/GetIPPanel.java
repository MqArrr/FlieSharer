package GUI.Get;

import GUI.AbstractPanel;
import Main.AsSlave;
import Main.MainAppClass;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


public class GetIPPanel extends AbstractPanel {

    JLabel label;
    JTextField ip;

    public GetIPPanel() {
        super(MainAppClass.frame);
        label = new JLabel("Введите IP-адрес второго компьютера.");
        label.setFont(MainAppClass.labelFont);
        northPanel.add(label);
        ip = new JTextField();
        ip.setPreferredSize(new Dimension(350, 50));
        ip.addActionListener(this);
        ip.setFont(new Font("Consolas", Font.PLAIN, 16));
        centerPanel.add(ip);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == ip){
            String IP = ip.getText();
            if(!IP.matches("^((25[0-5]|(2[0-4]|1\\d|[1-9]|)\\d)(\\.(?!$)|$)){4}$")){
                JOptionPane.showMessageDialog(null, "Введи нормальный IP, а не лажу эту.", "Ошибка", JOptionPane.ERROR_MESSAGE);
                return;
            }
            AsSlave asSlave = (AsSlave) MainAppClass.transmitting;
            asSlave.setIP(IP);

            if(!asSlave.connect()){
                JOptionPane.showMessageDialog(null, "Не подключено", "Ошибка", JOptionPane.ERROR_MESSAGE);
                return;
            }
            JOptionPane.showMessageDialog(null, "Подключено");
        }
    }
}
