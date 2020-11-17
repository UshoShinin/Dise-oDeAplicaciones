package Controlador;

//tenemos que importar la clase que tenga la excepciones

import modelo.ObligatorioException;
import modelo.Sistema;
import modelo.Trabajador;
import vistas.VistaLogin;




public class ControladorLogin {
    
    private Sistema modelo = Sistema.getInstancia();
    private VistaLogin vista;

    public ControladorLogin(VistaLogin vista) {
        this.vista = vista;
    }
    
    public void login (int user, String pass){
        //La exception tiene que ir mas o menos asi, hay que ver porque no queda bien
        try {
            Trabajador trabajador = modelo.loginTrabajador(user, pass);
        } catch (ObligatorioException oe) {
            vista.mostrarError(oe.getMessage());
        }
    }
    
    
    
}
