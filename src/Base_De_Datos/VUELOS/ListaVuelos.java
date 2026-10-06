package Base_De_Datos.VUELOS;

public class ListaVuelos {

    private NodoVuelo cabeza;
    private NodoVuelo cola;
    private int tamano;

    public ListaVuelos() {
        this.cabeza = null;
        this.cola = null;
        this.tamano = 0;
    }

    public int getTamano() {
        return tamano;
    }

    public boolean estaVacia() {
        return tamano == 0;
    }

    public NodoVuelo getCabeza() {
        return cabeza;
    }


    public void agregar(Vuelo vuelo) {
        NodoVuelo nuevo = new NodoVuelo(vuelo);
        if (cabeza == null) {
            cabeza = nuevo;
            cola = nuevo;
        } else {
            cola.setSiguiente(nuevo);
            cola = nuevo;
        }
        tamano++;
    }

    public boolean existeCodigo(String codigo) {
        return buscarPorCodigo(codigo) != null;
    }


    public Vuelo buscarPorCodigo(String codigo) {
        NodoVuelo actual = cabeza;
        while (actual != null) {
            if (actual.getVuelo().getCodigo().equalsIgnoreCase(codigo)) {
                return actual.getVuelo();
            }
            actual = actual.getSiguiente();
        }
        return null;
    }


    public Vuelo obtenerPorIndice(int indice) {
        if (indice < 0 || indice >= tamano) {
            return null;
        }
        NodoVuelo actual = cabeza;
        int contador = 0;
        while (actual != null) {
            if (contador == indice) {
                return actual.getVuelo();
            }
            contador++;
            actual = actual.getSiguiente();
        }
        return null;
    }
}