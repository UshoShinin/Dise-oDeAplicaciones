package Controlador;

//tenemos que importar la clase que tenga la excepciones

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
        //Esto tiene que ir dentro de un try y catch para luego poder usar las excepciones
        Trabajador trabajador = modelo.loginTrabajador(user, pass);
        //El metodo de abajo no entiendo muy bien para que lo necesitariamos
        vista.ingresar(trabajador);
    }
    
    
    
}
