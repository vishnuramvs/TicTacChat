package tictacchat;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.zip.CRC32;
import java.util.zip.Checksum;
import javax.swing.*;
import javax.swing.text.DefaultCaret;

public class VladClient extends Thread
{
    static JTextArea incoming;
    JTextField outgoing;
    boolean debug = false;

    public void run() {
        JFrame frame = new JFrame("VladClient");
        JPanel mainPanel = new JPanel();

        incoming = new JTextArea(10, 40);
        incoming.setLineWrap(true);
        incoming.setWrapStyleWord(true);
        incoming.setEditable(false);

        //Autoscroll
        DefaultCaret caret = (DefaultCaret)incoming.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);

        JScrollPane textScroller = new JScrollPane(incoming);
        textScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        textScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        outgoing = new JTextField(20);
        JButton sendButton = new JButton("Send");
        sendButton.addActionListener(new SendButtonListener());
        outgoing.addActionListener(new SendButtonListener());
        mainPanel.add(textScroller);
        mainPanel.add(outgoing);
        mainPanel.add(sendButton);
        frame.setAlwaysOnTop(true);
        frame.setResizable(false);
        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 250);
        frame.setVisible(true);

        outgoing.requestFocus();

    }

    private void send() {
        String sentence = outgoing.getText();

         if (sentence.isEmpty()) return;

         byte[] buff = new byte[512];

           Checksum checksum = new CRC32();

           checksum.update(buff,0,sentence.length());
           long lngChecksum = checksum.getValue();
           if(debug) System.out.println("The client value of checksum is " + lngChecksum);
           int messageSize = sentence.length();
        if(sentence.length()>9)
            sentence = lngChecksum + sentence + sentence.length() + "0";
        else
            sentence = lngChecksum + sentence + sentence.length();

        try {

        DatagramSocket clientSocket = new DatagramSocket();

        DatagramPacket sendPacket =
                new DatagramPacket(sentence.getBytes(), sentence.length(), InetAddress.getLocalHost(), 9876);
        clientSocket.send(sendPacket);
        clientSocket.close();
        if (messageSize <= 9)
                {   sentence = sentence.substring(String.valueOf(lngChecksum).length(), sentence.length()-1);
                }
                else if (messageSize > 9)
                {
                    sentence = sentence.substring(String.valueOf(lngChecksum).length(), sentence.length()-3);
                }
        incoming.append("Vlad: " + sentence + "\n");

        } catch(IOException ex) { ex.printStackTrace(); }
    }

    public class SendButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent ev) {
            try {
                send();
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
            outgoing.setText("");
            outgoing.requestFocus();
        }
    }
}
