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
        P.asignarTrabajador(T);
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
            case FinAtencion:
                vista.finAtencion();
                break;
        }
    }

    public void IniciarAtencion() {
        Numero.setFechaInicio(Date.from(Instant.now()));
    }

    public void FinalizarAtencion(String dec) {
        puesto.TerminarAtencion(dec);
    }

    public void FinalizarSalir(String dec) {
        puesto.TerminarAtencion(dec);
        puesto.Salir();
    }

    public void Salir() {
        puesto.Salir();
    }
    
    
    
    
}
