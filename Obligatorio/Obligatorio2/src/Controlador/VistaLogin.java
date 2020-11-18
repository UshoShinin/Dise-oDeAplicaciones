/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import modelo.Trabajador;

/**
 *
 * @author Intel i7
 */
public interface VistaLogin {
    public void login (String user, String pass);

    public void mostrarError(String message);

    public void ingresar(Trabajador trabajador);
}
