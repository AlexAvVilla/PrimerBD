/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelos.Conexion;
import Modelos.PersonaModel;
import Vistas.frmLogin;
import Vistas.frmPersonas;
import Vistas.frmPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Alex Avila
 */
public class ConexionController implements ActionListener{
    frmLogin VistaLogin;
    frmPrincipal VistaPrincipal;
    frmPersonas VistaPersonas;
    Conexion ModeloConexion;
    PersonaModel ModeloPersona;

    public ConexionController(frmLogin VistaLogin, frmPrincipal VistaPrincipal,frmPersonas VistaPersonas, Conexion ModeloConexion, PersonaModel ModeloPer) {
        this.VistaLogin = VistaLogin;
        this.VistaPrincipal = VistaPrincipal;
        this.VistaPersonas = VistaPersonas;
        this.ModeloConexion = ModeloConexion;
        this.ModeloPersona = ModeloPer;
        
        //this.VistaPrincipal.setExtendedState(frmPrincipal.MAXIMIZED_BOTH);
        this.VistaPrincipal.setVisible(true);
        
        this.VistaLogin.btnAceptar.addActionListener(this);
        this.VistaPrincipal.btnConectar.addActionListener(this);
        //this.VistaPersonas.btnGuardar.addActionListener(this);
        
        
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==this.VistaPrincipal.btnConectar){
            this.VistaLogin.setVisible(true);
            this.VistaLogin.setLocationRelativeTo(null);
        }
        
        if(e.getSource()==this.VistaLogin.btnAceptar){
            this.ModeloConexion.Conectar(this.VistaLogin.txtUsuario.getText(), this.VistaLogin.txtContra.getText());
            
            if(ModeloConexion!=null){
                this.VistaLogin.dispose();
                this.VistaPersonas.btnGuardar.addActionListener(this);
                this.VistaPersonas.setVisible(true);
                this.VistaPersonas.setLocationRelativeTo(null);
            }
        }
        
        if(e.getSource()==this.VistaPersonas.btnGuardar){
            this.ModeloPersona.GuardarPersona(this.VistaPersonas.txtApellidos.getText(), 
                                             this.VistaPersonas.txtNombre.getText(),
                                             this.VistaPersonas.txtTelefono.getText());
        }
        
        /*if(e.getSource()==this.VistaPrincipal.btnAgregar){
            this.VistaPersonas.setVisible(true);
            this.VistaPersonas.setLocationRelativeTo(null);
        }*/
    }
}
