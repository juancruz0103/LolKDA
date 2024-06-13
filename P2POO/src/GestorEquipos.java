
import java.util.LinkedList;
import javax.swing.JOptionPane;

public class GestorEquipos {
    private LinkedList<Equipo> equipos;

    public GestorEquipos() {
        this.equipos = new LinkedList<>();
    }

    public void agregarEquipo(Equipo equipo) {
        equipos.add(equipo);
    }

    public void eliminarEquipo(String nombre) {
        equipos.removeIf(equipo -> equipo.getNombre().equals(nombre));
    }

    public Equipo buscarEquipo(String nombre) {
        for (Equipo equipo : equipos) {
            if (equipo.getNombre().equals(nombre)) {
                return equipo;
            }
        }
        return null;
    }

    public int getCantidadEquipos() {
        return equipos.size();
    }

    public LinkedList<Equipo> getEquipos() {
        return equipos;
    }

    public void jugarPartido(Equipo equipo1, Equipo equipo2) {
        String resultado;
        int resultadoPartido = (int) (Math.random() * 3);
        if (resultadoPartido == 0) {
            resultado = "El equipo " + equipo1.getNombre() + " ha ganado el partido.";
        } else if (resultadoPartido == 1) {
            resultado = "El equipo " + equipo2.getNombre() + " ha ganado el partido.";
        } else {
            resultado = "El partido ha terminado en empate.";
        }
        JOptionPane.showMessageDialog(null, resultado);
    


	for (Jugador jugador : equipo1.getJugadores()) {
	    jugador.setKills((int) (Math.random() * 20));
	    jugador.setDeaths((int) (Math.random() * 20));
	    jugador.setAssists((int) (Math.random() * 20));
	}
	for (Jugador jugador : equipo2.getJugadores()) {
	    jugador.setKills((int) (Math.random() * 20));
	    jugador.setDeaths((int) (Math.random() * 20));
	    jugador.setAssists((int) (Math.random() * 20));
	}
	
	// Encontrar el jugador con el mejor KDA
	Jugador mvp = null;
    double maxKDA = -1;
    int mvpKills = 0;
    int mvpDeaths = 0;
    int mvpAssists = 0;
    
    for (Jugador jugador : equipo1.getJugadores()) {
        int kills = jugador.getKills();
        int deaths = jugador.getDeaths();
        int assists = jugador.getAssists();
        double kda = (double) (kills + assists) / (deaths == 0 ? 1 : deaths);
        
        if (kda > maxKDA) {
            maxKDA = kda;
            mvp = jugador;
            mvpKills = kills;
            mvpDeaths = deaths;
            mvpAssists = assists;
        }
    }
    
    for (Jugador jugador : equipo2.getJugadores()) {
        int kills = jugador.getKills();
        int deaths = jugador.getDeaths();
        int assists = jugador.getAssists();
        double kda = (double) (kills + assists) / (deaths == 0 ? 1 : deaths);
        
        if (kda > maxKDA) {
            maxKDA = kda;
            mvp = jugador;
            mvpKills = kills;
            mvpDeaths = deaths;
            mvpAssists = assists;
        }
    }
    
    String mvpMessage = "El MVP del partido es " + (mvp != null ? mvp.getNombre() + " con un KDA de " + mvpKills + "/" + mvpDeaths + "/" + mvpAssists : "N/A");
    JOptionPane.showMessageDialog(null, mvpMessage);
	}
    
}