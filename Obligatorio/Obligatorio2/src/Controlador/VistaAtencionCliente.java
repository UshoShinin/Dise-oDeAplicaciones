/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

/**
 *
 * @author Ivan
 */
public interface VistaAtencionCliente {

    public void estadoDesocupado();

    public void estadoOcupado();

    public void finAtencion();

    public void mostrarMensaje(String message);
    
}
