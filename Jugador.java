public class Jugador {
    private String nombre;
    private String nickname;
    private int edad;
    private int[] puntajes;
    private int partidasJugadas;

    public Jugador(String nombre, String nickname, int edad) {
        this.nombre = nombre;
        this.nickname = nickname;
        this.edad = edad;
        this.puntajes = new int[10];
        this.partidasJugadas = 0;
    }

    public boolean registrarPartida(int puntaje) {
        if (partidasJugadas < 10 && puntaje >= 0 && puntaje <= 100) {
            puntajes[partidasJugadas] = puntaje;
            partidasJugadas++;
            return true;
        }
        return false;
    }

    public void consultarPuntajes() {
        if (partidasJugadas == 0) {
            System.out.println("No hay partidas registradas.");
            return;
        }
        for (int i = 0; i < partidasJugadas; i++) {
            System.out.println("Partida " + (i + 1) + ": " + puntajes[i] + " puntos");
        }
    }

    public int consultarPartida(int numeroPartida) {
        if (numeroPartida > 0 && numeroPartida <= partidasJugadas) {
            return puntajes[numeroPartida - 1];
        }
        return -1; 
    }

    public boolean modificarPuntaje(int numeroPartida, int nuevoPuntaje) {
        if (numeroPartida > 0 && numeroPartida <= partidasJugadas && nuevoPuntaje >= 0 && nuevoPuntaje <= 100) {
            puntajes[numeroPartida - 1] = nuevoPuntaje;
            return true;
        }
        return false;
    }

    public double calcularPromedio() {
        if (partidasJugadas == 0) return 0;
        double suma = 0;
        for (int i = 0; i < partidasJugadas; i++) {
            suma += puntajes[i];
        }
        return suma / partidasJugadas;
    }

    public int obtenerMejorPuntaje() {
        if (partidasJugadas == 0) return 0;
        int mayor = puntajes[0];
        for (int i = 1; i < partidasJugadas; i++) {
            if (puntajes[i] > mayor) {
                mayor = puntajes[i];
            }
        }
        return mayor;
    }

    public int obtenerPeorPuntaje() {
        if (partidasJugadas == 0) return 0;
        int menor = puntajes[0];
        for (int i = 1; i < partidasJugadas; i++) {
            if (puntajes[i] < menor) {
                menor = puntajes[i];
            }
        }
        return menor;
    }

    public int getPartidasJugadas() {
        return partidasJugadas;
    }

    public int getPartidasDisponibles() {
        return 10 - partidasJugadas;
    }
}