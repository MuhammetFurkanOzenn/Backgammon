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
    //icon dizileri
    ImageIcon icons_right[];
    ImageIcon icons_left[];
    ImageIcon icons[];
    Random rand;

    /**
     * Creates new form Game
     */
    @SuppressWarnings("empty-statement")
    public Game() {
        initComponents();
        ThisGame = this;
        rand = new Random();

        
        //lbl_gamer1.setIcon(icons[0]);
        //lbl_gamer2.setIcon(icons[0]);
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
        lbl_backgammonBoard = new javax.swing.JLabel();

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

        lbl_backgammonBoard.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbl_backgammonBoard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_send, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                            .addComponent(txt_receive, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_send_message, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_connect)
                        .addGap(0, 412, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_connect))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(txt_receive, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                        .addComponent(txt_send, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_send_message))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(lbl_backgammonBoard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(87, 87, 87))
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
    }//GEN-LAST:event_btn_connectActionPerformed

    private void btn_send_messageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_send_messageActionPerformed

        //metin mesajı gönder
        Message msg = new Message(Message.Message_Type.Text);
        String x = txt_send.getText();
        msg.content = txt_send.getText();
        Player.Send(msg);
        txt_send.setText("");
    }//GEN-LAST:event_btn_send_messageActionPerformed

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
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Game().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_connect;
    public javax.swing.JButton btn_send_message;
    public javax.swing.JLabel lbl_backgammonBoard;
    public javax.swing.JTextField txt_name;
    public java.awt.TextArea txt_receive;
    public java.awt.TextArea txt_send;
    // End of variables declaration//GEN-END:variables
}
