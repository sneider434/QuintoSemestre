package Base_De_Datos.VUELOS;
public class Puesto {

    private int numero;
    private boolean ocupado;
    private String nombrePasajero;
    private String documentoPasajero;

    public Puesto(int numero) {
        this.numero = numero;
        this.ocupado = false;
        this.nombrePasajero = null;
        this.documentoPasajero = null;
    }

    public int getNumero() {
        return numero;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public String getNombrePasajero() {
        return nombrePasajero;
    }

    public String getDocumentoPasajero() {
        return documentoPasajero;
    }


    public void asignarPasajero(String nombre, String documento) {
        this.nombrePasajero = nombre;
        this.documentoPasajero = documento;
        this.ocupado = true;
    }


    public String getEstadoTexto() {
        return ocupado ? "O" : "D";
    }
}