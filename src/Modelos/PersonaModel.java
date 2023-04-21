/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

//import com.sun.jdi.connect.spi.Connection;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Alex Avila
 */
public class PersonaModel {
    String apellidos;
    String nombre;
    int telefono;
    Connection myConexion;

    public PersonaModel(String apellidos, String nombre, int telefono) {
        this.apellidos = apellidos;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public PersonaModel() {

    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    
    public void GuardarPersona(){
        try{
            Conexion nuevaConexion = new Conexion();
            this.myConexion = nuevaConexion.Conectar(nombre, nombre);
            Statement sentencia = myConexion.createStatement();
            sentencia.execute("Insert into Persona values('"+this.getApellidos()+"','"+this.getNombre()+"','"+this.getTelefono()+"')");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al ingresar el registro tio "+e.getMessage());
        }
        
    }
    
}
