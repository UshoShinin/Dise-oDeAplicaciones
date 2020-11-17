package modelo;

import java.util.ArrayList;


public class SistemaClientes {
    
    private ArrayList<Cliente> clientes;

    
    Cliente buscarCliente(int numeroDeCliente) throws ObligatorioException {
        for (Cliente cliente : clientes) {
            if(cliente.getCedula() == numeroDeCliente){
                return cliente;
            }
        }
        throw new ObligatorioException("Numero de cliente incorrecto");
    }
    
}
