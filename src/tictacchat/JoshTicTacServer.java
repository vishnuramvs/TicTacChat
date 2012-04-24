/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tictacchat;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class JoshTicTacServer extends Thread {
    public void run() {
        String[] temp;
        JoshTicTacToe tic = new JoshTicTacToe();
        tic.setVisible(true);
        try {
            String clientSentence;
            ServerSocket welcomeSocket = new ServerSocket(9876);
            while(1==1)
            {
                Socket connectionSocket = welcomeSocket.accept();
                BufferedReader inFromClient =
                   new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
                DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
                clientSentence = inFromClient.readLine();
                System.out.println("Received: " + clientSentence);
                temp=clientSentence.split(":");

                if (temp[1].equalsIgnoreCase("NEWGAMENACK")) {
                    JOptionPane.showMessageDialog(null, "Vlad has declined a new game.");
                    tic.jButton1Enable(true);
                } else if (temp[1].equalsIgnoreCase("NEWGAMEACK")) {
                    tic.board.initialize();
                    tic.setBoardVals(tic.board.getTable());
                    tic.resetBackgroundColor();
                    System.out.println("Vlad has accepted the game!");
                    Random generator = new Random();
                    int r = generator.nextInt();
                    int result = r % 2;
                    if (result == 1) {
                        System.out.println("I am X, I go first");
                        TcpMethods.send("josh:URO", 9875);
                        tic.setLabel1Text("You are X");
                        tic.setMyPiece("X");
                        tic.setHisPiece("O");
                        tic.setLabel2Text("Your Turn!");
                        tic.enableBoard(true);
                        tic.setBoardVals(tic.board.getTable());
                    } else {
                        System.out.println("I am O, I go second");
                        TcpMethods.send("josh:URX", 9875);
                        tic.setLabel1Text("You are O");
                        tic.setMyPiece("O");
                        tic.setHisPiece("X");
                        tic.setLabel2Text("Vlad's Turn");
                        tic.setBoardVals(tic.board.getTable());
                    }
                }

                if (temp[1].equalsIgnoreCase("NEWGAMEREQ")) {
                    tic.jButton1Enable(false);
                    JDialog.setDefaultLookAndFeelDecorated(true);
                    int response = JOptionPane.showConfirmDialog(null, "Vlad has requested a new game. Want to play?", "Josh: Confirm",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (response == JOptionPane.NO_OPTION) {
                      System.out.println("No button clicked");
                      tic.jButton1Enable(true);
                      TcpMethods.send("Josh:NEWGAMENACK",9875);
                    } else if (response == JOptionPane.YES_OPTION) {
                      System.out.println("Yes button clicked");
                      TcpMethods.send("Josh:NEWGAMEACK",9875);
                      tic.board.initialize();
                      tic.setBoardVals(tic.board.getTable());
                      tic.resetBackgroundColor();
                    } else if (response == JOptionPane.CLOSED_OPTION) {
                      System.out.println("JOptionPane closed");
                      TcpMethods.send("Josh:NEWGAMENACK",9875);
                      tic.jButton1Enable(true);
                    }
                }

               if (temp[1].equalsIgnoreCase("URO")) {
                    tic.setLabel1Text("You are O");
                    tic.setMyPiece("O");
                    tic.setHisPiece("X");
                    tic.setLabel2Text("Josh's Turn!");
                    tic.setMyTurn(false);
                    tic.setBoardVals(tic.board.getTable());
                } else if (temp[1].equalsIgnoreCase("URX")) {
                    tic.setLabel1Text("You are X");
                    tic.setLabel2Text("Your Turn!");
                    tic.setMyPiece("X");
                    tic.setHisPiece("O");
                    tic.setMyTurn(true);
                    tic.enableBoard(true);
                    tic.setBoardVals(tic.board.getTable());
                }

                if (temp[1].equalsIgnoreCase("PIECE")) {
                    String[] moveArr = temp[2].split(",");
                    tic.board.insertIntoBoard(moveArr[2].charAt((0)), Integer.parseInt(moveArr[0]), Integer.parseInt(moveArr[1]));
                    tic.setBoardVals(tic.board.getTable());
                    tic.enableBoard(true);
                    tic.setMyTurn(true);
                    tic.setLabel2Text("Your Turn!");
                }
                if (temp[0].equalsIgnoreCase("GAMEOVER")) {
                    
                    tic.enableBoard(false);
                    tic.jButton1Enable(true);
                    tic.setLabel1Text("Please start a new game");
                    if (temp[1].equalsIgnoreCase("TIE")) {
                        tic.setLabel2Text("Last game was a tie.");
                        JOptionPane.showMessageDialog(null, "The game is a TIE!");
                        tic.board.setTies();
                        tic.setStats();
                    } else {
                        if (temp[1].equalsIgnoreCase(Character.toString(tic.getMyPiece()))) {
                            System.out.println("YOU WON!!");
                            tic.setLabel2Text("YOU WON the last game!");
                            JOptionPane.showMessageDialog(null, "Congratulations, Josh! You won the game!");
                            tic.board.setiWon();
                            tic.setStats();
                        } else {
                            tic.setLabel2Text("YOU LOST the last game!");
                            String[] moveArr = temp[2].split(",");
                            System.out.println("his piece is "+tic.getHisPiece().charAt(0)+ " x "+moveArr[0]+" y"+moveArr[1]);
                            tic.board.insertIntoBoard(tic.getHisPiece().charAt(0), Integer.parseInt(moveArr[0]), Integer.parseInt(moveArr[1]));
                            tic.setBoardVals(tic.board.getTable());
                            String result=tic.board.checkGameOver(tic.getHisPiece().charAt(0));
                            System.out.println("his peice: "+tic.getHisPiece().charAt(0)+" result is "+result);
                            tic.markWinningPieces();
                            JOptionPane.showMessageDialog(null, "Vlad won the game, you lost!");
                            tic.board.setiLost();
                            tic.setStats();
                        }

                    }
                }
            }
        } catch (IOException ex) { ex.printStackTrace(); }
    }
}
