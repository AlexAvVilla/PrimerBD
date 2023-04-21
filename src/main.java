
import Controladores.ConexionController;
import Modelos.Conexion;
import Modelos.PersonaModel;
import Vistas.frmLogin;
import Vistas.frmPersonas;
import Vistas.frmPrincipal;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alex Avila
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        frmPrincipal VistaPrincipal = new frmPrincipal();
        frmLogin VistaLogin = new frmLogin(VistaPrincipal, true);
        frmPersonas VistaPersonas = new frmPersonas(VistaPrincipal, true);
        Conexion nuevaConexion = new Conexion();
        PersonaModel ModeloPersona = new PersonaModel();
        ConexionController ControladorConexion = new ConexionController(VistaLogin, VistaPrincipal, VistaPersonas, nuevaConexion, ModeloPersona);
        
        
    }
    
}
