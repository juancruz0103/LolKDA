import java.util.LinkedList;

class GestorEquipos {
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
}