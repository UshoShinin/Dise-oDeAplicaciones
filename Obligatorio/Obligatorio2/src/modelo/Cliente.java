package modelo;


public class Cliente {
    
    private int cedula;
    private String nombreCompleto;
    private String email;

    public Cliente(int cedula, String nombreCompleto, String email) {
        this.cedula = cedula;
        this.nombreCompleto = nombreCompleto;
        this.email = email;
    }

    
    
    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
    
}
