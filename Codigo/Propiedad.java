public class Propiedad extends CasillaMonopoly{

	int valor;
	Jugador dueño;

	public Propiedad(String nombre, int valor){
		super(nombre);
		this.valor= valor;
		this.dueño= null;
	}
}