/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.ObligatorioException;
import modelo.Puesto;
import modelo.Sector;
import modelo.Trabajador;
import observador.Observable;
import observador.Observador;

/**
 *
 * @author Intel i7
 */
public class ControladorElegirPuesto implements Observador{

    private VistaElegirPuesto vista;
    private Sector sector;

    public ControladorElegirPuesto(VistaElegirPuesto vista, Sector s) {
        this.vista = vista;
        this.sector =s;
        for (Puesto p : s.getPuestos()) {
            p.agregar(this);
        }
    }
    
    
    @Override
    public void actualizar(Observable origen, Object evento) {
        switch((Puesto.Eventos)evento){
            case Trabajador:
                vista.mostrarPuestos();
                break;
        }
    }

    public void asignarTrabajadorAlPuesto(Puesto P, Trabajador T) {
        try {
            P.asignarTrabajador(T);
            vista.crearVentanaAtencion(P);
        } catch (ObligatorioException ex) {
            vista.mostrarError(ex.getMessage());
        }
    }

    public void salir() {
        for (Puesto p : sector.getPuestos()) {
            p.quitar(this);
        }
    }
    
}
