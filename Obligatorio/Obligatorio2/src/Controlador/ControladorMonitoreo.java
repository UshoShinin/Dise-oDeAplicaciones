package Controlador;

import java.util.ArrayList;
import java.util.Collections;
import modelo.NumeroAtencion;
import modelo.ObligatorioException;
import observador.*;
import modelo.Area;
import modelo.Puesto;
import modelo.Sector;
import modelo.Sistema;

public class ControladorMonitoreo implements Observador {

    private Sistema modelo;
    private Area A;
    private VistaMonitoreo vista;

    public ControladorMonitoreo(VistaMonitoreo v,Area A) {
        this.modelo = Sistema.getInstancia();
        this.A = A;
        vista = v;
        ArrayList<Puesto> puestos = new ArrayList<Puesto>();
        for(Sector S : A.getSectores()){
            for(Puesto P : S.getPuestos()){
                if(P.getNumeroActual()!=null) puestos.add(P);
                P.agregar(this);
            }
        }
        Collections.sort(puestos);
        vista.mostrarPuestos(puestos);
        
    }

    public Sistema getModelo() {
        return modelo;
    }

    @Override
    public void actualizar(Observable origen, Object evento) {
        switch ((Puesto.Eventos) evento) {
            case NuevoCliente:
                
                break;

        }
    }
}
