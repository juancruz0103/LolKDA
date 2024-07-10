import javax.swing.ImageIcon;
import java.util.ArrayList;
import java.util.List;

public class Equipo {
    private String nombre;
    private String pais;
    private List<Jugador> jugadores;
    private ImageIcon logo;

    public Equipo(String nombre, String ciudad, String rutaLogo) {
        this.nombre = nombre;
        this.pais = ciudad;
        this.jugadores = new ArrayList<>();
        this.logo = new ImageIcon(getClass().getResource(rutaLogo));
    }

    // Métodos getters y setters

    public Equipo(String nombreEquipo, String ciudadEquipo, Object rutaLogo) {
		// TODO Auto-generated constructor stub
	}

	public String getNombre() {
        return nombre;
    }

    public String getCiudad() {
        return pais;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public void agregarJugador(Jugador jugador) {
        jugadores.add(jugador);
    }

    public void eliminarJugador(String nombreJugador) {
        jugadores.removeIf(jugador -> jugador.getNombre().equals(nombreJugador));
    }

    public Jugador buscarJugador(String nombreJugador) {
        for (Jugador jugador : jugadores) {
            if (jugador.getNombre().equals(nombreJugador)) {
                return jugador;
            }
        }
        return null;
    }

    public ImageIcon getLogo() {
        return logo;
    }

    @Override
    public String toString() {
        return "Equipo{" +
                "nombre='" + nombre + '\'' +
                ", pais='" + pais + '\'' +
                ", jugadores=" + jugadores +
                '}';
    }
}