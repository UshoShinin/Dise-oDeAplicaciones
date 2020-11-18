package modelo;


public class Trabajador extends Persona{

    private String pass;
    private Sector sector;
    
    public Trabajador(int cedula,String pass,String nombreCompleto, Sector sector) {
        super(cedula,nombreCompleto);
        this.pass = pass;
        this.sector = sector;
    }
    
    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }


    @Override
    public String toString() {
        return "Trabajador{" + "cedula=" + getCedula() + ", pass=" + pass + ", nombreCompleto=" + getNombreCompleto() + '}';
    }
    
}
