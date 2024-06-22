import javax.swing.*;

public class Partido {
    private Equipo equipo1;
    private Equipo equipo2;
    private String fase;
    private int numPartido;
    private int marcador1;
    private int marcador2;
    private Jugador mvp;
    private int mvpKills;
    private int mvpDeaths;
    private int mvpAssists;

    public Partido(Equipo equipo1, Equipo equipo2, String fase, int numPartido) {
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.fase = fase;
        this.numPartido = numPartido;
    }

    public void jugar() {
        this.marcador1 = (int) (Math.random() * 10);
        this.marcador2 = (int) (Math.random() * 10);

        // Determinar MVP y KDA
        if (Math.random() < 0.5) {
            this.mvp = equipo1.getJugadores().get((int) (Math.random() * equipo1.getJugadores().size()));
        } else {
            this.mvp = equipo2.getJugadores().get((int) (Math.random() * equipo2.getJugadores().size()));
        }
        this.mvpKills = (int) (Math.random() * 20);
        this.mvpDeaths = (int) (Math.random() * 10);
        this.mvpAssists = (int) (Math.random() * 15);

        mostrarResultado();
    }

    private void mostrarResultado() {
        String resultado = String.format("Fase: %s\nPartido %d\n%s %d - %d %s\n",
                fase, numPartido, equipo1.getNombre(), marcador1, marcador2, equipo2.getNombre());
        resultado += String.format("MVP: %s (KDA: %d/%d/%d)", mvp.getNombre(), mvpKills, mvpDeaths, mvpAssists);
        JOptionPane.showMessageDialog(null, resultado);
    }

    public Equipo getGanador() {
        return marcador1 > marcador2 ? equipo1 : equipo2;
    }
}
