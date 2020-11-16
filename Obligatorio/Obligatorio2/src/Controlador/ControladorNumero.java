package Controlador;


import observador.*;
import modelo.Sector;


public class ControladorNumero implements Observador{


    private Sistema modelo;
    private VistaPedirNumero vista;

    public ControladorNumero(Sistema modelo, VistaPedirNumero v) {
        this.modelo = modelo;
        vista = v;
        //modelo.agregar(this);
        vista.mostrarAreas(modelo.getSubAreas().getAreas());
    }


    public Sistema getModelo(){
        return modelo;
    }

//    @Override
//    public void actualizar(Observable origen, Object evento) {
//        if (origen == modelo){
//            switch((NumeroAtencion.Eventos)evento){
//                case cambioValor:
//                    vista.mostrarContador(modelo.getValor());
//                    break;
//                case reset:
//            }
//        }    
//    }

    @Override
    public void actualizar(Observable origen, Object evento) {
        if (origen == modelo){
            switch((NumeroAtencion.Eventos)evento){
                case cambioValor:
                    vista.mostrarContador(modelo.getValor());
                    break;
                case reset:
            }
      

}
