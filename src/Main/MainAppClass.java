package Main;
import GUI.AFrame;
import GUI.FirstPanel;

import java.awt.*;
import java.net.*;

import static java.awt.Frame.NORMAL;
import static java.awt.Frame.getFrames;

public class MainAppClass {

    public static String title = "FileSharer";
    public static Font labelFont = new Font("Arial",NORMAL, 25);
    public static String IP;
    public static final int PORT = 25010;

    public static Socket slave;
    public static ServerSocket master;
    public static AFrame frame;
    public static TypeOfUse transmitting;

    public static void main(String[] args) {
        try {
            IP = String.valueOf(InetAddress.getLocalHost()).replaceAll("\\S*/", "");
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
        frame = new AFrame(new FirstPanel());

    }
}
