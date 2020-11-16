package modelo;

import Controlador.VistaPedirNumero;
import java.util.ArrayList;
import observador.*;


public class Sector implements Observador {
    
    private String nombre;
    private ArrayList<Puesto> puestos;
    private ArrayList<Trabajador> trabajadores;
    private ArrayList<NumeroAtencion> numeroPendientes;
    private VistaPedirNumero vista;
    private NumeroAtencion modelo;

    public Sector(NumeroAtencion modelo, VistaPedirNumero v) {
        this.modelo = modelo;
        vista = v;
        modelo.agregar(this);
        vista.mostrarContador(modelo.getValor());
    }
   
    
    public NumeroAtencion getModelo(){
        return modelo;
    }
    
    @Override
    public void actualizar(Observable origen, Object evento) {
        if (origen == modelo){
            switch((NumeroAtencion.Eventos)evento){
                case cambioValor:
                    vista.mostrarContador(modelo.getValor());
                    break;
                case reset:
            }
        }    
    }
    
    public void sumar(){
        modelo.sumar();
    }
    
    public void restar(){
        modelo.restar();
    }
    
}
