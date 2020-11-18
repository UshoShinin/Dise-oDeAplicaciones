package modelo;


public class Trabajador {

    private int cedula;
    private String pass;
    private String nombreCompleto;
    private Sector sector;
    
    
    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }

    public Trabajador(int cedula, String pass, String nombreCompleto, Sector sector) {
        this.cedula = cedula;
        this.pass = pass;
        this.nombreCompleto = nombreCompleto;
        this.sector = sector;
    }
    
    
    
}
