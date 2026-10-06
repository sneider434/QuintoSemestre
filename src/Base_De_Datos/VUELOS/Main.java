package Base_De_Datos.VUELOS;

import java.util.Scanner;


public class Main {

    private static Scanner sc = new Scanner(System.in);
    private static ListaVuelos vuelos = new ListaVuelos();

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = leerEntero("Seleccione una opción: ");
            switch (opcion) {
                case 1:
                    registrarVuelo();
                    break;
                case 2:
                    asignarPuesto();
                    break;
                case 3:
                    iniciarAbordaje();
                    break;
                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);

        sc.close();
    }

    private static void mostrarMenu() {
        System.out.println();
        System.out.println("========== AEROPUERTO ==========");
        System.out.println("1. Registrar vuelo");
        System.out.println("2. Asignar puesto");
        System.out.println("3. Iniciar abordaje");
        System.out.println("0. Salir");
    }


    private static void registrarVuelo() {
        System.out.println();
        System.out.println("===== REGISTRAR VUELO =====");

        String codigo;
        while (true) {
            System.out.print("Código del vuelo: ");
            codigo = sc.nextLine().trim();

            if (codigo.isEmpty()) {
                System.out.println("El código no puede estar vacío.");
                continue;
            }
            if (vuelos.existeCodigo(codigo)) {
                System.out.println("Ya existe un vuelo con ese código. Ingrese otro.");
                continue;
            }
            break;
        }

        System.out.print("Ciudad de destino: ");
        String ciudad = sc.nextLine().trim();

        System.out.print("País de destino: ");
        String pais = sc.nextLine().trim();

        System.out.print("Hora de salida (ej: 10:30 AM): ");
        String hora = sc.nextLine().trim();

        System.out.print("Duración estimada (ej: 1 hora 15 minutos): ");
        String duracion = sc.nextLine().trim();

        Vuelo nuevoVuelo = new Vuelo(codigo, ciudad, pais, hora, duracion);
        vuelos.agregar(nuevoVuelo);

        System.out.println("Vuelo registrado exitosamente.");
    }

    private static void asignarPuesto() {
        if (vuelos.estaVacia()) {
            System.out.println("No hay vuelos registrados.");
            return;
        }

        Vuelo vueloSeleccionado = seleccionarVueloDeLista();
        if (vueloSeleccionado == null) {
            return;
        }

        boolean continuar = true;
        while (continuar) {
            mostrarInfoVuelo(vueloSeleccionado);

            int numeroPuesto = leerEntero("Seleccione el número de puesto (0 para cancelar): ");

            if (numeroPuesto == 0) {
                continuar = false;
                break;
            }

            if (!vueloSeleccionado.numeroPuestoValido(numeroPuesto)) {
                System.out.println("El puesto debe estar entre 1 y 20.");
                continue;
            }

            Puesto puesto = vueloSeleccionado.getPuesto(numeroPuesto);
            if (puesto.isOcupado()) {
                System.out.println("El puesto " + numeroPuesto + " no se encuentra disponible. Seleccione otro.");
                continue;
            }

            System.out.print("Nombre del pasajero: ");
            String nombre = sc.nextLine().trim();
            System.out.print("Documento del pasajero: ");
            String documento = sc.nextLine().trim();

            puesto.asignarPasajero(nombre, documento);
            System.out.println("Puesto " + numeroPuesto + " asignado correctamente a " + nombre + ".");

            String resp = leerRespuestaSiNo("¿Desea asignar otro puesto en este vuelo? (S/N): ");
            continuar = resp.equalsIgnoreCase("S");
        }
    }


    private static Vuelo seleccionarVueloDeLista() {
        System.out.println();
        System.out.println("========== Base_De_Datos.Base_De_Datos.VUELOS ==========");
        System.out.println();

        int total = vuelos.getTamano();
        for (int i = 0; i < total; i++) {
            Vuelo v = vuelos.obtenerPorIndice(i);
            System.out.println((i + 1) + ". " + v.getCodigo() + " - " + v.getCiudadDestino());
        }
        System.out.println();

        int indiceElegido = leerEntero("Seleccione un vuelo (0 para cancelar): ");
        if (indiceElegido == 0) {
            return null;
        }
        if (indiceElegido < 1 || indiceElegido > total) {
            System.out.println("Selección no válida.");
            return null;
        }

        return vuelos.obtenerPorIndice(indiceElegido - 1);
    }

    private static void mostrarInfoVuelo(Vuelo v) {
        System.out.println();
        System.out.println("====================================");
        System.out.println("          VUELO SELECCIONADO");
        System.out.println("====================================");
        System.out.println();
        System.out.println("Vuelo: " + v.getCodigo());
        System.out.println("Destino: " + v.getCiudadDestino());
        System.out.println("Hora de salida: " + v.getHoraSalida());
        System.out.println("Duración: " + v.getDuracion());
        System.out.println();
        System.out.println("Puestos:");
        System.out.println();
        v.imprimirMapaPuestos();
        System.out.println();
        System.out.println("D = Disponible");
        System.out.println("O = Ocupado");
        System.out.println("====================================");
        System.out.println();
    }


    private static void iniciarAbordaje() {
        if (vuelos.estaVacia()) {
            System.out.println("No hay vuelos registrados.");
            return;
        }

        NodoVuelo actual = vuelos.getCabeza();
        while (actual != null) {
            Vuelo v = actual.getVuelo();

            System.out.println();
            System.out.println("====================================");
            System.out.println("          VUELO ACTUAL");
            System.out.println("====================================");
            System.out.println();
            System.out.println("Vuelo: " + v.getCodigo());
            System.out.println("Destino: " + v.getCiudadDestino());
            System.out.println("Hora de salida: " + v.getHoraSalida());
            System.out.println("Duración: " + v.getDuracion());
            System.out.println();
            System.out.println("Puestos ocupados: " + v.contarOcupados());
            System.out.println("Puestos disponibles: " + v.contarDisponibles());
            System.out.println();

            actual = actual.getSiguiente();

            if (actual != null) {
                System.out.print("Presione una tecla para continuar...");
                sc.nextLine();
            }
        }

        System.out.println();
        System.out.println("Todos los vuelos han sido procesados.");
        System.out.println("Finalizando ejecución del programa...");
        System.exit(0);
    }


    private static int leerEntero(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String entrada = sc.nextLine().trim();
            try {
                return Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un número válido.");
            }
        }
    }

    private static String leerRespuestaSiNo(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String entrada = sc.nextLine().trim();
            if (entrada.equalsIgnoreCase("S") || entrada.equalsIgnoreCase("N")) {
                return entrada;
            }
            System.out.println("Responda S o N.");
        }
    }
}