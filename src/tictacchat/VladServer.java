package tictacchat;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.zip.CRC32;
import java.util.zip.Checksum;

public class VladServer extends Thread
{   
    boolean debug = false;
    
    public void run() {
        try {
            DatagramSocket serverSocket = new DatagramSocket(9875);
            while(true)
            {

                int messageSize = 0;
                byte[] buff = new byte[512];
                byte[] receiveData = new byte[512];
                
                DatagramPacket receivePacket = 
                        new DatagramPacket(receiveData, receiveData.length);
                serverSocket.receive(receivePacket);
                
                String sentence = new String(receivePacket.getData());
//                sentence = sentence.replaceAll("\u0000.*", "");
                sentence = sentence.trim();
                Checksum checksum = new CRC32();
                
                if((Integer.parseInt(sentence.substring(sentence.length()-1)) == 0)){
                    messageSize = Integer.parseInt(sentence.substring((sentence.length() - 3),(sentence.length() - 1)));
                    System.out.println("messageSize1: " + messageSize);
                }
                else if((Integer.parseInt(sentence.substring(sentence.length()-1)) != 0 )) {
                    messageSize = Integer.parseInt(sentence.substring(sentence.length()-1));
                    System.out.println("messageSize2: " + messageSize);
                }
                checksum.update(buff,0,messageSize);
                System.out.println("Input string length: " + messageSize);
                
                long lngChecksum = checksum.getValue();
                if(debug) System.out.println("The value of checksum is " + lngChecksum);
                
                int checksumLength = String.valueOf(lngChecksum).length();
                
                long test = Long.parseLong(sentence.substring(0,checksumLength));
                System.out.println("Server: " + lngChecksum + "Client: " + test);
                if((test != lngChecksum))
                {
                    System.out.println("CHECKSUM FAILED! RETRY!");
                    continue;
                }
                
                if (messageSize <= 9)
                {   sentence = sentence.substring(String.valueOf(lngChecksum).length(), sentence.length()-1);
                }
                else if (messageSize > 9)
                {
                    sentence = sentence.substring(String.valueOf(lngChecksum).length(), sentence.length()-3);
                }
                VladClient.incoming.append("Josh: " + sentence + "\n");

            }
        } catch (IOException ex) { ex.printStackTrace(); }
    }
}
    
    