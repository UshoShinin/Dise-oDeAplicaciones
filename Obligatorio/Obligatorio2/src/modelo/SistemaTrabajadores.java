package modelo;

import java.util.ArrayList;


public class SistemaTrabajadores {

   private ArrayList<Trabajador> trabajadores;

   
   public SistemaTrabajadores(){
       this.trabajadores = new ArrayList<>();
   }
   
   
    //POR AHORA DEJO EL METODO ASI, HAY QUE VER COMO ES QUE SE ARMA LA EXCEPCION 
   //PARA DECIRLE QUE LA PASS ESTA MAL
    public Trabajador login(String user, String pass) throws ObligatorioException {
        if(user.isEmpty() || pass.isEmpty()) throw new ObligatorioException("Debe rellenar los campos");
        Trabajador tra = buscarTrabajador(Integer.parseInt(user));
        if(tra == null || !tra.getPass().equals(pass)) throw new ObligatorioException("Los datos de ingreso no son correctos");
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

    public ArrayList<Trabajador> getTrabajadores() {
        return trabajadores;
    }

    
    
}
