package modelo;

import java.util.ArrayList;

public class SistemaAreas {
    private ArrayList<Area> areas;
    private int costoFijo;

    public SistemaAreas() {
        this.areas = new ArrayList<Area>();
        //Precarga
        ArrayList<Sector> sectores1 = new ArrayList<Sector>();
        ArrayList<Sector> sectores2 = new ArrayList<Sector>();
        ArrayList<Sector> sectores3 = new ArrayList<Sector>();
        ArrayList<Sector> sectores4 = new ArrayList<Sector>();
        areas.add(new Area("Area 1",sectores1));
        areas.add(new Area("Area 2",sectores2));
        areas.add(new Area("Area 3",sectores3));
        areas.add(new Area("Area 4",sectores4));
    }

    public ArrayList<Area> getAreas() {
        return areas;
    }
    
}
