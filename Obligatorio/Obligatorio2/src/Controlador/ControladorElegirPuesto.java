/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import modelo.Puesto;
import modelo.Sector;
import observador.Observable;
import observador.Observador;

/**
 *
 * @author Intel i7
 */
public class ControladorElegirPuesto implements Observador{

    private VistaElegirPuesto vista;

    public ControladorElegirPuesto(VistaElegirPuesto vista, Sector s) {
        this.vista = vista;
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
    
}
