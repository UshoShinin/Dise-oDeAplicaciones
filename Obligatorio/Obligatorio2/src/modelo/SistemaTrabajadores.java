package modelo;

import java.util.ArrayList;


public class SistemaTrabajadores {

   private ArrayList<Trabajador> trabajadores;

   
   public SistemaTrabajadores(){
       this.trabajadores = new ArrayList<>();
       trabajadores.add(new Trabajador(1, "1", "Pepe ElCapo", null));
       trabajadores.add(new Trabajador(2, "2", "Nestor ElCapo", null));
       trabajadores.add(new Trabajador(3, "3", "Guille ElCapo", null));
   }
   
   
    //POR AHORA DEJO EL METODO ASI, HAY QUE VER COMO ES QUE SE ARMA LA EXCEPCION 
   //PARA DECIRLE QUE LA PASS ESTA MAL
    public Trabajador login(int user, String pass) throws ObligatorioException {
        Trabajador tra = buscarTrabajador(user);
        if(tra == null || tra.getPass() != pass) throw new ObligatorioException("Los datos de ingreso no son correctos");
        return tra;
    }
    
    
    private Trabajador buscarTrabajador(int user){
        for (Trabajador tra : trabajadores) {
            if (tra.getCedula() == user) {
                return tra;
            }
        }
        return null;
    }
    
}
