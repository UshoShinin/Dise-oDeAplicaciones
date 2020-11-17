/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.util.ArrayList;
import modelo.Area;


/**
 *
 * @author Ivan
 */
public interface VistaSeleccionarArea {

    public void mostrarAreas(ArrayList<Area> areas);
    
    public void mostrarError(String message);
}
