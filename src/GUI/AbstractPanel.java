package GUI;

import GUI.AFrame;
import Main.MainAppClass;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.awt.Frame.NORMAL;

public class AbstractPanel extends JPanel implements ActionListener {
    protected AFrame frame;
    protected JPanel centerPanel;
    protected JPanel northPanel;
    protected JPanel southPanel;
    protected JLabel ip;

    public AbstractPanel(AFrame frame) {
        this.frame = frame;

        centerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        northPanel = new JPanel();
        southPanel = new JPanel();
        ip = new JLabel("Ваш IP: " + MainAppClass.IP);
        ip.setFont(new Font("Arial", NORMAL, 20));
        southPanel.add(ip);
        setLayout(new BorderLayout());
        centerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        add(centerPanel, BorderLayout.CENTER);
        add(northPanel, BorderLayout.NORTH);
        add(southPanel, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
