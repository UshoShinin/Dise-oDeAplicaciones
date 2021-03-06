package modelo;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import observador.*;
import Controlador.VistaSeleccionarArea;


public class Sector extends Observable{
    
    private String nombre;
    private Area area;
    private ArrayList<Puesto> puestos;
    private ArrayList<Trabajador> trabajadores;
    private ArrayList<NumeroAtencion> numeroPendientes;
    private NumeroAtencion ultimo;
    private Puesto ultimoPuesto;
    
    
    public enum Eventos{sacaronNumero,seMovioTrabajador,nuevoPromedio,NuevoCliente,FinAtencion};
    
    public Sector(String nombre, int cp, Area area){
        this.nombre = nombre;
        this.area = area;
        this.ultimo = new NumeroAtencion();
        this.numeroPendientes = new ArrayList<NumeroAtencion>();
        this.trabajadores = new ArrayList<Trabajador>();
        this.puestos = new ArrayList<>();
        for(int i= 1;i<=cp;i++){
            this.puestos.add(new Puesto(i,this));
        }
    }
    
    public NumeroAtencion pedirNumero(Cliente cli) throws ObligatorioException {
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
    
    
      void solicitarNumero(Puesto p) {
        if(numeroPendientes.isEmpty()){
            p.asignarNumero(null);
        }else{
            NumeroAtencion N = numeroPendientes.get(0);
            numeroPendientes.remove(0);
            p.asignarNumero(N);
        }
        avisar(Eventos.nuevoPromedio);
    }
    
    public void AgregarTrabajador(Trabajador T){
        trabajadores.add(T);
    }
    
    public void ponerNumeroPendiente(NumeroAtencion na){
        numeroPendientes.add(na);
    }

    public String getNombre() {
        return nombre;
    }
    //Devuelve el primer puesto disponible que haya
    public Puesto puestoDisponible(){
        for (Puesto puesto : puestos) {
            if(puesto.getTrabajador()!=null && puesto.getNumeroActual() == null){
                return puesto;
            }
        }
        return null;
    }
    
    public int tiempoEspera(){
        int PP = 0; //Promedio de puestos
        for (Puesto p : puestos) {
            PP += p.tiempoPromedio();
        }
        if(PP!=0){
            return (PP/puestosEnUso())*numeroPendientes.size();
        }
        return 0;
    }
    
    public String Espera(){
        int espera = tiempoEspera();
        String Spera = "";
        if(espera == 0){
            Spera = "0:00";
        }else{
            int seg = espera%60;
            Spera = String.valueOf((espera-(seg))/60)+":";
            if(seg<10)Spera += "0";
            Spera += String.valueOf(seg);
        }
        return "Tiempo de espera: " + Spera;
    }
    
    private int puestosEnUso(){
        int ret = 0;
        for (Puesto p : puestos) {
            if(p.enUso()){
                ret++;
            }
        }
        return ret;
    }
    
    
    public ArrayList<Puesto> puestosDisponibles(){
        ArrayList<Puesto> ret = new ArrayList<>();
        for (Puesto p : puestos) {
            if(!p.enUso()){
                ret.add(p);
            }
        }
        return ret;
    }
    
    //ESTE METODO ES EL QUE TENEMOS QUE VER COMO MIERDDA HACERLO
    public ArrayList<String> datosMonitoreo(){
        ArrayList<String> ret = new ArrayList<>();
        for (Puesto p : puestos) {
            ret.add(p.datosParaMonitoreo());
        }
        return ret;
    }

     boolean tengoTrabajadores() {
        return puestosEnUso()>0;
    }
    
    public NumeroAtencion getUltimo() {
        return ultimo;
    }

    public ArrayList<Puesto> getPuestos() {
        return puestos;
    }
    
    public int generarProximoNumero(){
        int N = ultimo.getValor()+1;
        return N;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }
    
    public void cambioTrabajador(){
        avisar(Eventos.seMovioTrabajador);
    }

    void NuevoCliente(Puesto P) {
        ultimoPuesto = P;
        avisar(Eventos.NuevoCliente);
    }

    void FinAtencion(Puesto P) {
        ultimoPuesto = P;
        avisar(Eventos.FinAtencion);
    }

    public Puesto getUltimoPuesto() {
        return ultimoPuesto;
    }

    public void setUltimoPuesto(Puesto ultimoPuesto) {
        this.ultimoPuesto = ultimoPuesto;
    }
    
    
    
    @Override
    public String toString() {
        return nombre+ " " + Espera();
    }
  
    
    
    
}
