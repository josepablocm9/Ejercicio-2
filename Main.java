import java.util.Scanner;

public class DriverProgram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Jugador jugadorActual = null;
        int opcion = 0;

        while (opcion != 9) {
            System.out.println("\n--- Torneo Universitario de Videojuegos ---");
            System.out.println("1. Nuevo jugador");
            System.out.println("2. Registrar nueva partida");
            System.out.println("3. Consultar puntajes");
            System.out.println("4. Consultar una partida");
            System.out.println("5. Modificar puntaje");
            System.out.println("6. Mostrar promedio");
            System.out.println("7. Mostrar mejor y peor puntaje");
            System.out.println("8. Consultar partidas disponibles");
            System.out.println("9. Salir");
            System.out.print("Seleccione una opción: ");
            
            opcion = scanner.nextInt();
            scanner.nextLine(); 

            if (opcion > 1 && opcion < 9 && jugadorActual == null) {
                System.out.println("Error: Primero debe registrar un jugador (Opción 1).");
                continue;
            }

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese nickname: ");
                    String nickname = scanner.nextLine();
                    System.out.print("Ingrese edad: ");
                    int edad = scanner.nextInt();
                    jugadorActual = new Jugador(nombre, nickname, edad);
                    System.out.println("Jugador registrado con éxito.");
                    break;
                case 2:
                    System.out.print("Ingrese el puntaje (0-100): ");
                    int puntaje = scanner.nextInt();
                    if (jugadorActual.registrarPartida(puntaje)) {
                        System.out.println("Partida registrada.");
                    } else {
                        System.out.println("Error: Puntaje inválido o no hay espacio disponible.");
                    }
                    break;
                case 3:
                    jugadorActual.consultarPuntajes();
                    break;
                case 4:
                    System.out.print("Ingrese el número de partida a consultar: ");
                    int numPartida = scanner.nextInt();
                    int resultado = jugadorActual.consultarPartida(numPartida);
                    if (resultado != -1) {
                        System.out.println("Puntaje de la partida " + numPartida + ": " + resultado);
                    } else {
                        System.out.println("Error: Partida no registrada.");
                    }
                    break;
                case 5:
                    System.out.print("Ingrese el número de partida a modificar: ");
                    int partidaMod = scanner.nextInt();
                    System.out.print("Ingrese el nuevo puntaje (0-100): ");
                    int nuevoPunt = scanner.nextInt();
                    if (jugadorActual.modificarPuntaje(partidaMod, nuevoPunt)) {
                        System.out.println("Puntaje modificado con éxito.");
                    } else {
                        System.out.println("Error: Partida no existe o puntaje inválido.");
                    }
                    break;
                case 6:
                    System.out.println("Promedio de puntajes: " + jugadorActual.calcularPromedio());
                    break;
                case 7:
                    System.out.println("Mejor puntaje: " + jugadorActual.obtenerMejorPuntaje());
                    System.out.println("Peor puntaje: " + jugadorActual.obtenerPeorPuntaje());
                    break;
                case 8:
                    System.out.println("Partidas jugadas: " + jugadorActual.getPartidasJugadas());
                    System.out.println("Partidas disponibles: " + jugadorActual.getPartidasDisponibles());
                    break;
                case 9:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }
        scanner.close();
    }
}