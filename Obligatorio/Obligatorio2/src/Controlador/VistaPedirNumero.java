/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.util.ArrayList;
import modelo.Area;
import modelo.NumeroAtencion;
import modelo.Sector;

/**
 *
 * @author Ivan
 */
public interface VistaPedirNumero {

    public void mostrarContador(int valor);

    public void mostrarAreas(ArrayList<Area> areas);

    public void mostrarSectores(ArrayList<Sector> sectores);

    public void mostrarError(String message);

    public void mostrarNumeroCliente(NumeroAtencion na);
}
