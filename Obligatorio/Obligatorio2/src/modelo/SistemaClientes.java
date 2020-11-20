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

    Cliente buscarCliente(String numeroDeCliente) throws ObligatorioException {
        try {
            int numCliente = Integer.parseInt(numeroDeCliente);
            for (Cliente cliente : clientes) {
                if (cliente.getCedula() == numCliente) {
                    return cliente;
                }
            }
        } catch (Exception e) {
            throw new ObligatorioException("Debe ingresar una cedula correcta");
        }
        throw new ObligatorioException("Numero de cliente incorrecto");
    }

}
