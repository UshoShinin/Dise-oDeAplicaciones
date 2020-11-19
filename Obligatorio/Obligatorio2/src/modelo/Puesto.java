package modelo;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import observador.Observable;

public class Puesto extends Observable{

    private int numPuesto;
    private Sector sector;
    private Trabajador trabajador;
    private NumeroAtencion numeroActual;
    private ArrayList<NumeroAtencion> numerosProcesados;
    public enum Eventos{NuevoCliente,Libre,Trabajador}
    
    public Puesto(int numPuesto, Sector sector) {
        this.numPuesto = numPuesto;
        this.sector = sector;
        this.trabajador = null;
        this.numeroActual = null;
        this.numerosProcesados = new ArrayList<NumeroAtencion>();
    }
    
    public Sector getSector() {
        return sector;
    }

    public int getNumPuesto() {
        return numPuesto;
    }

    public void setNumPuesto(int numPuesto) {
        this.numPuesto = numPuesto;
    }

    public Trabajador getTrabajador() {
        return trabajador;
    }
    
    public void setTrabajador(Trabajador trabajador) {
        this.trabajador = trabajador;
    }
    
    public void asignarTrabajador(Trabajador trabajador){
        setTrabajador(trabajador);
        sector.cambioTrabajador();
        avisar(Eventos.Trabajador);
        if(trabajador!=null)sector.solicitarNumero(this);
    }

    public NumeroAtencion getNumeroActual() {
        return numeroActual;
    }

    public ArrayList<NumeroAtencion> getNumerosProcesados() {
        return numerosProcesados;
    }

    public void setNumerosProcesados(ArrayList<NumeroAtencion> numerosProcesados) {
        this.numerosProcesados = numerosProcesados;
    }

    void asignarNumero(NumeroAtencion na) {
        this.numeroActual = na;
        if(na==null) avisar(Eventos.Libre);
        else{avisar(Eventos.NuevoCliente);}
        
    }

    public int numerosProcesados(){
        if(numeroActual==null) return numerosProcesados.size();
        else return numerosProcesados.size()+1;
        
    }
    
    public float tiempoPromedio() {
        float ret = 0;
        for (NumeroAtencion np : numerosProcesados) {
            ret += np.duracionAten();
        }
        if (ret == 0) {
            return ret;
        }
        return ret / numerosProcesados.size();
    }

    public boolean enUso() {
        if (this.trabajador != null) {
            return true;
        } else {
            return false;
        }
    }

    public String datosParaMonitoreo(){
        String ret = sector.getNombre() + " " + numeroActual.getValor() + " " 
                + numeroActual.getCliente().getNombreCompleto() + " " + this.numPuesto +
                " " + sector.Espera();
        return ret;
    }
    
    public void TerminarAtencion(String dec) {
        numeroActual.setDescripcion(dec);
        numeroActual.setFechaFin(Date.from(Instant.now()));
        numerosProcesados.add(numeroActual);
        sector.solicitarNumero(this);
    }
    public void Salir(){
        asignarTrabajador(null);
    }
    
    @Override
    public String toString() {
        return "Puesto: " + numPuesto;
    }

}
