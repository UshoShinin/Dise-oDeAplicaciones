package modelo;

import java.util.ArrayList;


public class SistemaClientes {
    
    private ArrayList<Cliente> clientes;

    public SistemaClientes() {
        this.clientes = new ArrayList<Cliente>();
        Cliente c1 = new Cliente(12,"Pablo","pablitocapito1212@gmail.com");
        clientes.add(c1);
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
