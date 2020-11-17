package Controlador;

import modelo.Sector;
import modelo.Sistema;

public class ControladorSeleccionarArea{

    private Sistema modelo;
    private Sector S;
    private VistaSeleccionarArea vista;

    public ControladorSeleccionarArea(Sistema modelo,VistaSeleccionarArea v) {
        this.modelo = modelo;
        vista = v;
        //modelo.agregar(this);
        vista.mostrarAreas(modelo.getSubAreas().getAreas());
    }

    public Sistema getModelo() {
        return modelo;
    }
    
    public Sector getS(){
        return S;
    }

    
}
