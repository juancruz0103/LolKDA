import java.time.LocalDate;
import java.util.Random;
import javax.swing.JOptionPane;

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
    private int tiempoPrimeraTorre;
    private int tiempoPrimerDragon;
    private int tiempoBaron;
    private int tiempoTotal;
    private String fecha;  // Fecha en formato de cadena
    
    public Partido(Equipo equipo1, Equipo equipo2, String fecha, int numPartido) {
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.numPartido = numPartido;
        this.fecha = fecha;
    }
    
    public Partido(Equipo equipo1, Equipo equipo2, String fase, int numPartido, String fecha) {
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.fase = fase;
        this.numPartido = numPartido;
        this.fecha = fecha;
    }
    public Partido(Equipo equipo1, Equipo equipo2, int numPartido, LocalDate fecha) {
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.numPartido = numPartido;
        this.fecha = fecha.toString();
    }

    
    public void jugar() {
        Random random = new Random();
        this.marcador1 = random.nextInt(10);
        this.marcador2 = random.nextInt(10);
        
        // Tiempos de eventos
        this.tiempoPrimeraTorre = 5 + random.nextInt(4); // entre los minutos 5 y 8
        this.tiempoPrimerDragon = 10 + random.nextInt(6); // entre los minutos 10 y 15
        this.tiempoBaron = 25 + random.nextInt(11); // entre los minutos 25 y 35
        this.tiempoTotal = 40 + random.nextInt(11); // entre los minutos 40 y 50
        
        // Determinar MVP y KDA
        if (random.nextDouble() < 0.5) {
            this.mvp = equipo1.getJugadores().get(random.nextInt(equipo1.getJugadores().size()));
        } else {
            this.mvp = equipo2.getJugadores().get(random.nextInt(equipo2.getJugadores().size()));
        }
        this.mvpKills = random.nextInt(20);
        this.mvpDeaths = random.nextInt(10);
        this.mvpAssists = random.nextInt(15);
        
        mostrarResultado();
    }
    
    private void mostrarResultado() {
        String resultado = String.format("Fase: %s\nPartido %d\n%s %d - %d %s\n",
                fase, numPartido, equipo1.getNombre(), marcador1, marcador2, equipo2.getNombre());
        resultado += String.format("MVP: %s (KDA: %d/%d/%d)\n", mvp.getNombre(), mvpKills, mvpDeaths, mvpAssists);
        resultado += String.format("Primera torre destruida en el minuto %d\n", tiempoPrimeraTorre);
        resultado += String.format("Primer dragón derrotado en el minuto %d\n", tiempoPrimerDragon);
        resultado += String.format("Barón realizado en el minuto %d\n", tiempoBaron);
        resultado += String.format("Tiempo total de la partida: %d minutos\n", tiempoTotal);
        JOptionPane.showMessageDialog(null, resultado + "\nFecha: " + fecha);
    }
    
    public Equipo getGanador() {
        return marcador1 > marcador2 ? equipo1 : equipo2;
    }
}
