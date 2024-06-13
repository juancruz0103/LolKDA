import javax.swing.*;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        GestorEquipos gestor = new GestorEquipos();

        while (true) {
            String[] options = {"Agregar Equipo", "Eliminar Equipo", "Buscar Equipo", "Listar Equipos", "Agregar Jugador", "Eliminar Jugador", "Buscar Jugador", "Listar Jugadores", "Simular Partido", "Salir"};
            
            ImageIcon icon = new ImageIcon(Main.class.getResource("logoLOL.png"));

            String option = (String) JOptionPane.showInputDialog(null, "Selecciona una opción", "Gestor de Equipos",
                    JOptionPane.INFORMATION_MESSAGE, icon, options, options[0]);

            if (option == null || option.equals("Salir")) {
                break;
            }

            switch (option) {
                case "Agregar Equipo":
                    String nombreEquipo = JOptionPane.showInputDialog("Nombre del equipo:");
                    String ciudadEquipo = JOptionPane.showInputDialog("Ciudad del equipo:");
                    Equipo equipo = new Equipo(nombreEquipo, ciudadEquipo);
                    gestor.agregarEquipo(equipo);
                    break;

                case "Eliminar Equipo":
                    nombreEquipo = JOptionPane.showInputDialog("Nombre del equipo a eliminar:");
                    gestor.eliminarEquipo(nombreEquipo);
                    break;

                case "Buscar Equipo":
                    nombreEquipo = JOptionPane.showInputDialog("Nombre del equipo a buscar:");
                    equipo = gestor.buscarEquipo(nombreEquipo);
                    JOptionPane.showMessageDialog(null, equipo != null ? equipo.toString() : "Equipo no encontrado.");
                    break;

                case "Listar Equipos":
                    LinkedList<Equipo> equipos = gestor.getEquipos();
                    StringBuilder equiposList = new StringBuilder("Equipos:\n");
                    for (Equipo e : equipos) {
                        equiposList.append(e.getNombre()).append(" - ").append(e.getCiudad()).append("\n");
                    }
                    JOptionPane.showMessageDialog(null, equiposList.toString());
                    break;

                case "Agregar Jugador":
                    nombreEquipo = JOptionPane.showInputDialog("Nombre del equipo:");
                    equipo = gestor.buscarEquipo(nombreEquipo);
                    if (equipo != null) {
                        String nombreJugador = JOptionPane.showInputDialog("Nombre del jugador:");
                        String[] roles = {"ADC", "TOP", "JUNGLA", "SOPORTE", "MID"};
                        int rolIndex = JOptionPane.showOptionDialog(null, "Selecciona el rol del jugador:", "Rol del Jugador",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, roles, roles[0]);
                        if (rolIndex == -1) {
                            JOptionPane.showMessageDialog(null, "No se seleccionó ningún rol. Operación cancelada.");
                            break;
                        }
                        String rol = roles[rolIndex];
                        int edad = Integer.parseInt(JOptionPane.showInputDialog("Edad:"));
                        Jugador jugador = new Jugador(nombreJugador, rol, edad);
                        equipo.agregarJugador(jugador);
                    } else {
                        JOptionPane.showMessageDialog(null, "Equipo no encontrado.");
                    }
                    break;

                case "Eliminar Jugador":
                    nombreEquipo = JOptionPane.showInputDialog("Nombre del equipo:");
                    equipo = gestor.buscarEquipo(nombreEquipo);
                    if (equipo != null) {
                        String nombreJugador = JOptionPane.showInputDialog("Nombre del jugador a eliminar:");
                        equipo.eliminarJugador(nombreJugador);
                    } else {
                        JOptionPane.showMessageDialog(null, "Equipo no encontrado.");
                    }
                    break;

                case "Buscar Jugador":
                    nombreEquipo = JOptionPane.showInputDialog("Nombre del equipo:");
                    equipo = gestor.buscarEquipo(nombreEquipo);
                    if (equipo != null) {
                        String nombreJugador = JOptionPane.showInputDialog("Nombre del jugador a buscar:");
                        Jugador jugador = equipo.buscarJugador(nombreJugador);
                        JOptionPane.showMessageDialog(null, jugador != null ? jugador.toString() : "Jugador no encontrado.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Equipo no encontrado.");
                    }
                    break;

                case "Listar Jugadores":
                    nombreEquipo = JOptionPane.showInputDialog("Nombre del equipo:");
                    equipo = gestor.buscarEquipo(nombreEquipo);
                    if (equipo != null) {
                        LinkedList<Jugador> jugadores = equipo.getJugadores();
                        StringBuilder jugadoresList = new StringBuilder("Jugadores:\n");
                        for (Jugador j : jugadores) {
                            jugadoresList.append(j.toString()).append("\n");
                        }
                        JOptionPane.showMessageDialog(null, jugadoresList.toString());
                    } else {
                        JOptionPane.showMessageDialog(null, "Equipo no encontrado.");
                    }
                    break;

                case "Simular Partido":
                    String equipo1Nombre = JOptionPane.showInputDialog("Nombre del primer equipo:");
                    Equipo equipo1 = gestor.buscarEquipo(equipo1Nombre);
                    String equipo2Nombre = JOptionPane.showInputDialog("Nombre del segundo equipo:");
                    Equipo equipo2 = gestor.buscarEquipo(equipo2Nombre);
                    if (equipo1 != null && equipo2 != null) {
                        gestor.jugarPartido(equipo1, equipo2);
                    } else {
                        JOptionPane.showMessageDialog(null, "Uno o ambos equipos no fueron encontrados.");
                    }
                    break;

                default:
                    break;
            }
        }
    }
}
