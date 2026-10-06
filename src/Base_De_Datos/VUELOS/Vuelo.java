package Base_De_Datos.VUELOS;

public class Vuelo {

    public static final int TOTAL_PUESTOS = 20;

    private String codigo;
    private String ciudadDestino;
    private String paisDestino;
    private String horaSalida;
    private String duracion;

    // Arreglo normal de tamaño fijo (20 puestos numerados de 1 a 20)
    private Puesto[] puestos;

    public Vuelo(String codigo, String ciudadDestino, String paisDestino,
                 String horaSalida, String duracion) {
        this.codigo = codigo;
        this.ciudadDestino = ciudadDestino;
        this.paisDestino = paisDestino;
        this.horaSalida = horaSalida;
        this.duracion = duracion;

        this.puestos = new Puesto[TOTAL_PUESTOS];
        for (int i = 0; i < TOTAL_PUESTOS; i++) {
            // Puesto en la posición i corresponde al número (i + 1)
            this.puestos[i] = new Puesto(i + 1);
        }
    }

    public String getCodigo() {
        return codigo;
    }

    public String getCiudadDestino() {
        return ciudadDestino;
    }

    public String getPaisDestino() {
        return paisDestino;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public String getDuracion() {
        return duracion;
    }

    public Puesto[] getPuestos() {
        return puestos;
    }


    public Puesto getPuesto(int numero) {
        return puestos[numero - 1];
    }

    public boolean numeroPuestoValido(int numero) {
        return numero >= 1 && numero <= TOTAL_PUESTOS;
    }

    public int contarOcupados() {
        int contador = 0;
        for (int i = 0; i < puestos.length; i++) {
            if (puestos[i].isOcupado()) {
                contador++;
            }
        }
        return contador;
    }

    public int contarDisponibles() {
        return TOTAL_PUESTOS - contarOcupados();
    }

    public void imprimirMapaPuestos() {
        for (int i = 0; i < TOTAL_PUESTOS; i++) {
            Puesto p = puestos[i];
            System.out.printf("%2d[%s]  ", p.getNumero(), p.getEstadoTexto());
            // Salto de línea cada 5 puestos, y línea en blanco cada 10
            if ((i + 1) % 5 == 0) {
                System.out.println();
                if ((i + 1) % 10 == 0 && (i + 1) != TOTAL_PUESTOS) {
                    System.out.println();
                }
            }
        }
    }
}