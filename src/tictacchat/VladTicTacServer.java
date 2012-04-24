
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


public class VladTicTacServer extends Thread
{
    boolean debug = false;
    public void run() {
        String[] temp;
        VladTicTacToe tic = new VladTicTacToe();
        tic.setVisible(true);
        try {
            String clientSentence;
            ServerSocket welcomeSocket = new ServerSocket(9875);
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
                    JOptionPane.showMessageDialog(null, "Josh has declined a new game.");
                    tic.jButton1Enable(true);
                } else if (temp[1].equalsIgnoreCase("NEWGAMEACK")) {
                    System.out.println("Josh has accepted the game!");
                    tic.board.initialize();
                    tic.setBoardVals(tic.board.getTable());
                    tic.resetBackgroundColor();
                    Random generator = new Random();
                    int r = generator.nextInt();
                    int result = r % 2;
                    if (result == 1) {
                        System.out.println("I am X, I go first");
                        TcpMethods.send("vlad:URO", 9876);
                        tic.setLabel1Text("You are X");
                        tic.setMyPiece("X");
                        tic.setHisPiece("O");
                        tic.setLabel2Text("Your Turn!");
                        tic.setMyTurn(true);
                        tic.enableBoard(true);
                        tic.setBoardVals(tic.board.getTable());
                    } else {
                        System.out.println("I am O, I go second");
                        TcpMethods.send("vlad:URX", 9876);
                        tic.setLabel1Text("You are O");
                        tic.setMyPiece("O");
                        tic.setHisPiece("X");
                        tic.setLabel2Text("Josh's Turn!");
                        tic.setMyTurn(false);
                        tic.setBoardVals(tic.board.getTable());
                    }
                }

                if (temp[1].equalsIgnoreCase("NEWGAMEREQ")) {
                    tic.jButton1Enable(false);
                    JDialog.setDefaultLookAndFeelDecorated(true);
                    int response = JOptionPane.showConfirmDialog(null, "Josh has requested a new game. Want to play?", "Vlad: Confirm",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (response == JOptionPane.NO_OPTION) {
                      System.out.println("No button clicked");
                      tic.jButton1Enable(true);
                      TcpMethods.send("vlad:NEWGAMENACK",9876);
                    } else if (response == JOptionPane.YES_OPTION) {
                      System.out.println("Yes button clicked");
                      TcpMethods.send("vlad:NEWGAMEACK",9876);
                      tic.board.initialize();
                      tic.setBoardVals(tic.board.getTable());
                      tic.resetBackgroundColor();
                    } else if (response == JOptionPane.CLOSED_OPTION) {
                      System.out.println("JOptionPane closed");
                      TcpMethods.send("vlad:NEWGAMENACK",9876);
                      tic.jButton1Enable(true);
                    }
                }

               if (temp[1].equalsIgnoreCase("URO")) {
                    tic.board.initialize();
                    tic.setBoardVals(tic.board.getTable());
                    tic.resetBackgroundColor();
                    tic.setLabel1Text("You are O");
                    tic.setMyPiece("O");
                    tic.setHisPiece("X");
                    tic.setLabel2Text("Josh's Turn!");
                    tic.setMyTurn(false);
                    tic.setBoardVals(tic.board.getTable());
                } else if (temp[1].equalsIgnoreCase("URX")) {
                    tic.board.initialize();
                    tic.setBoardVals(tic.board.getTable());
                    tic.resetBackgroundColor();
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
                    //tic.board.initialize();
                    //tic.setBoardVals(tic.board.getTable());
                    tic.enableBoard(false);
                    tic.jButton1Enable(true);
                    tic.setLabel1Text("Please start a new game");
                    if (temp[1].equalsIgnoreCase("TIE")) {
                        tic.board.setTies();
                        tic.setStats();
                        tic.setLabel2Text("Last game was a tie.");
                        JOptionPane.showMessageDialog(null, "The game is a TIE!");
                    } else {
                        if (temp[1].equalsIgnoreCase(Character.toString(tic.getMyPiece()))) {
                            System.out.println("YOU WON!!");
                            tic.board.setiWon();
                            tic.setStats();
                            tic.setLabel2Text("YOU WON the last game!");
                            JOptionPane.showMessageDialog(null, "Congratulations, Vlad! You won the game!");
                        } else {
                            tic.setLabel2Text("YOU LOST the last game!");
                            String[] moveArr = temp[2].split(",");
                            System.out.println("his piece is "+tic.getHisPiece().charAt(0)+ " x "+moveArr[0]+" y"+moveArr[1]);
                            tic.board.insertIntoBoard(tic.getHisPiece().charAt(0), Integer.parseInt(moveArr[0]), Integer.parseInt(moveArr[1]));
                            tic.setBoardVals(tic.board.getTable());
                            tic.board.checkGameOver(tic.getHisPiece().charAt(0));
                            tic.markWinningPieces();
                            tic.board.setiLost();
                            tic.setStats();
                            JOptionPane.showMessageDialog(null, "Josh won the game, you lost!");
                        }

                    }
                }
            }
        } catch (IOException ex) { ex.printStackTrace(); }
    }
}

