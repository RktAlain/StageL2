/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionsav;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author ACER
 */
public class connect {
    public Connection con ;
    public connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver"); //Changement de pilote
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestionsav","root","");
            //JOptionPane.showMessageDialog(null, "Connexion établie");
            
            
        } 
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Connexion échoué"+e);
        }
    }
}
