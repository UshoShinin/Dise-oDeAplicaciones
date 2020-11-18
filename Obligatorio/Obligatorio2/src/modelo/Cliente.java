package modelo;


public class Cliente extends Persona{
    
    private String email;
    private TipoCliente tipo;

    public Cliente(int cedula, String nombreCompleto, String email, TipoCliente tipo) {
        super(cedula,nombreCompleto);
        this.email = email;
        this.tipo = tipo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    public int calcularCostoAtencion(int costoFijo, int tiempoDeEspera){
        return tipo.calcularCosto(costoFijo, tiempoDeEspera);
    }
    
}
