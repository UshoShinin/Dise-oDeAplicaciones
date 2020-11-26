package modelo;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import observador.Observable;

public class Puesto extends Observable implements Comparable{

    private int numPuesto;
    private Sector sector;
    private Trabajador trabajador;
    private NumeroAtencion numeroActual;
    private ArrayList<NumeroAtencion> numerosProcesados;

    public enum Eventos{NuevoCliente,Libre,FinAtencion,Trabajador}
    
    public Puesto(int numPuesto, Sector sector) {
        this.numPuesto = numPuesto;
        this.sector = sector;
        this.trabajador = null;
        this.numeroActual = null;
        this.numerosProcesados = new ArrayList<NumeroAtencion>();
    }
    // <editor-fold defaultstate="collapsed" desc="Getters and Setters">
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
    
    public NumeroAtencion getNumeroActual() {
        return numeroActual;
    }

    public ArrayList<NumeroAtencion> getNumerosProcesados() {
        return numerosProcesados;
    }

    public void setNumerosProcesados(ArrayList<NumeroAtencion> numerosProcesados) {
        this.numerosProcesados = numerosProcesados;
    }
    // </editor-fold>
    
    public void asignarTrabajador(Trabajador trabajador) throws ObligatorioException{
        if(trabajador != null){
            if(trabajador.getPuesto() != null) throw new ObligatorioException("El trabajador ya esta en un puesto");
            trabajador.setPuesto(this);
        } else{
            
        }
        setTrabajador(trabajador);
        sector.cambioTrabajador();
        avisar(Eventos.Trabajador);
        if(trabajador!=null)sector.solicitarNumero(this);
    }

    void asignarNumero(NumeroAtencion na) {
        this.numeroActual = na;
        if(na==null) avisar(Eventos.Libre);
        else{avisar(Eventos.NuevoCliente);
        sector.NuevoCliente(this);}
        
    }

    public int numerosProcesados(){
        if(numeroActual==null) return numerosProcesados.size();
        else return numerosProcesados.size()+1;
        
    }
    
    public int tiempoPromedio() {
        int ret = 0;
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
    
    public void IniciarAtencion() {
        numeroActual.setFechaInicio(Date.from(Instant.now()));
    }
    
    public void TerminarAtencion(String dec) {
        numeroActual.setDescripcion(dec);
        numeroActual.setFechaFin(Date.from(Instant.now()));
        numerosProcesados.add(numeroActual);
        numeroActual.setTrabajador(trabajador);
        numeroActual.setCosto(numeroActual.getCliente().calcularCostoAtencion(Sistema.getInstancia().getCostoFijo(),numeroActual.esperaAtencion()));
        avisar(Eventos.FinAtencion);
        sector.FinAtencion(this);
        sector.solicitarNumero(this);
        
    }
    public void Salir(){
        try {
            this.trabajador.salir();
            asignarTrabajador(null);
        } catch (ObligatorioException ex) {
        }
    }
    
    @Override
    public int compareTo(Object o) {
        Puesto P = (Puesto) o;
        return -this.getNumeroActual().compareTo(P.getNumeroActual());
    }
    
    @Override
    public String toString() {
        return "Puesto: " + numPuesto;
    }
    
    

}
