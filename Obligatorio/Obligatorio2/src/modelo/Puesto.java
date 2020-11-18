package modelo;

import java.util.ArrayList;

public class Puesto {

    private int numPuesto;
    private Sector sector;
    private Trabajador trabajador;
    private NumeroAtencion numeroActual;
    private ArrayList<NumeroAtencion> numerosProcesados;

    public Puesto(int numPuesto, Sector sector) {
        this.numPuesto = numPuesto;
        this.sector = sector;
        this.trabajador = null;
        this.numeroActual = null;
        this.numerosProcesados = new ArrayList<NumeroAtencion>();
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

    void asignarNumero(NumeroAtencion na) {
        this.numeroActual = na;
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

    @Override
    public String toString() {
        return "Puesto: " + numPuesto;
    }

}
