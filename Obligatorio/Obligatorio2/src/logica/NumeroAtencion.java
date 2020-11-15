package logica;

import java.util.Date;
import observador.Observable;


public class NumeroAtencion extends Observable{
    
    private int numero = 0;
    private Date fechaSacado;
    private Date fechaInicio;
    private Date fechaFin;
    private String descripcion;
    private Trabajador trabajador;
    
    public enum Eventos{cambioValor,reset;}
    
    public int getValor(){
        return numero;
    }
    public void sumar(){
        numero++;
        avisar(Eventos.cambioValor);
    }
    
    public void restar(){
        numero--;
        avisar(Eventos.cambioValor);
    }
    
}
