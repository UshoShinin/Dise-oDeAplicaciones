/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.util.ArrayList;
import modelo.NumeroAtencion;
import modelo.Sector;

/**
 *
 * @author Ivan
 */
public interface VistaPedirNumero {
    public void mostrarError(String message);
    public void mostrarSectores(ArrayList<Sector> sectores);
    public void mostrarNumeroAtencion(NumeroAtencion na);
}
