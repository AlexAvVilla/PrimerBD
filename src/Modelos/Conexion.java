/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

//import com.sun.jdi.connect.spi.Connection;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Alex Avila
 */
public class Conexion {
    
    Connection conexion;
    
    public Connection Conectar(String user, String pass){
        try 
        {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            
            String servidor = "localhost";
            String numero_puerto = "1521";
            String sid = "xe";
            String url = "jdbc:oracle:thin:@"+servidor+":"+numero_puerto+":"+sid;
            
            
            conexion = DriverManager.getConnection(url, user, pass);
            JOptionPane.showMessageDialog(null, "Conexion Exitosa");
            return conexion;
            
        }
        catch(SQLException e){
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "No se conecto tio.."+e.getMessage());
            return conexion;
        }
    }
}
