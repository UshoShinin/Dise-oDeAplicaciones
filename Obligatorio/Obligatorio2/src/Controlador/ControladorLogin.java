package Controlador;

//tenemos que importar la clase que tenga la excepciones

import modelo.ObligatorioException;
import modelo.Sistema;
import modelo.Trabajador;

public class ControladorLogin {
    
    private Sistema modelo;
    private VistaLogin vista;

    public ControladorLogin(Sistema modelo, VistaLogin vista) {
        this.vista = vista;
        this.modelo = modelo;
    }
    
    public void login (int user, String pass){
        //La exception tiene que ir mas o menos asi, hay que ver porque no queda bien
        try {
            Trabajador trabajador = modelo.loginTrabajador(user, pass);
            vista.ingresar(trabajador);
        } catch (ObligatorioException oe) {
            vista.mostrarError(oe.getMessage());
        }
    }
    
}
