package tictacchat;

public class Vlad
{         
    public static void main(String[] args) {
        new VladServer().start();
        new VladClient().start();
        new VladTicTacServer().start();
    }
}