package tictacchat;

public class Josh
{         
    public static void main(String[] args) {
        new JoshServer().start();
        new JoshClient().start();
        new JoshTicTacServer().start();
    }
}