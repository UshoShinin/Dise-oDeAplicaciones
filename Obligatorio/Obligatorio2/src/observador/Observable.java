/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observador;

import java.util.ArrayList;

/**
 *
 * @author Dario
 */
public class Observable {
    
    private ArrayList<Observador> observadores = new ArrayList();
    
    public void agregar(Observador obs){
        if(!observadores.contains(obs)){
            observadores.add(obs);
        }
    }
    public void quitar(Observador obs){
        observadores.remove(obs);
    }
    public void avisar(Object evento){
        ArrayList<Observador> copia = new ArrayList(observadores);
        for(Observador obs:copia){
            try{
                
                obs.actualizar(this, evento);
                
            }catch(Exception e){
                System.out.println("Error al actualizar:" + e.getMessage());
                System.out.println("Stack:");
                e.printStackTrace();
            }
        }
        
    }
            
}
