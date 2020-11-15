package Controlador;


import modelo.Sistema;
import observador.*;


public class ControladorArea implements Observador {
    
    
    private Sistema modelo;
    private Monitor vista;

    public ControladorArea(Sistema modelo, Monitor v) {
        this.modelo = modelo;
        vista = v;
        modelo.agregar(this);
        vista.mostrarContador(modelo.getValor());
    }
   
    
    public Sistema getModelo(){
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
