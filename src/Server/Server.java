package Server;
import javax.swing.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server implements Runnable{
    private JList leaderBoard;
    private JPanel panel1;
    private JProgressBar gameProgress;
    private JButton startStopButton;
    private JTextField commandField;
    private Arena myGame = new Arena("Java Battle Arena");

    private ServerSocket update, volition;
    private int updatePort = 9091;
    private int volitionPort = 9092;

    public ArrayList<ClientListener> allClients = new ArrayList<>();

    public Server() throws IOException {
        volition = new ServerSocket(volitionPort);
        update = new ServerSocket(updatePort);
        this.run();
    }

    @Override
    public void run() {
        while(true){
            try{
                Socket updater = update.accept();
                Socket volitioner = volition.accept();
                ClientListener pending = new ClientListener(updater, volitioner);
                allClients.add(pending);
            } catch (IOException | ClassNotFoundException e) {
                System.err.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }
}