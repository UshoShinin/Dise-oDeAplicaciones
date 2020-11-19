package Controlador;

//tenemos que importar la clase que tenga la excepciones

import java.time.Instant;
import java.util.Date;
import modelo.NumeroAtencion;
import modelo.ObligatorioException;
import modelo.Puesto;
import modelo.Trabajador;
import observador.*;

public class ControladorAtencion implements Observador{
    
    private VistaAtencionCliente vista;
    private Puesto puesto;
    private NumeroAtencion Numero;

    public ControladorAtencion(VistaAtencionCliente vista,Puesto P,Trabajador T) {
        this.vista = vista;
        this.puesto = P;
        P.agregar(this);
        P.setTrabajador(T);
    }

    @Override
    public void actualizar(Observable origen, Object evento) {
        switch((Puesto.Eventos)evento){
            case Libre:
                vista.estadoDesocupado();
                Numero = null;
                break;
            case NuevoCliente:
                vista.estadoOcupado();
                Numero = puesto.getNumeroActual();
                break;
        }
    }

    public void IniciarAtencion() {
        Numero.setFechaInicio(Date.from(Instant.now()));
    }

    public void FinalizarAtencion(String dec) {

        puesto.TerminarAtencion(dec);
    }
    
    
}
