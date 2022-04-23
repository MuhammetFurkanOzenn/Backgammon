/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backgammonserver;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ozen
 */
public class BackgammonServer {

    /**
     * @param args the command line arguments
     */
    //public static Server server;
    public static void main(String[] args) {
        Server.Start(2000);
    }
    
}
