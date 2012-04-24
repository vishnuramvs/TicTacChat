package tictacchat;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import javax.swing.JOptionPane;

public class TcpMethods {
    public static boolean send(String str, int port) {
        try {
            Socket clientSocket = new Socket("localhost", port);
            clientSocket.setSoTimeout(5000); //Set a 5 second time out before we time out.
            DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
            outToServer.writeBytes(str);
            //System.out.println("FROM SERVER: " + modifiedSentence);
            clientSocket.close();
            return true;
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error connecting to server: localhost on port: "+port+". Please make sure the server is up at the other end.");
            ex.printStackTrace();
            return false;
        }
    }
}
