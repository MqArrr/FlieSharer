package Main;

import GUI.FirstPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;

public class AsMaster extends TypeOfUse{

    protected ServerSocket master = new ServerSocket(MainAppClass.PORT);
    protected Socket slave;
    protected BufferedOutputStream out;


    public AsMaster(String path) throws IOException {
        this.path = path;
        file = new File(path);
    }


    @Override
    public boolean connect(){
        WaitingThread waitingThread = new WaitingThread();
        waitingThread.start();
        return true;
    }
    private class WaitingThread extends Thread {

        @Override
        public void run() {
            try (BufferedInputStream in = new BufferedInputStream(Files.newInputStream(file.toPath()))) {
                System.out.println("Waiting");
                slave = master.accept();
                System.out.println("Slave is connected.");
                timeOfStart = System.currentTimeMillis();
                MainAppClass.frame.getPanel().actionPerformed(new ActionEvent(this, 1, "Slave is connected"));

                out = new BufferedOutputStream(slave.getOutputStream());
                long length = file.length();
                int sizeOfBuffer;
                if(length > Integer.MAX_VALUE)
                    sizeOfBuffer = Integer.MAX_VALUE;
                else
                    sizeOfBuffer = (int) length;

                byte[] dataBuffer = new byte[sizeOfBuffer];
                int dataLength = in.read(dataBuffer, 0, dataBuffer.length);

                while (dataLength != -1) {
                    out.write(dataBuffer, 0, dataLength);
                    out.flush();
                    dataLength = in.read(dataBuffer, 0, dataBuffer.length);
                }
                out.flush();
                out.close();
                master.close();
                slave.close();
                JOptionPane.showMessageDialog(null, "Отправка закончена за время = " + ((System.currentTimeMillis() - timeOfStart)/1000) + "секунд.");
                MainAppClass.frame.setPanel(new FirstPanel());
                MainAppClass.frame.getPanel().actionPerformed(new ActionEvent(this, 2, ""));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
