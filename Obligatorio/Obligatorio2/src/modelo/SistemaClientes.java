package modelo;

import java.util.ArrayList;


public class SistemaClientes {
    
    private ArrayList<Cliente> clientes;

    public SistemaClientes() {
        this.clientes = new ArrayList<Cliente>();
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }
    
    
    
    Cliente buscarCliente(int numeroDeCliente) throws ObligatorioException {
        for (Cliente cliente : clientes) {
            if(cliente.getCedula() == numeroDeCliente){
                return cliente;
            }
        }
        throw new ObligatorioException("Numero de cliente incorrecto");
    }
    
}
