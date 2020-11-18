package Controlador;

//tenemos que importar la clase que tenga la excepciones

import modelo.ObligatorioException;
import modelo.Puesto;
import modelo.Sistema;
import modelo.Trabajador;
import observador.*;

public class ControladorAtencion implements Observador{
    
    private VistaAtencionCliente vista;
    private Puesto puesto;

    public ControladorAtencion(VistaAtencionCliente vista,Puesto P) {
        this.vista = vista;
        this.puesto = P;
        P.agregar(this);
    }

    @Override
    public void actualizar(Observable origen, Object evento) {
        switch((Puesto.Eventos)evento){
            case Libre:
                break;
            case NuevoCliente:
                break;
        }
    }
    
    
}
