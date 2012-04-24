package tictacchat;

       
import java.awt.Color;
import java.util.Iterator;
import java.util.List;

public class JoshTicTacToe extends javax.swing.JFrame {
    private char myPiece;
    private Boolean myTurn;
    public Board board;
    private String hisPiece;
    /** Creates new form VladTicTacToe */
    public JoshTicTacToe() {
        board = new Board();
        initComponents();
    }

    public String getHisPiece() {
        return hisPiece;
    }

    public void setHisPiece(String hisPiece) {
        this.hisPiece = hisPiece;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btn00 = new javax.swing.JButton();
        btn10 = new javax.swing.JButton();
        btn20 = new javax.swing.JButton();
        btn11 = new javax.swing.JButton();
        btn01 = new javax.swing.JButton();
        btn02 = new javax.swing.JButton();
        btn12 = new javax.swing.JButton();
        btn21 = new javax.swing.JButton();
        btn22 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        wins = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        losses = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        ties = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setText("Please start a new game.");

        jButton1.setText("New Game");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Josh's Tic Tac Toe Board");

        btn00.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        btn00.setEnabled(false);
        btn00.setPreferredSize(new java.awt.Dimension(33, 33));
        btn00.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn00ActionPerformed(evt);
            }
        });

        btn10.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        btn10.setEnabled(false);
        btn10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn10ActionPerformed(evt);
            }
        });

        btn20.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        btn20.setEnabled(false);
        btn20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn20ActionPerformed(evt);
            }
        });

        btn11.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        btn11.setEnabled(false);
        btn11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn11ActionPerformed(evt);
            }
        });

        btn01.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        btn01.setEnabled(false);
        btn01.setPreferredSize(new java.awt.Dimension(33, 33));
        btn01.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn01ActionPerformed(evt);
            }
        });

        btn02.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        btn02.setEnabled(false);
        btn02.setMaximumSize(new java.awt.Dimension(33, 33));
        btn02.setMinimumSize(new java.awt.Dimension(33, 33));
        btn02.setPreferredSize(new java.awt.Dimension(33, 33));
        btn02.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn02ActionPerformed(evt);
            }
        });

        btn12.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        btn12.setEnabled(false);
        btn12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn12ActionPerformed(evt);
            }
        });

        btn21.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        btn21.setEnabled(false);
        btn21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn21ActionPerformed(evt);
            }
        });

        btn22.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        btn22.setEnabled(false);
        btn22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn22ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btn02, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btn01, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btn00, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn10, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn12, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn11, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn21, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn20, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn22, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn10, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn00, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn20, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn11, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn01, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn21, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn12, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn22, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn02, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Your Wins: ");

        wins.setText("0");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Your Losses:");

        losses.setText("0");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Ties:");

        ties.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(wins, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(losses, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ties, javax.swing.GroupLayout.DEFAULT_SIZE, 17, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 163, Short.MAX_VALUE)
                                .addComponent(jButton1)))
                        .addGap(11, 11, 11)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(1, 1, 1)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(wins)
                    .addComponent(jLabel5)
                    .addComponent(losses)
                    .addComponent(jLabel6)
                    .addComponent(ties))
                .addGap(11, 11, 11))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (!TcpMethods.send("josh:NEWGAMEREQ", 9875)) {
            jButton1.setEnabled(true);
        } else {
            jButton1.setEnabled(false);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btn00ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn00ActionPerformed
        // TODO add your handling code here:
        makeMove(btn00,0,0);
    }//GEN-LAST:event_btn00ActionPerformed

    private void btn10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn10ActionPerformed
        // TODO add your handling code here:
        makeMove(btn10,1,0);
    }//GEN-LAST:event_btn10ActionPerformed

    private void btn20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn20ActionPerformed
        // TODO add your handling code here:
        makeMove(btn20,2,0);
    }//GEN-LAST:event_btn20ActionPerformed

    private void btn01ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn01ActionPerformed
        // TODO add your handling code here:
        makeMove(btn01,0,1);
    }//GEN-LAST:event_btn01ActionPerformed

    private void btn11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn11ActionPerformed
        // TODO add your handling code here:
        makeMove(btn11,1,1);
    }//GEN-LAST:event_btn11ActionPerformed

    private void btn21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn21ActionPerformed
        // TODO add your handling code here:
        makeMove(btn21,2,1);
    }//GEN-LAST:event_btn21ActionPerformed

    private void btn02ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn02ActionPerformed
        // TODO add your handling code here:
        makeMove(btn02,0,2);
    }//GEN-LAST:event_btn02ActionPerformed

    private void btn12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn12ActionPerformed
        // TODO add your handling code here:
        makeMove(btn12,1,2);
    }//GEN-LAST:event_btn12ActionPerformed

    private void btn22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn22ActionPerformed
        // TODO add your handling code here:
        makeMove(btn22,2,2);
    }//GEN-LAST:event_btn22ActionPerformed
    public void setStats() {
        wins.setText(Integer.toString(board.getiWon()));
        losses.setText(Integer.toString(board.getiLost()));
        ties.setText(Integer.toString(board.getTies()));
    }
    private void makeMove(javax.swing.JButton btn, int x, int y) {
        if (btn.getText().equalsIgnoreCase(" ") && myTurn == true) {
            btn.setText(Character.toString(myPiece));
            TcpMethods.send("josh:PIECE:"+x+","+y+","+Character.toString(myPiece),9875);
            board.insertIntoBoard(myPiece, x, y);
            enableBoard(false);
            setMyTurn(false);
            setLabel2Text("Vlad's Turn");
            String result=board.checkGameOver(myPiece);
            if (!result.isEmpty()) {
                if (result.equalsIgnoreCase("TIE")) {
                    TcpMethods.send("GAMEOVER:TIE",9876);
                    TcpMethods.send("GAMEOVER:TIE",9875);
                } else {
                    TcpMethods.send("GAMEOVER:"+result+":"+x+","+y,9876);
                    TcpMethods.send("GAMEOVER:"+result+":"+x+","+y,9875);
                    markWinningPieces();
                }
            }
        }
    }
    public void markWinningPieces() {
        List coords = board.getWinningCoords();
        Iterator<String> iterator = coords.iterator();
        while (iterator.hasNext()) {
            String val = iterator.next();
            if (val.equalsIgnoreCase("0,0")) {
                btn00.setBackground(Color.red);
            } else if (val.equalsIgnoreCase("1,0")) {
                btn10.setBackground(Color.red);
            } else if (val.equalsIgnoreCase("2,0")) {
                btn20.setBackground(Color.red);
            } else if (val.equalsIgnoreCase("0,1")) {
                btn01.setBackground(Color.red);
            } else if (val.equalsIgnoreCase("0,2")) {
                btn02.setBackground(Color.red);
            } else if (val.equalsIgnoreCase("1,1")) {
                btn11.setBackground(Color.red);
            } else if (val.equalsIgnoreCase("1,2")) {
                btn12.setBackground(Color.red);
            } else if (val.equalsIgnoreCase("2,1")) {
                btn21.setBackground(Color.red);
            } else if (val.equalsIgnoreCase("2,2")) {
                btn22.setBackground(Color.red);
            }
        }
    }
    public void jButton1Enable(boolean s) {
        jButton1.setEnabled(s);
    }
    public void enableBoard(boolean s) {
        btn00.setEnabled(s);
        btn01.setEnabled(s);
        btn02.setEnabled(s);
        btn10.setEnabled(s);
        btn11.setEnabled(s);
        btn12.setEnabled(s);
        btn20.setEnabled(s);
        btn21.setEnabled(s);
        btn22.setEnabled(s);
    }
    public void resetBackgroundColor() {
        btn00.setBackground(new Color(240,240,240));
        btn10.setBackground(new Color(240,240,240));
        btn20.setBackground(new Color(240,240,240));
        btn01.setBackground(new Color(240,240,240));
        btn02.setBackground(new Color(240,240,240));
        btn11.setBackground(new Color(240,240,240));
        btn12.setBackground(new Color(240,240,240));
        btn21.setBackground(new Color(240,240,240));
        btn22.setBackground(new Color(240,240,240));
    }
    public void setLabel1Text(String str) {
        jLabel1.setText(str);
    }
    public void setLabel2Text(String str) {
        jLabel2.setText(str);
    }

    public void setBoardVals(char[][] table) {
        btn00.setText(Character.toString(table[0][0]));
        btn01.setText(Character.toString(table[0][1]));
        btn02.setText(Character.toString(table[0][2]));
        btn10.setText(Character.toString(table[1][0]));
        btn11.setText(Character.toString(table[1][1]));
        btn12.setText(Character.toString(table[1][2]));
        btn20.setText(Character.toString(table[2][0]));
        btn21.setText(Character.toString(table[2][1]));
        btn22.setText(Character.toString(table[2][2]));
    }
    public void setMyPiece(String c) {
        System.out.println("my piece is "+c);
        myPiece = c.charAt(0);
        System.out.println("my piece char is "+myPiece);
    }

    public char getMyPiece() {
        return myPiece;
    }
    public void setMyTurn(Boolean s) {
        myTurn = s;
    }
    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JoshTicTacToe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn00;
    private javax.swing.JButton btn01;
    private javax.swing.JButton btn02;
    private javax.swing.JButton btn10;
    private javax.swing.JButton btn11;
    private javax.swing.JButton btn12;
    private javax.swing.JButton btn20;
    private javax.swing.JButton btn21;
    private javax.swing.JButton btn22;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel losses;
    private javax.swing.JLabel ties;
    private javax.swing.JLabel wins;
    // End of variables declaration//GEN-END:variables

}
