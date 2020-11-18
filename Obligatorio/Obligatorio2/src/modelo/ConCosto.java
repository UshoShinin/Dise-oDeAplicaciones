/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Intel i7
 */
public class ConCosto extends TipoCliente{

    @Override
    public int calcularCosto(int costoFijo, int tiempoDeEspera) {
        if(tiempoDeEspera < 60){
            return costoFijo;
        }else{
            return costoFijo/2;
        }
    }
    
}
