package Controlador;


import modelo.NumeroAtencion;
import observador.*;


public class ControladorArea implements Observador {
    
    
    private NumeroAtencion modelo;
    private Monitor vista;

    public ControladorArea(NumeroAtencion modelo, Monitor v) {
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
