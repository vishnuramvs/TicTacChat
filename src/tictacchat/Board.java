package tictacchat;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private char[][] table;
    private int numSpotsTaken;
    private List winningCoords;
    private int iWon;
    private int iLost;
    private int ties;

    public List getWinningCoords() {
        return winningCoords;
    }

    public int getiLost() {
        return iLost;
    }

    public void setiLost() {
        this.iLost++;
    }

    public int getiWon() {
        return iWon;
    }

    public void setiWon() {
        this.iWon++;
    }

    public int getTies() {
        return ties;
    }

    public void setTies() {
        this.ties++;
    }

    public void setWinningCoords(List winningCoords) {
        this.winningCoords = winningCoords;
    }

    public Board()
    {   table = new char[3][3];
        numSpotsTaken = 0;
        initialize();
    }


    public void initialize()
    {   for (int i=0; i < table.length; i++)
            for (int j=0; j < table[0].length; j++)
                table[i][j] = ' ';
        setWinningCoords(new ArrayList());
        numSpotsTaken=0;
    }

    public char[][] getTable() {
        return table;
    }



    public void printBoard()
    {   for (int i=0; i < table.length; i++) //for every row
        {   for (int j=0; j < table[0].length; j++)//for every column
                if (j < 2)
                    System.out.print(table[i][j]+"|");
                else
                    System.out.print(table[i][j]);
            if (i<2)
                System.out.println("\n-----");
        }
        System.out.println("\n");
    }

    public boolean insertIntoBoard(char piece, int x, int y)
    {   if ( table[x][y] == ' ' )
        {   table[x][y] = piece;
            numSpotsTaken++;
            return true;
        }
        
        return false;
    }

    public String checkGameOver(char piece)
    {
        if (checkHoriz(piece) || checkVert(piece) || checkDiag(piece))
        {   
            return Character.toString(piece);
        }
        if (numSpotsTaken == 9)
        {
            return "TIE";
        }
        return "";
    }

    public boolean checkHoriz(char piece)
    {   List tempList = new ArrayList();
        int  countMatches;
        for (int i=0; i < table.length; i++)
        {   countMatches = 0;
            for (int j=0; j < table[0].length; j++)
                 if (table[i][j] == piece) {
                     countMatches++;
                     tempList.add(i+","+j);
                 }
            if (countMatches == 3) {
                setWinningCoords(tempList);
                return true;
            }
        }
        return false;

    }

    public boolean checkVert(char piece)
    {
        List tempList = new ArrayList();
        int  countMatches;
        for (int i=0; i < table.length; i++)
        {   countMatches = 0;
            for (int j=0; j < table[0].length; j++)
                 if (table[j][i] == piece) {
                     countMatches++;
                     tempList.add(j+","+i);
                 }
            if (countMatches == 3) {
                setWinningCoords(tempList);
                return true;
            }
        }
        return false;
    }

    public boolean checkDiag(char piece)
    {   if (checkLeftDiag(piece) || checkRightDiag(piece))
            return true;
        return false;
    }

    public boolean checkLeftDiag(char piece)
    {
        List tempList = new ArrayList();
        int x, y, countMatches=0;

        x = y = 0;

        for (int i=0; i<3; i++)
        {    if (table[x][y] == piece) {
                countMatches++;
                tempList.add(x+","+y);
             }
             x++;
             y++;
        }
         if (countMatches == 3) {
             setWinningCoords(tempList);
             return true;
         }
         return false;
    }

    public boolean checkRightDiag(char piece)
    {
        List tempList = new ArrayList();
        int x, y, countMatches=0;

        x = 0;
        y = 2;

        for (int i=0; i<3; i++)
        {    if (table[x][y] == piece) {
                countMatches++;
                tempList.add(x+","+y);
             }
             x++;
             y--;
        }
         if (countMatches == 3) {
             setWinningCoords(tempList);
                return true;
         }
         return false;
    }
}
