package Controlador;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Cliente;
import modelo.NumeroAtencion;
import modelo.ObligatorioException;
import observador.*;
import modelo.Sector;
import modelo.Area;
import modelo.Sistema;

public class ControladorPedirNumero implements Observador {

    private Sistema modelo;
    //private ArrayList<Sector> sectores;
    private Sector S;
    private Area A;
    private VistaPedirNumero vista;

    public ControladorPedirNumero(Sistema modelo,VistaPedirNumero v,Area A) {
        this.modelo = modelo;
        this.A = A;
        vista = v;
        for(Sector S : A.getSectores()){
            S.agregar(this);
        }
        sectoresValidos();
    }

    public Sistema getModelo() {
        return modelo;
    }
    
    public Sector getS(){
        return S;
    }

    public void sectoresValidos(){
        ArrayList<Sector> sectores = A.conseguirSectoresValidos();
        vista.mostrarSectores(sectores);
    }
    //me tiene que llegar un sector por parametro
    //como me llega un sector no tengo porque ir a la fachada, le pido al sector de una que me de un numero
    public void pedirNumero(Sector s, int numeroDeCliente) {
        try {
            //Voy a buscar al cliente, en caso de que el cliente no exista tira una exception
            Cliente cli = modelo.buscarCliente(numeroDeCliente);
            //Por ahora cuando pido un numero me terminan devolviendo ese numero
            //Capaz que no necesito estoy nada mas tengo que llamar a pedir numero
            this.S = s;
            NumeroAtencion na = S.pedirNumero(cli);
            
        } catch (ObligatorioException ex) {
            vista.mostrarError(ex.getMessage());
        }
    }

    @Override
    public void actualizar(Observable origen, Object evento) {
        switch ((Sector.Eventos) evento) {
            case sacaronNumero:
                vista.mostrarNumeroCliente(S.getUltimo());
                break;
            case seMovioTrabajador:
                sectoresValidos();
                break;
        }
    }
}
