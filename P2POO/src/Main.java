import javax.swing.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    private static final String[] FASES = {"Cuartos de Final", "Semifinales", "Final"};

    public static void main(String[] args) {
        GestorEquipos gestor = new GestorEquipos();
        Equipo skt1 = new Equipo("SKT1", "Korea");
        Equipo g2 = new Equipo("G2", "Alemania");
        Equipo fanatic = new Equipo("Fanatic", "Europa");
        Equipo cloud9 = new Equipo("Cloud9", "EEUU");
        Equipo invictus = new Equipo("Invictus", "China");
        Equipo madLions = new Equipo("MAD Lions", "España");
        Equipo funPlus = new Equipo("FunPlus", "China");
        Equipo jd = new Equipo("JD", "China");

        skt1.agregarJugador(new Jugador("Faker", "MID", 24));
        skt1.agregarJugador(new Jugador("Teddy", "ADC", 22));
        skt1.agregarJugador(new Jugador("Canna", "TOP", 21));
        skt1.agregarJugador(new Jugador("Effort", "SOPORTE", 23));
        skt1.agregarJugador(new Jugador("Cuzz", "JUNGLA", 22));

        g2.agregarJugador(new Jugador("Caps", "MID", 23));
        g2.agregarJugador(new Jugador("Perkz", "ADC", 25));
        g2.agregarJugador(new Jugador("Wunder", "TOP", 24));
        g2.agregarJugador(new Jugador("Mikyx", "SOPORTE", 22));
        g2.agregarJugador(new Jugador("Jankos", "JUNGLA", 25));

        fanatic.agregarJugador(new Jugador("Rekkles", "ADC", 24));
        fanatic.agregarJugador(new Jugador("Bwipo", "TOP", 22));
        fanatic.agregarJugador(new Jugador("Selfmade", "JUNGLA", 23));
        fanatic.agregarJugador(new Jugador("Hylissang", "SOPORTE", 24));
        fanatic.agregarJugador(new Jugador("Nemesis", "MID", 22));

        cloud9.agregarJugador(new Jugador("Zven", "ADC", 24));
        cloud9.agregarJugador(new Jugador("Licorice", "TOP", 23));
        cloud9.agregarJugador(new Jugador("Blaber", "JUNGLA", 22));
        cloud9.agregarJugador(new Jugador("Vulcan", "SOPORTE", 21));
        cloud9.agregarJugador(new Jugador("Nisqy", "MID", 23));

        invictus.agregarJugador(new Jugador("Rookie", "MID", 23));
        invictus.agregarJugador(new Jugador("JackeyLove", "ADC", 22));
        invictus.agregarJugador(new Jugador("TheShy", "TOP", 24));
        invictus.agregarJugador(new Jugador("Baolan", "SOPORTE", 23));
        invictus.agregarJugador(new Jugador("Ning", "JUNGLA", 22));

        madLions.agregarJugador(new Jugador("Humanoid", "MID", 22));
        madLions.agregarJugador(new Jugador("Carzzy", "ADC", 21));
        madLions.agregarJugador(new Jugador("Armut", "TOP", 23));
        madLions.agregarJugador(new Jugador("Kaiser", "SOPORTE", 22));
        madLions.agregarJugador(new Jugador("Elyoya", "JUNGLA", 20));

        funPlus.agregarJugador(new Jugador("Doinb", "MID", 24));
        funPlus.agregarJugador(new Jugador("Lwx", "ADC", 23));
        funPlus.agregarJugador(new Jugador("GimGoon", "TOP", 24));
        funPlus.agregarJugador(new Jugador("Crisp", "SOPORTE", 23));
        funPlus.agregarJugador(new Jugador("Tian", "JUNGLA", 21));

        jd.agregarJugador(new Jugador("Yagao", "MID", 23));
        jd.agregarJugador(new Jugador("LokeN", "ADC", 24));
        jd.agregarJugador(new Jugador("Zoom", "TOP", 24));
        jd.agregarJugador(new Jugador("LvMao", "SOPORTE", 22));
        jd.agregarJugador(new Jugador("Kanavi", "JUNGLA", 22));

        gestor.getEquipos().add(skt1);
        gestor.getEquipos().add(g2);
        gestor.getEquipos().add(fanatic);
        gestor.getEquipos().add(cloud9);
        gestor.getEquipos().add(invictus);
        gestor.getEquipos().add(madLions);
        gestor.getEquipos().add(funPlus);
        gestor.getEquipos().add(jd);

        while (true) {
            String[] options = {"Agregar Equipo", "Eliminar Equipo", "Buscar Equipo", "Listar Equipos",
                    "Agregar Jugador", "Eliminar Jugador", "Buscar Jugador", "Listar Jugadores",
                    "Simular Partido", "Iniciar Torneo", "Salir"};

            ImageIcon icon = new ImageIcon(Main.class.getResource("logoLOL.png"));

            String option = (String) JOptionPane.showInputDialog(null, "Selecciona una opción", "Gestor de Equipos",
                    JOptionPane.INFORMATION_MESSAGE, icon, options, options[0]);

            if (option == null || option.equals("Salir")) {
                break;
            }

            switch (option) {
                case "Agregar Equipo":
                    String nombreEquipo = JOptionPane.showInputDialog("Nombre del equipo:");
                    String ciudadEquipo = JOptionPane.showInputDialog("Pais del equipo:");
                    // String imagenEquipo = JOptionPane.showInputDialog("Nombre del archivo de la imagen del equipo:");
                    Equipo equipo = new Equipo(nombreEquipo, ciudadEquipo);
                    gestor.agregarEquipo(equipo);
                    break;

                case "Eliminar Equipo":
                    nombreEquipo = JOptionPane.showInputDialog("Nombre del equipo a eliminar:");
                    gestor.eliminarEquipo(nombreEquipo);
                    break;

                case "Buscar Equipo":
                    nombreEquipo = JOptionPane.showInputDialog("Nombre del equipo a buscar:");
                    Equipo equipoEncontrado = gestor.buscarEquipo(nombreEquipo);
                    JOptionPane.showMessageDialog(null, equipoEncontrado != null ? equipoEncontrado.toString() : "Equipo no encontrado.");
                    break;

                case "Listar Equipos":
                    LinkedList<Equipo> equiposList = gestor.getEquipos();
                    StringBuilder equiposStr = new StringBuilder("Equipos:\n");
                    for (Equipo e : equiposList) {
                        equiposStr.append(e.getNombre()).append(" - ").append(e.getCiudad()).append("\n");
                    }
                    JOptionPane.showMessageDialog(null, equiposStr.toString());
                    break;

                case "Agregar Jugador":
                    nombreEquipo = JOptionPane.showInputDialog("Nombre del equipo:");
                    Equipo equipoJugadores = gestor.buscarEquipo(nombreEquipo);
                    if (equipoJugadores != null) {
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
                        equipoJugadores.agregarJugador(jugador);
                    } else {
                        JOptionPane.showMessageDialog(null, "Equipo no encontrado.");
                    }
                    break;

                case "Eliminar Jugador":
                    nombreEquipo = JOptionPane.showInputDialog("Nombre del equipo:");
                    Equipo equipoEliminar = gestor.buscarEquipo(nombreEquipo);
                    if (equipoEliminar != null) {
                        String nombreJugador = JOptionPane.showInputDialog("Nombre del jugador a eliminar:");
                        equipoEliminar.eliminarJugador(nombreJugador);
                    } else {
                        JOptionPane.showMessageDialog(null, "Equipo no encontrado.");
                    }
                    break;

                case "Buscar Jugador":
                    nombreEquipo = JOptionPane.showInputDialog("Nombre del equipo:");
                    Equipo equipoBuscar = gestor.buscarEquipo(nombreEquipo);
                    if (equipoBuscar != null) {
                        String nombreJugador = JOptionPane.showInputDialog("Nombre del jugador a buscar:");
                        Jugador jugadorEncontrado = equipoBuscar.buscarJugador(nombreJugador);
                        JOptionPane.showMessageDialog(null, jugadorEncontrado != null ? jugadorEncontrado.toString() : "Jugador no encontrado.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Equipo no encontrado.");
                    }
                    break;

                case "Listar Jugadores":
                    nombreEquipo = JOptionPane.showInputDialog("Nombre del equipo:");
                    Equipo equipoListar = gestor.buscarEquipo(nombreEquipo);
                    if (equipoListar != null) {
                        LinkedList<Jugador> jugadoresList = equipoListar.getJugadores();
                        StringBuilder jugadoresStr = new StringBuilder("Jugadores de " + equipoListar.getNombre() + ":\n");
                        for (Jugador j : jugadoresList) {
                            jugadoresStr.append(j.getNombre()).append(" - ").append(j.getRol()).append(" - ").append(j.getEdad()).append(" años\n");
                        }
                        JOptionPane.showMessageDialog(null, jugadoresStr.toString());
                    } else {
                        JOptionPane.showMessageDialog(null, "Equipo no encontrado.");
                    }
                    break;

                case "Simular Partido":
                    nombreEquipo = JOptionPane.showInputDialog("Nombre del primer equipo:");
                    Equipo equipo1 = gestor.buscarEquipo(nombreEquipo);
                    if (equipo1 == null) {
                        JOptionPane.showMessageDialog(null, "Primer equipo no encontrado.");
                        break;
                    }
                    String nombreEquipo2 = JOptionPane.showInputDialog("Nombre del segundo equipo:");
                    Equipo equipo2 = gestor.buscarEquipo(nombreEquipo2);
                    if (equipo2 == null) {
                        JOptionPane.showMessageDialog(null, "Segundo equipo no encontrado.");
                        break;
                    }
                    Partido partido = new Partido(equipo1, equipo2, "Simulación", 1);
                    partido.jugar();
                    break;

                case "Iniciar Torneo":
                    List<Equipo> equiposTorneo = gestor.getEquipos();
                    if (equiposTorneo.size() != 8) {
                        JOptionPane.showMessageDialog(null, "El torneo requiere exactamente 8 equipos.");
                    } else {
                        iniciarTorneo(equiposTorneo);
                    }
                    break;

                default:
                    break;
            }
        }
    }

    private static void iniciarTorneo(List<Equipo> equipos) {
        List<Equipo> cuartosFinal = new ArrayList<>(equipos);
        List<Equipo> semiFinal = new ArrayList<>();
        List<Equipo> finalistas = new ArrayList<>();

        // Cuartos
        for (int i = 0; i < 4; i++) {
            Equipo equipo1 = cuartosFinal.get(i * 2);
            Equipo equipo2 = cuartosFinal.get(i * 2 + 1);
            Partido partido = new Partido(equipo1, equipo2, FASES[0], i + 1);
            partido.jugar();
            Equipo ganador = partido.getGanador();
            semiFinal.add(ganador);
        }

        // Semifinales
        for (int i = 0; i < 2; i++) {
            Equipo equipo1 = semiFinal.get(i * 2);
            Equipo equipo2 = semiFinal.get(i * 2 + 1);
            Partido partido = new Partido(equipo1, equipo2, FASES[1], i + 1);
            partido.jugar();
            Equipo ganador = partido.getGanador();
            finalistas.add(ganador);
        }

        // Final
        Equipo equipo1 = finalistas.get(0);
        Equipo equipo2 = finalistas.get(1);
        Partido partidoFinal = new Partido(equipo1, equipo2, FASES[2], 1);
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
