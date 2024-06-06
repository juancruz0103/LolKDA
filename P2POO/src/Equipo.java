import java.util.LinkedList;

public class Equipo {
    private String nombre;
    private String ciudad;
    private LinkedList<Jugador> jugadores ;

    public Equipo(String nombre, String ciudad) {
		this.nombre = nombre;
		this.ciudad = ciudad;
		this.jugadores = new LinkedList<>();
	}    

	public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void agregarJugador(Jugador jugador) {
        jugadores.add(jugador);
    }

    public void eliminarJugador(String nombre) {
        jugadores.removeIf(jugador -> jugador.getNombre().equals(nombre));
    }

    public Jugador buscarJugador(String nombre) {
        for (Jugador jugador : jugadores) {
            if (jugador.getNombre().equals(nombre)) {
                return jugador;
            }
        }
        return null;
    }

    public int getCantidadJugadores() {
        return jugadores.size();
    }

    public LinkedList<Jugador> getJugadores() {
        return jugadores;
    }

    @Override
    public String toString() {
        return "Equipo{" +
                "nombre='" + nombre + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", jugadores=" + jugadores +
                '}';
    }
}