package modelo;

import java.util.ArrayList;

public class Area {
    
    private String nombre;
    private ArrayList<Sector> sectores;

    public Area(String nombre,ArrayList<Sector> sectores) {
        this.nombre = nombre;
        this.sectores = sectores;
    }

    @Override
    public String toString() {
        return nombre;
    }

    public ArrayList<Sector> getSectores() {
        return sectores;
    }
}


