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
import javax.swing.JLabel;

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
    
    //GAME LOGIC
    //*
    public int[] arrayBlack = {-1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 0, 0, 0, 3, 0, 5, 0, 0, 0, 0, 0};     // 1'st player's checkers
    public int[] arrayWhite = {-1, 0, 0, 0, 0, 0, 5, 0, 3, 0, 0, 0, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2};     // 2'nd player's checkers
   // public javax.swing.JLabel[] arrayLabels = {lbl_noC1};
    
    //JLabel[] lbls = {lbl_yourTurn, lbl_noC24};
    //l[1] = lbl_coC1;
    /*
    public void testLabelArray(){
        System.out.println("testing testing...");
        lbls[1].setText("test success!");
    }*/
    
    // its makes enable btn if checkers on this part
    public void activateButtonsBlack(){
        if(arrayBlack[1] > 0){btn_chs1.setEnabled(true);}
        if(arrayBlack[2] > 0){btn_chs2.setEnabled(true);}
        if(arrayBlack[3] > 0){btn_chs3.setEnabled(true);}
        if(arrayBlack[4] > 0){btn_chs4.setEnabled(true);}
        if(arrayBlack[5] > 0){btn_chs5.setEnabled(true);}
        if(arrayBlack[6] > 0){btn_chs6.setEnabled(true);}
        if(arrayBlack[7] > 0){btn_chs7.setEnabled(true);}
        if(arrayBlack[8] > 0){btn_chs8.setEnabled(true);}
        if(arrayBlack[9] > 0){btn_chs9.setEnabled(true);}
        if(arrayBlack[10] > 0){btn_chs10.setEnabled(true);}
        if(arrayBlack[11] > 0){btn_chs11.setEnabled(true);}
        if(arrayBlack[12] > 0){btn_chs12.setEnabled(true);}
        if(arrayBlack[13] > 0){btn_chs13.setEnabled(true);}
        if(arrayBlack[14] > 0){btn_chs14.setEnabled(true);}
        if(arrayBlack[15] > 0){btn_chs15.setEnabled(true);}
        if(arrayBlack[16] > 0){btn_chs16.setEnabled(true);}
        if(arrayBlack[17] > 0){btn_chs17.setEnabled(true);}
        if(arrayBlack[18] > 0){btn_chs18.setEnabled(true);}
        if(arrayBlack[19] > 0){btn_chs19.setEnabled(true);}
        if(arrayBlack[20] > 0){btn_chs20.setEnabled(true);}
        if(arrayBlack[21] > 0){btn_chs21.setEnabled(true);}
        if(arrayBlack[22] > 0){btn_chs22.setEnabled(true);}
        if(arrayBlack[23] > 0){btn_chs23.setEnabled(true);}
        if(arrayBlack[24] > 0){btn_chs24.setEnabled(true);}  
    }
    // its makes enable if btn checkers on this part
    public void activateButtonsWhite(){     
        if(arrayWhite[1] > 0){btn_chs1.setEnabled(true);}
        if(arrayWhite[2] > 0){btn_chs2.setEnabled(true);}
        if(arrayWhite[3] > 0){btn_chs3.setEnabled(true);}
        if(arrayWhite[4] > 0){btn_chs4.setEnabled(true);}
        if(arrayWhite[5] > 0){btn_chs5.setEnabled(true);}
        if(arrayWhite[6] > 0){btn_chs6.setEnabled(true);}
        if(arrayWhite[7] > 0){btn_chs7.setEnabled(true);}
        if(arrayWhite[8] > 0){btn_chs8.setEnabled(true);}
        if(arrayWhite[9] > 0){btn_chs9.setEnabled(true);}
        if(arrayWhite[10] > 0){btn_chs10.setEnabled(true);}
        if(arrayWhite[11] > 0){btn_chs11.setEnabled(true);}
        if(arrayWhite[12] > 0){btn_chs12.setEnabled(true);}
        if(arrayWhite[13] > 0){btn_chs13.setEnabled(true);}
        if(arrayWhite[14] > 0){btn_chs14.setEnabled(true);}
        if(arrayWhite[15] > 0){btn_chs15.setEnabled(true);}
        if(arrayWhite[16] > 0){btn_chs16.setEnabled(true);}
        if(arrayWhite[17] > 0){btn_chs17.setEnabled(true);}
        if(arrayWhite[18] > 0){btn_chs18.setEnabled(true);}
        if(arrayWhite[19] > 0){btn_chs19.setEnabled(true);}
        if(arrayWhite[20] > 0){btn_chs20.setEnabled(true);}
        if(arrayWhite[21] > 0){btn_chs21.setEnabled(true);}
        if(arrayWhite[22] > 0){btn_chs22.setEnabled(true);}
        if(arrayWhite[23] > 0){btn_chs23.setEnabled(true);}
        if(arrayWhite[24] > 0){btn_chs24.setEnabled(true);}  
    }
    
    public void activateButtons(){
        btn_chs1.setEnabled(true);
        btn_chs2.setEnabled(true);
        btn_chs3.setEnabled(true);
        btn_chs4.setEnabled(true);
        btn_chs5.setEnabled(true);
        btn_chs6.setEnabled(true);
        btn_chs7.setEnabled(true);
        btn_chs8.setEnabled(true);
        btn_chs9.setEnabled(true);
        btn_chs10.setEnabled(true);
        btn_chs11.setEnabled(true);
        btn_chs12.setEnabled(true);
        btn_chs13.setEnabled(true);
        btn_chs14.setEnabled(true);
        btn_chs15.setEnabled(true);
        btn_chs16.setEnabled(true);
        btn_chs17.setEnabled(true);
        btn_chs18.setEnabled(true);
        btn_chs19.setEnabled(true);
        btn_chs20.setEnabled(true);
        btn_chs21.setEnabled(true);
        btn_chs22.setEnabled(true);
        btn_chs23.setEnabled(true);
        btn_chs24.setEnabled(true);
    }
    
    public void deactivateButtons(){
        btn_chs1.setEnabled(false);
        btn_chs2.setEnabled(false);
        btn_chs3.setEnabled(false);
        btn_chs4.setEnabled(false);
        btn_chs5.setEnabled(false);
        btn_chs6.setEnabled(false);
        btn_chs7.setEnabled(false);
        btn_chs8.setEnabled(false);
        btn_chs9.setEnabled(false);
        btn_chs10.setEnabled(false);
        btn_chs11.setEnabled(false);
        btn_chs12.setEnabled(false);
        btn_chs13.setEnabled(false);
        btn_chs14.setEnabled(false);
        btn_chs15.setEnabled(false);
        btn_chs16.setEnabled(false);
        btn_chs17.setEnabled(false);
        btn_chs18.setEnabled(false);
        btn_chs19.setEnabled(false);
        btn_chs20.setEnabled(false);
        btn_chs21.setEnabled(false);
        btn_chs22.setEnabled(false);
        btn_chs23.setEnabled(false);
        btn_chs24.setEnabled(false);
    }
    
    
    public void updateCheckers(){
        
        // updates number of checkers
        if (arrayBlack[1]>arrayWhite[1]){lbl_noC1.setText(Integer.toString(arrayBlack[1]));}else {lbl_noC1.setText(Integer.toString(arrayBlack[1]));}
        if (arrayBlack[2]>arrayWhite[2]){lbl_noC2.setText(Integer.toString(arrayBlack[2]));}else {lbl_noC2.setText(Integer.toString(arrayBlack[2]));}
        if (arrayBlack[3]>arrayWhite[3]){lbl_noC3.setText(Integer.toString(arrayBlack[3]));}else {lbl_noC3.setText(Integer.toString(arrayBlack[3]));}
        if (arrayBlack[4]>arrayWhite[4]){lbl_noC4.setText(Integer.toString(arrayBlack[4]));}else {lbl_noC4.setText(Integer.toString(arrayBlack[4]));}
        if (arrayBlack[5]>arrayWhite[5]){lbl_noC5.setText(Integer.toString(arrayBlack[5]));}else {lbl_noC5.setText(Integer.toString(arrayBlack[5]));}
        if (arrayBlack[6]>arrayWhite[6]){lbl_noC6.setText(Integer.toString(arrayBlack[6]));}else {lbl_noC6.setText(Integer.toString(arrayBlack[6]));}
        if (arrayBlack[7]>arrayWhite[7]){lbl_noC7.setText(Integer.toString(arrayBlack[7]));}else {lbl_noC7.setText(Integer.toString(arrayBlack[7]));}
        if (arrayBlack[8]>arrayWhite[8]){lbl_noC8.setText(Integer.toString(arrayBlack[8]));}else {lbl_noC8.setText(Integer.toString(arrayBlack[8]));}
        if (arrayBlack[9]>arrayWhite[9]){lbl_noC9.setText(Integer.toString(arrayBlack[9]));}else {lbl_noC9.setText(Integer.toString(arrayBlack[9]));}
        if (arrayBlack[10]>arrayWhite[10]){lbl_noC10.setText(Integer.toString(arrayBlack[10]));}else {lbl_noC10.setText(Integer.toString(arrayBlack[10]));}
        if (arrayBlack[11]>arrayWhite[11]){lbl_noC11.setText(Integer.toString(arrayBlack[11]));}else {lbl_noC11.setText(Integer.toString(arrayBlack[11]));}
        if (arrayBlack[12]>arrayWhite[12]){lbl_noC12.setText(Integer.toString(arrayBlack[12]));}else {lbl_noC12.setText(Integer.toString(arrayBlack[12]));}
        if (arrayBlack[13]>arrayWhite[13]){lbl_noC13.setText(Integer.toString(arrayBlack[13]));}else {lbl_noC13.setText(Integer.toString(arrayBlack[13]));}
        if (arrayBlack[14]>arrayWhite[14]){lbl_noC14.setText(Integer.toString(arrayBlack[14]));}else {lbl_noC14.setText(Integer.toString(arrayBlack[14]));}
        if (arrayBlack[15]>arrayWhite[15]){lbl_noC15.setText(Integer.toString(arrayBlack[15]));}else {lbl_noC15.setText(Integer.toString(arrayBlack[15]));}
        if (arrayBlack[16]>arrayWhite[16]){lbl_noC16.setText(Integer.toString(arrayBlack[16]));}else {lbl_noC16.setText(Integer.toString(arrayBlack[16]));}
        if (arrayBlack[17]>arrayWhite[17]){lbl_noC17.setText(Integer.toString(arrayBlack[17]));}else {lbl_noC17.setText(Integer.toString(arrayBlack[17]));}
        if (arrayBlack[18]>arrayWhite[18]){lbl_noC18.setText(Integer.toString(arrayBlack[18]));}else {lbl_noC18.setText(Integer.toString(arrayBlack[18]));}
        if (arrayBlack[19]>arrayWhite[19]){lbl_noC19.setText(Integer.toString(arrayBlack[19]));}else {lbl_noC19.setText(Integer.toString(arrayBlack[19]));}
        if (arrayBlack[20]>arrayWhite[20]){lbl_noC20.setText(Integer.toString(arrayBlack[20]));}else {lbl_noC20.setText(Integer.toString(arrayBlack[20]));}
        if (arrayBlack[21]>arrayWhite[21]){lbl_noC21.setText(Integer.toString(arrayBlack[21]));}else {lbl_noC21.setText(Integer.toString(arrayBlack[21]));}
        if (arrayBlack[22]>arrayWhite[22]){lbl_noC22.setText(Integer.toString(arrayBlack[22]));}else {lbl_noC22.setText(Integer.toString(arrayBlack[22]));}
        if (arrayBlack[23]>arrayWhite[23]){lbl_noC23.setText(Integer.toString(arrayBlack[23]));}else {lbl_noC23.setText(Integer.toString(arrayBlack[23]));}
        if (arrayBlack[24]>arrayWhite[24]){lbl_noC24.setText(Integer.toString(arrayBlack[24]));}else {lbl_noC24.setText(Integer.toString(arrayBlack[24]));}
        
        /*
        lbl_noC1.setText(Integer.toString(arrayBlack[1]));
        lbl_noC2.setText(Integer.toString(arrayBlack[2]));
        lbl_noC3.setText(Integer.toString(arrayBlack[3]));
        lbl_noC4.setText(Integer.toString(arrayBlack[4]));
        lbl_noC5.setText(Integer.toString(arrayBlack[5]));
        lbl_noC6.setText(Integer.toString(arrayBlack[6]));
        lbl_noC7.setText(Integer.toString(arrayBlack[7]));
        lbl_noC8.setText(Integer.toString(arrayBlack[8]));
        lbl_noC9.setText(Integer.toString(arrayBlack[9]));
        lbl_noC1.setText(Integer.toString(arrayBlack[10]));
        lbl_noC11.setText(Integer.toString(arrayBlack[11]));
        lbl_noC12.setText(Integer.toString(arrayBlack[12]));
        lbl_noC13.setText(Integer.toString(arrayBlack[13]));
        lbl_noC14.setText(Integer.toString(arrayBlack[14]));
        lbl_noC15.setText(Integer.toString(arrayBlack[15]));
        lbl_noC16.setText(Integer.toString(arrayBlack[16]));
        lbl_noC17.setText(Integer.toString(arrayBlack[17]));
        lbl_noC18.setText(Integer.toString(arrayBlack[18]));
        lbl_noC19.setText(Integer.toString(arrayBlack[19]));
        lbl_noC20.setText(Integer.toString(arrayBlack[20]));
        lbl_noC21.setText(Integer.toString(arrayBlack[21]));
        lbl_noC22.setText(Integer.toString(arrayBlack[22]));
        lbl_noC23.setText(Integer.toString(arrayBlack[23]));
        lbl_noC24.setText(Integer.toString(arrayBlack[24]));
        */
        
        // updates color of checkers
        if (arrayBlack[1] > 0){
            lbl_coC1.setText("B");
        }else if (arrayWhite[1] > 0){
            lbl_coC1.setText("W");
        }else {
            lbl_coC1.setText("");
        }
        
        if (arrayBlack[2] > 0){
            lbl_coC2.setText("B");
        }else if (arrayWhite[2] > 0){
            lbl_coC2.setText("W");
        }else {
            lbl_coC2.setText("");
        }
        
        if (arrayBlack[3] > 0){
            lbl_coC3.setText("B");
        }else if (arrayWhite[3] > 0){
            lbl_coC3.setText("W");
        }else {
            lbl_coC3.setText("");
        }
        
        if (arrayBlack[3] > 0){
            lbl_coC3.setText("B");
        }else if (arrayWhite[3] > 0){
            lbl_coC3.setText("W");
        }else {
            lbl_coC3.setText("");
        }
        
        if (arrayBlack[4] > 0){
            lbl_coC4.setText("B");
        }else if (arrayWhite[4] > 0){
            lbl_coC4.setText("W");
        }else {
            lbl_coC4.setText("");
        }
        
        if (arrayBlack[5] > 0){
            lbl_coC5.setText("B");
        }else if (arrayWhite[5] > 0){
            lbl_coC5.setText("W");
        }else {
            lbl_coC5.setText("");
        }
        
        if (arrayBlack[6] > 0){
            lbl_coC6.setText("B");
        }else if (arrayWhite[6] > 0){
            lbl_coC6.setText("W");
        }else {
            lbl_coC6.setText("");
        }
        
        if (arrayBlack[7] > 0){
            lbl_coC7.setText("B");
        }else if (arrayWhite[7] > 0){
            lbl_coC7.setText("W");
        }else {
            lbl_coC7.setText("");
        }
        
        if (arrayBlack[8] > 0){
            lbl_coC8.setText("B");
        }else if (arrayWhite[8] > 0){
            lbl_coC8.setText("W");
        }else {
            lbl_coC8.setText("");
        }
        
        if (arrayBlack[9] > 0){
            lbl_coC9.setText("B");
        }else if (arrayWhite[9] > 0){
            lbl_coC9.setText("W");
        }else {
            lbl_coC9.setText("");
        }
        
        if (arrayBlack[10] > 0){
            lbl_coC10.setText("B");
        }else if (arrayWhite[10] > 0){
            lbl_coC10.setText("W");
        }else {
            lbl_coC10.setText("");
        }
        
        if (arrayBlack[11] > 0){
            lbl_coC11.setText("B");
        }else if (arrayWhite[11] > 0){
            lbl_coC11.setText("W");
        }else {
            lbl_coC11.setText("");
        }
        
        if (arrayBlack[12] > 0){
            lbl_coC12.setText("B");
        }else if (arrayWhite[12] > 0){
            lbl_coC12.setText("W");
        }else {
            lbl_coC12.setText("");
        }
        
        if (arrayBlack[13] > 0){
            lbl_coC13.setText("B");
        }else if (arrayWhite[13] > 0){
            lbl_coC13.setText("W");
        }else {
            lbl_coC13.setText("");
        }
        
        if (arrayBlack[14] > 0){
            lbl_coC14.setText("B");
        }else if (arrayWhite[14] > 0){
            lbl_coC14.setText("W");
        }else {
            lbl_coC14.setText("");
        }
        
        if (arrayBlack[15] > 0){
            lbl_coC15.setText("B");
        }else if (arrayWhite[15] > 0){
            lbl_coC15.setText("W");
        }else {
            lbl_coC15.setText("");
        }
        
        if (arrayBlack[16] > 0){
            lbl_coC16.setText("B");
        }else if (arrayWhite[16] > 0){
            lbl_coC16.setText("W");
        }else {
            lbl_coC16.setText("");
        }
        
        if (arrayBlack[17] > 0){
            lbl_coC17.setText("B");
        }else if (arrayWhite[17] > 0){
            lbl_coC17.setText("W");
        }else {
            lbl_coC17.setText("");
        }
        
        if (arrayBlack[18] > 0){
            lbl_coC18.setText("B");
        }else if (arrayWhite[18] > 0){
            lbl_coC18.setText("W");
        }else {
            lbl_coC18.setText("");
        }
        
        if (arrayBlack[19] > 0){
            lbl_coC19.setText("B");
        }else if (arrayWhite[19] > 0){
            lbl_coC19.setText("W");
        }else {
            lbl_coC19.setText("");
        }
        
        if (arrayBlack[20] > 0){
            lbl_coC20.setText("B");
        }else if (arrayWhite[20] > 0){
            lbl_coC20.setText("W");
        }else {
            lbl_coC20.setText("");
        }
        
        if (arrayBlack[21] > 0){
            lbl_coC21.setText("B");
        }else if (arrayWhite[21] > 0){
            lbl_coC21.setText("W");
        }else {
            lbl_coC21.setText("");
        }
        
        if (arrayBlack[22] > 0){
            lbl_coC22.setText("B");
        }else if (arrayWhite[22] > 0){
            lbl_coC22.setText("W");
        }else {
            lbl_coC22.setText("");
        }
         
        if (arrayBlack[23] > 0){
            lbl_coC23.setText("B");
        }else if (arrayWhite[23] > 0){
            lbl_coC23.setText("W");
        }else {
            lbl_coC23.setText("");
        }
          
        if (arrayBlack[24] > 0){
            lbl_coC24.setText("B");
        }else if (arrayWhite[24] > 0){
            lbl_coC24.setText("W");
        }else {
            lbl_coC24.setText("");
        }
        
        /*
        lbl_coC2.setText(Integer.toString(arrayBlack[2]));
        lbl_coC3.setText(Integer.toString(arrayBlack[3]));
        lbl_coC4.setText(Integer.toString(arrayBlack[4]));
        lbl_coC5.setText(Integer.toString(arrayBlack[5]));
        lbl_coC6.setText(Integer.toString(arrayBlack[6]));
        lbl_coC7.setText(Integer.toString(arrayBlack[7]));
        lbl_coC8.setText(Integer.toString(arrayBlack[8]));
        lbl_coC9.setText(Integer.toString(arrayBlack[9]));
        lbl_coC1.setText(Integer.toString(arrayBlack[10]));
        lbl_coC11.setText(Integer.toString(arrayBlack[11]));
        lbl_coC12.setText(Integer.toString(arrayBlack[12]));
        lbl_coC13.setText(Integer.toString(arrayBlack[13]));
        lbl_coC14.setText(Integer.toString(arrayBlack[14]));
        lbl_coC15.setText(Integer.toString(arrayBlack[15]));
        lbl_coC16.setText(Integer.toString(arrayBlack[16]));
        lbl_coC17.setText(Integer.toString(arrayBlack[17]));
        lbl_coC18.setText(Integer.toString(arrayBlack[18]));
        lbl_coC19.setText(Integer.toString(arrayBlack[19]));
        lbl_coC20.setText(Integer.toString(arrayBlack[20]));
        lbl_coC21.setText(Integer.toString(arrayBlack[21]));
        lbl_coC22.setText(Integer.toString(arrayBlack[22]));
        lbl_coC23.setText(Integer.toString(arrayBlack[23]));
        lbl_coC24.setText(Integer.toString(arrayBlack[24]));
        */
    }
        
    
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
        btn_chs11 = new javax.swing.JButton();
        btn_chs10 = new javax.swing.JButton();
        btn_chs9 = new javax.swing.JButton();
        btn_chs12 = new javax.swing.JButton();
        btn_chs8 = new javax.swing.JButton();
        btn_chs7 = new javax.swing.JButton();
        btn_chs6 = new javax.swing.JButton();
        btn_chs5 = new javax.swing.JButton();
        btn_chs4 = new javax.swing.JButton();
        btn_chs3 = new javax.swing.JButton();
        btn_chs2 = new javax.swing.JButton();
        btn_chs1 = new javax.swing.JButton();
        lbl_noC12 = new javax.swing.JLabel();
        lbl_noC11 = new javax.swing.JLabel();
        lbl_noC10 = new javax.swing.JLabel();
        lbl_noC9 = new javax.swing.JLabel();
        lbl_noC8 = new javax.swing.JLabel();
        lbl_noC7 = new javax.swing.JLabel();
        lbl_noC5 = new javax.swing.JLabel();
        lbl_noC6 = new javax.swing.JLabel();
        lbl_noC4 = new javax.swing.JLabel();
        lbl_noC3 = new javax.swing.JLabel();
        lbl_noC2 = new javax.swing.JLabel();
        lbl_noC1 = new javax.swing.JLabel();
        lbl_coC12 = new javax.swing.JLabel();
        lbl_coC11 = new javax.swing.JLabel();
        lbl_coC10 = new javax.swing.JLabel();
        lbl_coC9 = new javax.swing.JLabel();
        lbl_coC8 = new javax.swing.JLabel();
        lbl_coC7 = new javax.swing.JLabel();
        lbl_coC6 = new javax.swing.JLabel();
        lbl_coC5 = new javax.swing.JLabel();
        lbl_coC4 = new javax.swing.JLabel();
        lbl_coC3 = new javax.swing.JLabel();
        lbl_coC2 = new javax.swing.JLabel();
        lbl_coC1 = new javax.swing.JLabel();
        btn_chs20 = new javax.swing.JButton();
        btn_chs21 = new javax.swing.JButton();
        btn_chs22 = new javax.swing.JButton();
        btn_chs23 = new javax.swing.JButton();
        btn_chs24 = new javax.swing.JButton();
        btn_chs14 = new javax.swing.JButton();
        btn_chs15 = new javax.swing.JButton();
        btn_chs16 = new javax.swing.JButton();
        btn_chs13 = new javax.swing.JButton();
        btn_chs17 = new javax.swing.JButton();
        btn_chs18 = new javax.swing.JButton();
        btn_chs19 = new javax.swing.JButton();
        lbl_noC13 = new javax.swing.JLabel();
        lbl_noC14 = new javax.swing.JLabel();
        lbl_noC15 = new javax.swing.JLabel();
        lbl_noC16 = new javax.swing.JLabel();
        lbl_noC17 = new javax.swing.JLabel();
        lbl_noC18 = new javax.swing.JLabel();
        lbl_noC20 = new javax.swing.JLabel();
        lbl_noC19 = new javax.swing.JLabel();
        lbl_noC21 = new javax.swing.JLabel();
        lbl_noC22 = new javax.swing.JLabel();
        lbl_noC23 = new javax.swing.JLabel();
        lbl_noC24 = new javax.swing.JLabel();
        lbl_coC13 = new javax.swing.JLabel();
        lbl_coC14 = new javax.swing.JLabel();
        lbl_coC15 = new javax.swing.JLabel();
        lbl_coC16 = new javax.swing.JLabel();
        lbl_coC24 = new javax.swing.JLabel();
        lbl_coC18 = new javax.swing.JLabel();
        lbl_coC17 = new javax.swing.JLabel();
        lbl_coC20 = new javax.swing.JLabel();
        lbl_coC21 = new javax.swing.JLabel();
        lbl_coC22 = new javax.swing.JLabel();
        lbl_coC23 = new javax.swing.JLabel();
        lbl_coC19 = new javax.swing.JLabel();
        txt_ip = new javax.swing.JTextField();

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

        btn_chs11.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_chs11.setEnabled(false);

        btn_chs10.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_chs10.setEnabled(false);

        btn_chs9.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_chs9.setEnabled(false);

        btn_chs12.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_chs12.setEnabled(false);

        btn_chs8.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_chs8.setEnabled(false);

        btn_chs7.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_chs7.setEnabled(false);

        btn_chs6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_chs6.setEnabled(false);

        btn_chs5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_chs5.setEnabled(false);

        btn_chs4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_chs4.setEnabled(false);

        btn_chs3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_chs3.setEnabled(false);

        btn_chs2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_chs2.setEnabled(false);

        btn_chs1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_chs1.setEnabled(false);
        btn_chs1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_chs1ActionPerformed(evt);
            }
        });

        lbl_noC12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_noC12.setText("5");

        lbl_noC11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_noC11.setText("0");

        lbl_noC10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_noC10.setText("0");

        lbl_noC9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_noC9.setText("0");

        lbl_noC8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_noC8.setText("3");

        lbl_noC7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_noC7.setText("0");

        lbl_noC5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_noC5.setText("0");

        lbl_noC6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_noC6.setText("5");

        lbl_noC4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_noC4.setText("0");

        lbl_noC3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_noC3.setText("0");

        lbl_noC2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_noC2.setText("0");

        lbl_noC1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_noC1.setText("2");

        lbl_coC12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_coC12.setText("b");

        lbl_coC11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_coC11.setText("x");

        lbl_coC10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_coC10.setText("x");

        lbl_coC9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_coC9.setText("x");

        lbl_coC8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_coC8.setText("w");

        lbl_coC7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_coC7.setText("x");

        lbl_coC6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_coC6.setText("w");

        lbl_coC5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_coC5.setText("x");

        lbl_coC4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_coC4.setText("x");

        lbl_coC3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_coC3.setText("x");

        lbl_coC2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_coC2.setText("x");

        lbl_coC1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_coC1.setText("b");

        btn_chs20.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_chs20.setEnabled(false);

        btn_chs21.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_chs21.setEnabled(false);

        btn_chs22.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_chs22.setEnabled(false);

        btn_chs23.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_chs23.setEnabled(false);

        btn_chs24.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_chs24.setEnabled(false);

        btn_chs14.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_chs14.setEnabled(false);

        btn_chs15.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_chs15.setEnabled(false);

        btn_chs16.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_chs16.setEnabled(false);

        btn_chs13.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_chs13.setEnabled(false);

        btn_chs17.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_chs17.setEnabled(false);

        btn_chs18.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_chs18.setEnabled(false);

        btn_chs19.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_chs19.setEnabled(false);

        lbl_noC13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_noC13.setText("5");

        lbl_noC14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_noC14.setText("0");

        lbl_noC15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_noC15.setText("0");

        lbl_noC16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_noC16.setText("0");

        lbl_noC17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_noC17.setText("3");

        lbl_noC18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_noC18.setText("0");

        lbl_noC20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_noC20.setText("0");

        lbl_noC19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_noC19.setText("5");

        lbl_noC21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_noC21.setText("0");

        lbl_noC22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_noC22.setText("0");

        lbl_noC23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_noC23.setText("0");

        lbl_noC24.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_noC24.setText("2");

        lbl_coC13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_coC13.setText("w");

        lbl_coC14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_coC14.setText("x");

        lbl_coC15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_coC15.setText("x");

        lbl_coC16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_coC16.setText("x");

        lbl_coC24.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_coC24.setText("w");

        lbl_coC18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_coC18.setText("x");

        lbl_coC17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_coC17.setText("b");

        lbl_coC20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_coC20.setText("x");

        lbl_coC21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_coC21.setText("x");

        lbl_coC22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_coC22.setText("x");

        lbl_coC23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_coC23.setText("x");

        lbl_coC19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_coC19.setText("b");

        txt_ip.setText("127.0.0.1");
        txt_ip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_ipActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbl_board, javax.swing.GroupLayout.PREFERRED_SIZE, 934, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbl_noC13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_chs13, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_coC13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbl_coC14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_chs14, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_noC14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_chs15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_noC15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_coC15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_chs16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_noC16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_coC16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_chs17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_noC17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_coC17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_chs18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_noC18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_coC18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(59, 59, 59)
                                    .addComponent(btn_chs19, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lbl_noC19, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(76, 76, 76)
                                .addComponent(lbl_coC19, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbl_coC20, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_noC20, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_chs20, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_chs21, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_noC21, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_coC21, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_chs22, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_noC22, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_coC22, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_chs23, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_noC23, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_coC23, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_chs24, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_noC24, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_coC24, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(txt_ip, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_connect)
                        .addGap(26, 26, 26)
                        .addComponent(lbl_rivalNameTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_nameRival, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(lbl_yourTurn)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(txt_receive, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(txt_send, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_send_message, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_endTour, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lbl_die1)
                                        .addGap(18, 18, 18)
                                        .addComponent(lbl_die2)))
                                .addGap(22, 22, 22))
                            .addComponent(btn_rollDies, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbl_coC12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_noC12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_chs12, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbl_coC11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_chs11, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_noC11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbl_coC10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_chs10, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_noC10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbl_coC9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_chs9, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_noC9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbl_coC8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_chs8, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_noC8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbl_coC7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_chs7, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_noC7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbl_coC6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_noC6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_chs6, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbl_coC5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_chs5, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_noC5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbl_coC4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_chs4, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_noC4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbl_coC3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_chs3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_noC3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbl_coC2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_chs2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_noC2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_chs1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_noC1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_coC1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_connect)
                        .addComponent(lbl_rivalNameTitle)
                        .addComponent(lbl_nameRival, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_ip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbl_yourTurn))
                .addGap(15, 15, 15)
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
                        .addComponent(btn_endTour)
                        .addGap(82, 82, 82))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_coC13)
                            .addComponent(lbl_coC24)
                            .addComponent(lbl_coC19)
                            .addComponent(lbl_coC23)
                            .addComponent(lbl_coC22)
                            .addComponent(lbl_coC21)
                            .addComponent(lbl_coC20)
                            .addComponent(lbl_coC18)
                            .addComponent(lbl_coC17)
                            .addComponent(lbl_coC16)
                            .addComponent(lbl_coC15)
                            .addComponent(lbl_coC14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_noC13)
                            .addComponent(lbl_noC14)
                            .addComponent(lbl_noC15)
                            .addComponent(lbl_noC16)
                            .addComponent(lbl_noC17)
                            .addComponent(lbl_noC18)
                            .addComponent(lbl_noC19)
                            .addComponent(lbl_noC20)
                            .addComponent(lbl_noC21)
                            .addComponent(lbl_noC22)
                            .addComponent(lbl_noC23)
                            .addComponent(lbl_noC24))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_chs14, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_chs15, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_chs16, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_chs13, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_chs17, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_chs18, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_chs19, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_chs20, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_chs21, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_chs22, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_chs23, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_chs24, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbl_board, javax.swing.GroupLayout.PREFERRED_SIZE, 654, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_chs11, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_chs10, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_chs9, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_chs12, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_chs8, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_chs7, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_chs6, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_chs5, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_chs4, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_chs3, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_chs2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_chs1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_noC12)
                            .addComponent(lbl_noC11)
                            .addComponent(lbl_noC10)
                            .addComponent(lbl_noC9)
                            .addComponent(lbl_noC8)
                            .addComponent(lbl_noC7)
                            .addComponent(lbl_noC5)
                            .addComponent(lbl_noC6)
                            .addComponent(lbl_noC4)
                            .addComponent(lbl_noC3)
                            .addComponent(lbl_noC2)
                            .addComponent(lbl_noC1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_coC12)
                            .addComponent(lbl_coC11)
                            .addComponent(lbl_coC10)
                            .addComponent(lbl_coC9)
                            .addComponent(lbl_coC8)
                            .addComponent(lbl_coC7)
                            .addComponent(lbl_coC5)
                            .addComponent(lbl_coC6)
                            .addComponent(lbl_coC4)
                            .addComponent(lbl_coC3)
                            .addComponent(lbl_coC2)
                            .addComponent(lbl_coC1))
                        .addContainerGap(40, Short.MAX_VALUE))))
        );

        txt_send.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nameActionPerformed

    private void btn_connectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_connectActionPerformed
        // TODO add your handling code here:
        String ip = txt_ip.getText().toString();
        Player.Start(ip, 2000);
        btn_connect.setEnabled(false);
        txt_name.setEnabled(false);
        txt_ip.setEnabled(false);
        btn_send_message.setEnabled(false);
        btn_rollDies.setEnabled(false);
    }//GEN-LAST:event_btn_connectActionPerformed

    private void btn_send_messageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_send_messageActionPerformed
        
        // test :( didnt work :(
        // testLabelArray();
        //metin mesajı gönder
        Message msg = new Message(Message.Message_Type.Text);
        String x = txt_send.getText();
        msg.content = txt_send.getText();
        Player.Send(msg);
        txt_send.setText("");
    }//GEN-LAST:event_btn_send_messageActionPerformed

    private void btn_rollDiesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_rollDiesActionPerformed
        // TODO add your handling code here:
        
        // Activate Choose Buttons
        //activateButtons();
        activateButtonsBlack();
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
        updateCheckers();
        btn_endTour.setEnabled(false);
        makeThemDisabled();
        
        // Deactivate Choose Buttons
        deactivateButtons();
        
        // send something to activate other player's actions
        Message msg = new Message(Message.Message_Type.Turn);
        msg.content = "helloo"; // Not neccessary to send this
        Player.Send(msg);
        
    }//GEN-LAST:event_btn_endTourActionPerformed

    private void btn_chs1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_chs1ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_btn_chs1ActionPerformed

    private void txt_ipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_ipActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_ipActionPerformed

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
    private javax.swing.JButton btn_chs1;
    private javax.swing.JButton btn_chs10;
    private javax.swing.JButton btn_chs11;
    private javax.swing.JButton btn_chs12;
    private javax.swing.JButton btn_chs13;
    private javax.swing.JButton btn_chs14;
    private javax.swing.JButton btn_chs15;
    private javax.swing.JButton btn_chs16;
    private javax.swing.JButton btn_chs17;
    private javax.swing.JButton btn_chs18;
    private javax.swing.JButton btn_chs19;
    private javax.swing.JButton btn_chs2;
    private javax.swing.JButton btn_chs20;
    private javax.swing.JButton btn_chs21;
    private javax.swing.JButton btn_chs22;
    private javax.swing.JButton btn_chs23;
    private javax.swing.JButton btn_chs24;
    private javax.swing.JButton btn_chs3;
    private javax.swing.JButton btn_chs4;
    private javax.swing.JButton btn_chs5;
    private javax.swing.JButton btn_chs6;
    private javax.swing.JButton btn_chs7;
    private javax.swing.JButton btn_chs8;
    private javax.swing.JButton btn_chs9;
    private javax.swing.JButton btn_connect;
    public javax.swing.JButton btn_endTour;
    public javax.swing.JButton btn_rollDies;
    public javax.swing.JButton btn_send_message;
    private javax.swing.JLabel jLabel1;
    public javax.swing.JLabel lbl_board;
    private javax.swing.JLabel lbl_coC1;
    private javax.swing.JLabel lbl_coC10;
    private javax.swing.JLabel lbl_coC11;
    private javax.swing.JLabel lbl_coC12;
    private javax.swing.JLabel lbl_coC13;
    private javax.swing.JLabel lbl_coC14;
    private javax.swing.JLabel lbl_coC15;
    private javax.swing.JLabel lbl_coC16;
    private javax.swing.JLabel lbl_coC17;
    private javax.swing.JLabel lbl_coC18;
    private javax.swing.JLabel lbl_coC19;
    private javax.swing.JLabel lbl_coC2;
    private javax.swing.JLabel lbl_coC20;
    private javax.swing.JLabel lbl_coC21;
    private javax.swing.JLabel lbl_coC22;
    private javax.swing.JLabel lbl_coC23;
    private javax.swing.JLabel lbl_coC24;
    private javax.swing.JLabel lbl_coC3;
    private javax.swing.JLabel lbl_coC4;
    private javax.swing.JLabel lbl_coC5;
    private javax.swing.JLabel lbl_coC6;
    private javax.swing.JLabel lbl_coC7;
    private javax.swing.JLabel lbl_coC8;
    private javax.swing.JLabel lbl_coC9;
    public javax.swing.JLabel lbl_die1;
    public javax.swing.JLabel lbl_die2;
    public javax.swing.JLabel lbl_nameRival;
    public javax.swing.JLabel lbl_noC1;
    private javax.swing.JLabel lbl_noC10;
    private javax.swing.JLabel lbl_noC11;
    private javax.swing.JLabel lbl_noC12;
    private javax.swing.JLabel lbl_noC13;
    private javax.swing.JLabel lbl_noC14;
    private javax.swing.JLabel lbl_noC15;
    private javax.swing.JLabel lbl_noC16;
    private javax.swing.JLabel lbl_noC17;
    private javax.swing.JLabel lbl_noC18;
    private javax.swing.JLabel lbl_noC19;
    private javax.swing.JLabel lbl_noC2;
    private javax.swing.JLabel lbl_noC20;
    private javax.swing.JLabel lbl_noC21;
    private javax.swing.JLabel lbl_noC22;
    private javax.swing.JLabel lbl_noC23;
    public static javax.swing.JLabel lbl_noC24;
    private javax.swing.JLabel lbl_noC3;
    private javax.swing.JLabel lbl_noC4;
    private javax.swing.JLabel lbl_noC5;
    private javax.swing.JLabel lbl_noC6;
    private javax.swing.JLabel lbl_noC7;
    private javax.swing.JLabel lbl_noC8;
    private javax.swing.JLabel lbl_noC9;
    private javax.swing.JLabel lbl_rivalNameTitle;
    public static javax.swing.JLabel lbl_yourTurn;
    private javax.swing.JTextField txt_ip;
    public javax.swing.JTextField txt_name;
    public java.awt.TextArea txt_receive;
    public java.awt.TextArea txt_send;
    // End of variables declaration//GEN-END:variables
}
