/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backgammonplayer;

import game.Message;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import static backgammonplayer.Player.sInput;
import game.Game;
/**
 *
 * @author Ozen
 */

// serverdan gelecek mesajları dinleyen thread
class Listen extends Thread {

    public void run() {
        //soket bağlı olduğu sürece dön
        while (Player.socket.isConnected()) {
            try {
                //mesaj gelmesini bloking olarak dinyelen komut
                Message received = (Message) (sInput.readObject());
                //mesaj gelirse bu satıra geçer
                //mesaj tipine göre yapılacak işlemi ayır.
                switch (received.type) {
                    case Name:
                        break;
                    case RivalConnected:
                        String name = received.content.toString();
                        /*
                        Game.ThisGame.txt_rival_name.setText(name);
                        Game.ThisGame.btn_pick.setEnabled(true);
                        Game.ThisGame.btn_send_message.setEnabled(true);
                        */
                        Game.ThisGame.tmr_slider.start();
                        break;
                    case Disconnect:
                        break;
                    case Text:
                        //Game.ThisGame.txt_receive.setText(received.content.toString());
                        break;
                    case Selected:
                        Game.ThisGame.RivalSelection = (int) received.content;

                        break;

                    case Bitis:
                        break;

                }

            } catch (IOException ex) {

                Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
                //Client.Stop();
                break;
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
                //Client.Stop();
                break;
            }
        }

    }
}

public class Player {

    //her clientın bir soketi olmalı
    public static Socket socket;

    //verileri almak için gerekli nesne
    public static ObjectInputStream sInput;
    //verileri göndermek için gerekli nesne
    public static ObjectOutputStream sOutput;
    //serverı dinleme thredi 
    public static Listen listenMe;

    public static void Start(String ip, int port) {
        try {
            // Client Soket nesnesi
            Player.socket = new Socket(ip, port);
            Player.Display("Servera bağlandı");
            // input stream
            Player.sInput = new ObjectInputStream(Player.socket.getInputStream());
            // output stream
            Player.sOutput = new ObjectOutputStream(Player.socket.getOutputStream());
            Player.listenMe = new Listen();
            Player.listenMe.start();
            
            //ilk mesaj olarak isim gönderiyorum
            Message msg = new Message(Message.Message_Type.Name);
            msg.content = Game.ThisGame.txt_name.getText();
            Player.Send(msg);
        } catch (IOException ex) {
            Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //client durdurma fonksiyonu
    public static void Stop() {
        try {
            if (Player.socket != null) {
                Player.listenMe.stop();
                Player.socket.close();
                Player.sOutput.flush();
                Player.sOutput.close();

                Player.sInput.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void Display(String msg) {

        System.out.println(msg);

    }

    //mesaj gönderme fonksiyonu
    public static void Send(Message msg) {
        try {
            Player.sOutput.writeObject(msg);
        } catch (IOException ex) {
            Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
