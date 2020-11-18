package modelo;

import java.util.ArrayList;

public class Area {
    
    private String nombre;
    private ArrayList<Sector> sectores;

    public Area(String nombre) {
        this.nombre = nombre;
        this.sectores = new ArrayList<Sector>();
    }

    @Override
    public String toString() {
        return nombre;
    }

    public ArrayList<Sector> getSectores() {
        return sectores;
    }
    
    public void AgragarSector(Sector S){
        sectores.add(S);
        S.setArea(this);
    }
    
}


