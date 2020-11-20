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
    private ArrayList<Puesto> puestosEnUso;

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
        if(!puestos.isEmpty())Collections.sort(puestos);
        vista.mostrarPuestos(puestos);
        puestosEnUso = puestos;
    }

    public Sistema getModelo() {
        return modelo;
    }

    @Override
    public void actualizar(Observable origen, Object evento) {
        Puesto P =(Puesto)origen;
        switch ((Puesto.Eventos) evento) {
            case NuevoCliente:
                puestosEnUso.add(0,P);
                break;
            case FinAtencion:
                puestosEnUso.remove(P);
        }
        vista.mostrarPuestos(puestosEnUso);
    }
}
