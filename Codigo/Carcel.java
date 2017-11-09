public class Carcel extends CasillaMonopoly{
	int turnos;
	boolean visita;

	public Carcel(String nombre, int turnos, boolean visita){
		super(nombre);
		this.turnos = turnos;
		this.visita = visita;
	}
}