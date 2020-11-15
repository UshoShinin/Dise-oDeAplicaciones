/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Intel i7
 */
public class Sistema {
    private Sistema sistema;
    private SistemaAreas SubAreas;
    private SistemaClientes SubClientes;
    private SistemaTrabajadores SubTrabajadores;

    public Sistema() {
        this.SubAreas = new SistemaAreas();
        this.SubClientes = new SistemaClientes();
        this.SubTrabajadores = new SistemaTrabajadores();
    }
    
    public Sistema getInstancia(){
        return sistema;
    }
    
    public SistemaAreas getSubAreas() {
        return SubAreas;
    }

    public void setSubAreas(SistemaAreas SubAreas) {
        this.SubAreas = SubAreas;
    }

    public SistemaClientes getSubClientes() {
        return SubClientes;
    }

    public void setSubClientes(SistemaClientes SubClientes) {
        this.SubClientes = SubClientes;
    }

    public SistemaTrabajadores getSubTrabajadores() {
        return SubTrabajadores;
    }

    public void setSubTrabajadores(SistemaTrabajadores SubTrabajadores) {
        this.SubTrabajadores = SubTrabajadores;
    }
    
    
}
