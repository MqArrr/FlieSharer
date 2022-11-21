package Main;

import GUI.FirstPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.*;
import java.net.BindException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class AsSlave extends TypeOfUse{
    protected Socket master;
    private BufferedInputStream in;
    protected String ip;
    private WaitingThread waitingThread;

    public void setIP(String ip){
        this.ip = ip;
    }
    public AsSlave(String path) throws IOException {
        this.path = path;
        file = new File(path);
        file.createNewFile();
        System.out.println("File's done");
    }



    @Override
    public boolean connect(){
        master = new Socket();
        try {
            master.connect(new InetSocketAddress(ip, MainAppClass.PORT));
            in = new BufferedInputStream(master.getInputStream());
            waitingThread = new WaitingThread();
            waitingThread.start();
            return true;
        }
        catch (BindException e){
            JOptionPane.showMessageDialog(null, "Не подключено: ошибка порта");
            return false;
        }
        catch (IOException e) {
            System.err.println(e);
            return false;
        }
    }

    private class WaitingThread extends Thread {

        @Override
        public void run() {
           try(BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(file))) {
               JOptionPane.showMessageDialog(null, "Приём начат.");
               timeOfStart = System.currentTimeMillis();
               byte[] dataBuffer = new byte[8192];
               int dataLength = in.read(dataBuffer, 0, dataBuffer.length);

               while (dataLength != -1) {
                   out.write(dataBuffer, 0, dataLength);
                   out.flush();
                   dataLength = in.read(dataBuffer, 0, dataBuffer.length);
               }
               out.flush();
               in.close();
               JOptionPane.showMessageDialog(null, "Приём закончен за время = " + ((System.currentTimeMillis() - timeOfStart)/1000) + "секунд.");
               MainAppClass.frame.setPanel(new FirstPanel());
               master.close();
           } catch (FileNotFoundException e) {
               throw new RuntimeException(e);
           } catch (IOException e) {
               throw new RuntimeException(e);
           }

        }
    }
}
