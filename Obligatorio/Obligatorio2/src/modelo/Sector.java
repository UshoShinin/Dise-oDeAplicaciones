package modelo;

import Controlador.VistaPedirNumero;
import java.util.ArrayList;
import observador.*;


public class Sector extends Observable{
    
    private String nombre;
    private ArrayList<Puesto> puestos;
    private ArrayList<Trabajador> trabajadores;
    private ArrayList<NumeroAtencion> numeroPendientes;
    private int Ultimo;
    
    public enum Eventos{sacaronNumero};

    public Sector() {
    }
   
    
    
}
