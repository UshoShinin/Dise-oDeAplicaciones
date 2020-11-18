package modelo;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import observador.*;
import Controlador.VistaSeleccionarArea;


public class Sector extends Observable{
    
    private String nombre;
    private ArrayList<Puesto> puestos;
    private ArrayList<Trabajador> trabajadores;
    private ArrayList<NumeroAtencion> numeroPendientes;
    private NumeroAtencion ultimo;
    //private int ultimoInt;

    public enum Eventos{sacaronNumero};
    
    public Sector(String nombre){
        this.nombre = nombre;
        this.puestos = new ArrayList<>();
        this.ultimo = new NumeroAtencion();
        //this.ultimoInt = 0;
        this.numeroPendientes = new ArrayList<NumeroAtencion>();
    }
    
    public NumeroAtencion pedirNumero(Cliente cli) {
        //Creo un numero de atencion nada mas con la fecha de sacado
        //Los otros datos se le agregan al momento de ser atendido
        NumeroAtencion na = new NumeroAtencion(Date.from(Instant.now()), generarProximoNumero(), cli, this);
        ultimo = na;
        //Consulto si hay algun puesto disponible
        Puesto pDisp = puestoDisponible();
        if(pDisp == null){
            //Si no hay ninguno lo pongo como pendiente
            ponerNumeroPendiente(na);
        }else{
            //Si hay algun puesto disponible le asigno el numero
            pDisp.asignarNumero(na);
        }
        //Le aviso a todos los observadores que sacaron un numero
        avisar(Eventos.sacaronNumero);
        return na;
    }
    
    
    public void ponerNumeroPendiente(NumeroAtencion na){
        numeroPendientes.add(na);
        for(NumeroAtencion N : numeroPendientes){
            System.out.println(N);
        }
    }
    
    //Devuelve el primer puesto disponible que haya
    public Puesto puestoDisponible(){
        for (Puesto puesto : puestos) {
            if(puesto.getNumeroActual() == null){
                return puesto;
            }
        }
        return null;
    }
    
    public String Espera(){
        float espera = 0;
        for (Puesto p : puestos) {
            espera += p.tiempoPromedio();
        }
        if(espera == 0){
            return "Tiempo de espera: " + espera;
        }
        String ret = "Tiempo de espera: " + String.valueOf(espera/puestosDisponibles());
        return ret;
    }
    
    private int puestosDisponibles(){
        int ret = 0;
        for (Puesto p : puestos) {
            if(p.disponible()){
                ret++;
            }
        }
        return ret;
    }

    public NumeroAtencion getUltimo() {
        return ultimo;
    }

    @Override
    public String toString() {
        return nombre+ " " + Espera();
    }
    
    public int generarProximoNumero(){
        int N = ultimo.getValor()+1;
        return N;
    }
}
