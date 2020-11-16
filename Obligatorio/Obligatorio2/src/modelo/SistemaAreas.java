package modelo;

import java.util.ArrayList;

public class SistemaAreas {
    private ArrayList<Area> areas;
    private int costoFijo;

    public SistemaAreas() {
        this.areas = new ArrayList<Area>();
        //Precarga
        areas.add(new Area("Area 1"));
        areas.add(new Area("Area 2"));
        areas.add(new Area("Area 3"));
        areas.add(new Area("Area 4"));
    }

    public ArrayList<Area> getAreas() {
        return areas;
    }
    
}
