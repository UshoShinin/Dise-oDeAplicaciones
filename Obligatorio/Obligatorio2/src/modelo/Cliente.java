package modelo;


public class Cliente extends Persona{
    
    private String email;

    public Cliente(int cedula, String nombreCompleto, String email) {
        super(cedula,nombreCompleto);
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
    
}
