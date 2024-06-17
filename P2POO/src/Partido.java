
public class Partido {
	private Equipo equipo1;
	private Equipo equipo2;
	private int Marcador1;
	private int Marcador2;
	private String fase;
	private static int cantPartidos;
	public Partido(Equipo equipo1, Equipo equipo2, int marcador1, int marcador2){
		cantPartidos++;
		this.equipo1 = equipo1;
		this.equipo2 = equipo2;
		Marcador1 = marcador1;
		Marcador2 = marcador2;
		fase = DeterminarFase();
		
	}
	private String DeterminarFase() {
		if (cantPartidos<=4) {
			return "Cuartos";
		}
		if (cantPartidos>4 && cantPartidos<=6) {
			return "SemiFinal";
		}
		if (cantPartidos>6 && cantPartidos<=7) {
			return "Final";
		}
		return "null";
	}
	
	

}
