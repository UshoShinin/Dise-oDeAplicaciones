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
        Area A1 =new Area("Area 1");
        Area A2 =new Area("Area 2");
        Area A3 =new Area("Area 3");
        Area A4 =new Area("Area 4");
        //PrecargaTrabajadores;
        Sector S =new Sector("S1",1,A1);
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
        A1.AgragarSector(S);
        A1.AgragarSector(new Sector("S2",4,A1));
        A1.AgragarSector(new Sector("S3",5,A1));

        A2.AgragarSector(new Sector("S4",1,A2));
        A2.AgragarSector(new Sector("S5",2,A2));
        A2.AgragarSector(new Sector("S6",3,A2));
        A2.AgragarSector(new Sector("S7",4,A2));

        A3.AgragarSector(new Sector("S8",5,A3));
        A3.AgragarSector(new Sector("S9",6,A3));
        A3.AgragarSector(new Sector("S10",7,A3));
        
        A4.AgragarSector(new Sector("S11",2,A4));
        A4.AgragarSector(new Sector("S12",3,A4));
        A4.AgragarSector(new Sector("S13",4,A4));
        A4.AgragarSector(new Sector("S14",5,A4));
        A4.AgragarSector(new Sector("S15",6,A4));

        SubAreas.getAreas().add(A1);
        SubAreas.getAreas().add(A2);
        SubAreas.getAreas().add(A3);
        SubAreas.getAreas().add(A4);
        
        ConCosto tipo1 = new ConCosto();
        Exonerado tipo2 = new Exonerado();
        Gestor tipo3 = new Gestor();
        
        Cliente c1 = new Cliente(12,"Pablo","pablitocapito1212@gmail.com", tipo1);
        Cliente c2 = new Cliente(13,"Pepe","pepeelcapo@gmail.com", tipo2);
        Cliente c3 = new Cliente(14,"Nestor","enbloque@gmail.com", tipo3);
        SubClientes.getClientes().add(c1);
        SubClientes.getClientes().add(c2);
        SubClientes.getClientes().add(c3);
    }
  
}
