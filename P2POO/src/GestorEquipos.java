import java.time.LocalDate;
import java.util.*;
import javax.swing.*;

public class GestorEquipos {
    private LinkedList<Equipo> equipos;

    public GestorEquipos() {
        equipos = new LinkedList<>();
    }

    public LinkedList<Equipo> getEquipos() {
        return equipos;
    }

    public void agregarEquipo(Equipo equipo) {
        equipos.add(equipo);
    }

    public void eliminarEquipo(String nombreEquipo) {
        equipos.removeIf(equipo -> equipo.getNombre().equals(nombreEquipo));
    }

    public Equipo buscarEquipo(String nombreEquipo) {
        for (Equipo equipo : equipos) {
            if (equipo.getNombre().equals(nombreEquipo)) {
                return equipo;
            }
        }
        return null;
    }
    
    public static void iniciarTorneo(List<Equipo> equipos) {
        List<Equipo> cuartosFinal = new ArrayList<>(equipos);
        List<Equipo> semiFinal = new ArrayList<>();
        List<Equipo> finalistas = new ArrayList<>();
        LocalDate fecha = LocalDate.of(2024, 4, 10);

        // Cuartos
        for (int i = 0; i < 4; i++) {
            Equipo equipo1 = cuartosFinal.get(i * 2);
            Equipo equipo2 = cuartosFinal.get(i * 2 + 1);
            Partido partido = new Partido(equipo1, equipo2, "Cuartos", i + 1, fecha.toString());
            partido.jugar();
            Equipo ganador = partido.getGanador();
            semiFinal.add(ganador);
        }

        // Semifinales
        for (int i = 0; i < 2; i++) {
            Equipo equipo1 = semiFinal.get(i * 2);
            Equipo equipo2 = semiFinal.get(i * 2 + 1);
            LocalDate fechaModificada = fecha.plusMonths(1);
            Partido partido = new Partido(equipo1, equipo2, "Semifinal", i + 1, fechaModificada.toString());
            partido.jugar();
            Equipo ganador = partido.getGanador();
            finalistas.add(ganador);
        }

        // Final
        Equipo equipo1 = finalistas.get(0);
        Equipo equipo2 = finalistas.get(1);
        LocalDate fechaFinal = LocalDate.now();
        Partido partidoFinal = new Partido(equipo1, equipo2, "Final", 1, fechaFinal.toString());
        partidoFinal.jugar();
        Equipo campeon = partidoFinal.getGanador();

        if (campeon != null) {
            ImageIcon icon = new ImageIcon(Main.class.getResource("copa.jpg"));
            JOptionPane.showMessageDialog(null, "El campeón del torneo es " + campeon.getNombre() + "!", "Campeón del Torneo", JOptionPane.INFORMATION_MESSAGE, icon);
        } else {
            JOptionPane.showMessageDialog(null, "El torneo terminó en empate.");
        }
    }
}