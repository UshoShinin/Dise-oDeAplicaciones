/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author Intel i7
 */
public class Sistema {
    private static Sistema sistema= new Sistema();
    private SistemaAreas SubAreas;
    private SistemaClientes SubClientes;
    private SistemaTrabajadores SubTrabajadores;
    private static boolean DatosCargados;

    private Sistema() {
        this.SubAreas = new SistemaAreas();
        this.SubClientes = new SistemaClientes();
        this.SubTrabajadores = new SistemaTrabajadores();
        DatosCargados = false;
    }
    
    public static Sistema getInstancia(){
        if(!DatosCargados)sistema.CargaDeDatos();
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

    
    //Abajo de aca voy dejando los metodos que vamos a tener que implementar
    
    public Trabajador loginTrabajador(String user, String pass) throws ObligatorioException {
        return SubTrabajadores.login(user, pass);
    }

    public Cliente buscarCliente(int numeroDeCliente) throws ObligatorioException {
        return SubClientes.buscarCliente(numeroDeCliente);
    }
    
    private void CargaDeDatos(){
        DatosCargados=true;
        //PrecargaTrabajadores;
        Sector S =new Sector("S1",3);
        Trabajador T1 = new Trabajador(1, "1", "Pepe ElCapo", S);
        Trabajador T2 = new Trabajador(2, "2", "Nestor ElCapo", S);
        Trabajador T3 = new Trabajador(3, "3", "Guille ElCapo", S);
                
        SubTrabajadores.getTrabajadores().add(T1);
        S.AgregarTrabajador(T1);
        SubTrabajadores.getTrabajadores().add(T2);
        S.AgregarTrabajador(T2);
        SubTrabajadores.getTrabajadores().add(T3);
        S.AgregarTrabajador(T3);
        
        //Precarga Areas
        ArrayList<Sector> sectores1 = new ArrayList<Sector>();
        ArrayList<Sector> sectores2 = new ArrayList<Sector>();
        ArrayList<Sector> sectores3 = new ArrayList<Sector>();
        ArrayList<Sector> sectores4 = new ArrayList<Sector>();
        
        sectores1.add(S);
        sectores1.add(new Sector("S2",4));
        sectores1.add(new Sector("S3",5));

        sectores2.add(new Sector("S4",1));
        sectores2.add(new Sector("S5",2));
        sectores2.add(new Sector("S6",3));
        sectores2.add(new Sector("S7",4));

        sectores3.add(new Sector("S8",5));
        sectores3.add(new Sector("S9",6));
        sectores3.add(new Sector("S10",7));

        sectores4.add(new Sector("S11",2));
        sectores4.add(new Sector("S12",3));
        sectores4.add(new Sector("S13",4));
        sectores4.add(new Sector("S14",5));
        sectores4.add(new Sector("S15",6));

        SubAreas.getAreas().add(new Area("Area 1",sectores1));
        SubAreas.getAreas().add(new Area("Area 2",sectores2));
        SubAreas.getAreas().add(new Area("Area 3",sectores3));
        SubAreas.getAreas().add(new Area("Area 4",sectores4));

        
       
        Cliente c1 = new Cliente(12,"Pablo","pablitocapito1212@gmail.com");
        SubClientes.getClientes().add(c1);
        
    }
  
}
