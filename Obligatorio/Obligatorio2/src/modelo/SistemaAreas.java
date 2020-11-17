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
        sectores1.add(new Sector("S1"));
        sectores1.add(new Sector("S2"));
        sectores1.add(new Sector("S3"));
        
        sectores2.add(new Sector("S4"));
        sectores2.add(new Sector("S5"));
        sectores2.add(new Sector("S6"));
        sectores2.add(new Sector("S7"));
        
        sectores3.add(new Sector("S8"));
        sectores3.add(new Sector("S9"));
        sectores3.add(new Sector("S10"));
        
        sectores4.add(new Sector("S11"));
        sectores4.add(new Sector("S12"));
        sectores4.add(new Sector("S13"));
        sectores4.add(new Sector("S14"));
        sectores4.add(new Sector("S15"));
        
        areas.add(new Area("Area 1",sectores1));
        areas.add(new Area("Area 2",sectores2));
        areas.add(new Area("Area 3",sectores3));
        areas.add(new Area("Area 4",sectores4));
    }

    public ArrayList<Area> getAreas() {
        return areas;
    }
    
}
