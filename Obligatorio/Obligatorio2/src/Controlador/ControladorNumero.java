package Controlador;

import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Cliente;
import modelo.NumeroAtencion;
import modelo.ObligatorioException;
import observador.*;
import modelo.Sector;
import modelo.Sistema;

public class ControladorNumero implements Observador {

    private Sistema modelo;
    private VistaPedirNumero vista;

    public ControladorNumero(Sistema modelo, VistaPedirNumero v) {
        this.modelo = modelo;
        vista = v;
        //modelo.agregar(this);
        vista.mostrarAreas(modelo.getSubAreas().getAreas());
    }

    public Sistema getModelo() {
        return modelo;
    }

    //me tiene que llegar un sector por parametro
    //como me llega un sector no tengo porque ir a la fachada, le pido al sector de una que me de un numero
    public void pedirNumero(Sector s, int numeroDeCliente) {
        try {
            //Voy a buscar al cliente, en caso de que el cliente no exista tira una exception
            Cliente cli = modelo.buscarCliente(numeroDeCliente);
            //Por ahora cuando pido un numero me terminan devolviendo ese numero
            //Capaz que no necesito estoy nada mas tengo que llamar a pedir numero
            NumeroAtencion na = s.pedirNumero(cli);
            vista.mostrarNumeroCliente(na);
        } catch (ObligatorioException ex) {
            vista.mostrarError(ex.getMessage());
        }
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
        switch ((NumeroAtencion.Eventos) evento) {
            case cambioValor:
                //vista.mostrarContador(modelo.getValor());
                break;
            case reset:
                break;
        }
    }
}
