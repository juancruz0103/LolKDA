public class Jugador {
    private String nombre;
    private String rol;
    private int edad;
	private int kills;
	private int assists;
	private int deaths;

    public Jugador(String nombre, String rol, int edad) {
        this.nombre = nombre;
        this.rol = rol;
        this.edad = edad;
        this.kills = 0;
        this.deaths = 0;
        this.assists = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    public int getKills() {
        return kills;
    }

    public void setKills(int kills) {
        this.kills = kills;
    }

    public int getDeaths() {
        return deaths;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "nombre='" + nombre + '\'' +
                ", rol='" + rol + '\'' +
                ", edad=" + edad +
                '}';
    }
}