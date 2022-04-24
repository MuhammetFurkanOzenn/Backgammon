/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.Image;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import backgammonplayer.Player;

/**
 *
 * @author Ozen
 */
public class Game extends javax.swing.JFrame {
    
    //framedeki komponentlere erişim için satatik oyun değişkeni
    public static Game ThisGame;
    //ekrandaki resim değişimi için timer yerine thread
    public Thread tmr_slider;
    //karşı tarafın seçimi seçim -1 deyse seçilmemiş
    public int RivalSelection = -1;
    //benim seçimim seçim -1 deyse seçilmemiş
    public int myselection = -1;
    // Images
    ImageIcon board[];
    Random rand;
    
    public void makeThemDisabled(){
        lbl_yourTurn.setVisible(false);
        
        
        
    }
    
    public void makeThemEnabled(){
        lbl_yourTurn.setVisible(true);
        btn_rollDies.setEnabled(true);
        btn_endTour.setEnabled(true);
    }
    /**
     * Creates new form Game
     */
    @SuppressWarnings("empty-statement")
    public Game() {
        initComponents();
        ThisGame = this;
        rand = new Random();
        try {
            board = new ImageIcon[1];
            board[0] = new ImageIcon(new ImageIcon(ImageIO.read(this.getClass().getClassLoader().getResource("game/images/board.png"))).getImage().getScaledInstance(lbl_board.getWidth(), lbl_board.getHeight(), Image.SCALE_DEFAULT));
        } catch (IOException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }

        lbl_board.setIcon(board[0]);
        // resimleri döndürmek için tread aynı zamanda oyun bitiminide takip ediyor
        tmr_slider = new Thread(() -> {
            //soket bağlıysa dönsün
            while (Player.socket.isConnected()) {
                try {
                    //
                    Thread.sleep(100);
                    //eğer ikisinden biri -1 ise resim dönmeye devam etsin sonucu göstermesin
                    if (RivalSelection == -1 || myselection == -1) {
                        int g = rand.nextInt(2);
                        //lbl_gamer2.setIcon(icons_right[g]);
                    }   // eğer iki seçim yapılmışsa sonuç gösterilebilir.  
                    else {

                        //lbl_gamer2.setIcon(icons_right[RivalSelection]);
                        //sonuç el olarak gösterildikten 4 saniye sonra smiley gelsin
                        Thread.sleep(4000);
                        //smiley sonuç resimleri
                        /*if (myselection == 0 && RivalSelection == 2) {
                            lbl_gamer1.setIcon(icons[2]);
                            lbl_gamer2.setIcon(icons[1]);
                        } else if (myselection < RivalSelection) {
                            lbl_gamer1.setIcon(icons[1]);
                            lbl_gamer2.setIcon(icons[2]);
                        } else if (myselection > RivalSelection) {
                            lbl_gamer1.setIcon(icons[2]);
                            lbl_gamer2.setIcon(icons[1]);
                        } else {
                            lbl_gamer1.setIcon(icons[3]);
                            lbl_gamer2.setIcon(icons[3]);
                        }*/
                        tmr_slider.stop();

                        //7 saniye sonra oyun bitsin tekrar bağlansın
                        Thread.sleep(7000);
                        Reset();

                    }
                } catch (InterruptedException ex) {
                    Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

    }

    public void Reset() {
        
        if (Player.socket != null) {
            if (Player.socket.isConnected()) {
                Player.Stop();
            }
        }
        btn_connect.setEnabled(true);
        txt_name.setEnabled(true);
        btn_send_message.setEnabled(false);
        btn_rollDies.setEnabled(false);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_connect = new javax.swing.JButton();
        txt_name = new javax.swing.JTextField();
        txt_send = new java.awt.TextArea();
        txt_receive = new java.awt.TextArea();
        btn_send_message = new javax.swing.JButton();
        lbl_board = new javax.swing.JLabel();
        lbl_rivalNameTitle = new javax.swing.JLabel();
        lbl_yourTurn = new javax.swing.JLabel();
        lbl_nameRival = new javax.swing.JLabel();
        lbl_die1 = new javax.swing.JLabel();
        lbl_die2 = new javax.swing.JLabel();
        btn_rollDies = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btn_endTour = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btn_connect.setText("Connect");
        btn_connect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_connectActionPerformed(evt);
            }
        });

        txt_name.setText("Name");
        txt_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nameActionPerformed(evt);
            }
        });

        txt_send.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        btn_send_message.setText("Send Message");
        btn_send_message.setEnabled(false);
        btn_send_message.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_send_messageActionPerformed(evt);
            }
        });

        lbl_rivalNameTitle.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_rivalNameTitle.setText("Rival Name: ");

        lbl_yourTurn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_yourTurn.setText("Your Turn!");
        lbl_yourTurn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lbl_yourTurn.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lbl_nameRival.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lbl_die1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        lbl_die1.setText("1");

        lbl_die2.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        lbl_die2.setText("6");

        btn_rollDies.setText("Roll");
        btn_rollDies.setEnabled(false);
        btn_rollDies.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_rollDiesActionPerformed(evt);
            }
        });

        jLabel1.setText("Die Result");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        btn_endTour.setText("End Of Tour");
        btn_endTour.setEnabled(false);
        btn_endTour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_endTourActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_connect)
                        .addGap(26, 26, 26)
                        .addComponent(lbl_rivalNameTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_nameRival, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(137, 137, 137)
                        .addComponent(lbl_yourTurn)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbl_board, javax.swing.GroupLayout.PREFERRED_SIZE, 934, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(40, 40, 40)
                                                .addComponent(txt_receive, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(41, 41, 41)
                                                .addComponent(txt_send, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btn_send_message, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btn_endTour, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(lbl_die1)
                                                .addGap(18, 18, 18)
                                                .addComponent(lbl_die2)))
                                        .addGap(32, 32, 32))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(btn_rollDies, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap())))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btn_connect)
                                .addComponent(lbl_rivalNameTitle)
                                .addComponent(lbl_nameRival, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(20, 20, 20))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbl_yourTurn)
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txt_receive, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_send, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_send_message)
                        .addGap(57, 57, 57)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_die2)
                            .addComponent(lbl_die1))
                        .addGap(74, 74, 74)
                        .addComponent(btn_rollDies)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_endTour))
                    .addComponent(lbl_board, javax.swing.GroupLayout.PREFERRED_SIZE, 763, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        txt_send.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nameActionPerformed

    private void btn_connectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_connectActionPerformed
        // TODO add your handling code here:
        Player.Start("127.0.0.1", 2000);
        btn_connect.setEnabled(false);
        txt_name.setEnabled(false);
        btn_send_message.setEnabled(false);
        btn_rollDies.setEnabled(false);
    }//GEN-LAST:event_btn_connectActionPerformed

    private void btn_send_messageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_send_messageActionPerformed

        //metin mesajı gönder
        Message msg = new Message(Message.Message_Type.Text);
        String x = txt_send.getText();
        msg.content = txt_send.getText();
        Player.Send(msg);
        txt_send.setText("");
    }//GEN-LAST:event_btn_send_messageActionPerformed

    private void btn_rollDiesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_rollDiesActionPerformed
        // TODO add your handling code here:
        // rand 0-6 two times
        Random rand = new Random();
        // it will return 0-5 random numbers
        int upperbound=6;
        int int_random1 = rand.nextInt(upperbound);
        //Die1 
        Message msg1 = new Message(Message.Message_Type.Die1);
        msg1.content = Integer.toString(++int_random1);    // 1-6 rnd number
        Player.Send(msg1);
        //Die1 
        int int_random2 = rand.nextInt(upperbound);
        Message msg2 = new Message(Message.Message_Type.Die2);
        msg2.content = Integer.toString(++int_random2);
        Player.Send(msg2);
        
        // update lbldie
        lbl_die1.setText(Integer.toString(int_random1));
        lbl_die2.setText(Integer.toString(int_random2));
        btn_rollDies.setEnabled(false);     // set Disabled when roll dies

        // maybe add rolling dies sound
    }//GEN-LAST:event_btn_rollDiesActionPerformed

    private void btn_endTourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_endTourActionPerformed
        // TODO add your handling code here:
        /*
            THERE IS A LOCK SYSTEM LIKE SEMAPHORE 
            EACH TOUR THE LOCK WILL BE FALSE when CLICK END OF TOUR BUTTON 
            
            WHEN THE BUTTON CLICK, OTHER PLAYERS LOCK WILL BE TRUE
            SO THE GAME WILL BE TURNED-BASED... BRILLIANT :)
        */
        
        btn_endTour.setEnabled(false);
        makeThemDisabled();
        
        // send something to activate other player's actions
        Message msg = new Message(Message.Message_Type.Turn);
        msg.content = "helloo"; // Not neccessary to send this
        Player.Send(msg);
        
    }//GEN-LAST:event_btn_endTourActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Game().setVisible(true);
                lbl_yourTurn.setVisible(false);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_connect;
    public javax.swing.JButton btn_endTour;
    public javax.swing.JButton btn_rollDies;
    public javax.swing.JButton btn_send_message;
    private javax.swing.JLabel jLabel1;
    public javax.swing.JLabel lbl_board;
    public javax.swing.JLabel lbl_die1;
    public javax.swing.JLabel lbl_die2;
    public javax.swing.JLabel lbl_nameRival;
    private javax.swing.JLabel lbl_rivalNameTitle;
    public static javax.swing.JLabel lbl_yourTurn;
    public javax.swing.JTextField txt_name;
    public java.awt.TextArea txt_receive;
    public java.awt.TextArea txt_send;
    // End of variables declaration//GEN-END:variables
}
