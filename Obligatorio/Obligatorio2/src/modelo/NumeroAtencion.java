package modelo;

import java.util.Date;
import observador.Observable;

//TENEMOS QUE REVISAR DE SI QUEREMOS QUE ESTO SEA OBSERVABLE PARA MI NO TIENE PORQUE SERLO

public class NumeroAtencion extends Observable{
    
    private int numero;
    private Date fechaSacado;
    private Date fechaInicio;
    private Date fechaFin;
    private String descripcion;
    private Trabajador trabajador;
    private Cliente cliente;
    private Sector sector;

   
    
    public enum Eventos{cambioValor,reset;}

    public NumeroAtencion() {
        this.numero = 0;
    }
    
    public NumeroAtencion(Date fechaSacado, int numero, Cliente cli, Sector sector) {
        this.fechaSacado = fechaSacado;
        this.numero = numero;
        this.cliente = cli;
        this.sector = sector;
    }
    
    public float duracionAten(){
        return fechaInicio.getTime()/1000 - fechaFin.getTime()/1000;
    }
    
    
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

    @Override
    public String toString() {
        return String.valueOf(numero);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Date getFechaSacado() {
        return fechaSacado;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    
    
    
}
