public class Parking extends CasillaMonopoly{
	int bote;

	public Parking(String nombre){
		super(nombre);
		this.bote = 0;
	}

	public int getBote(){
		return this.bote;
	}

	public void incremento(int dinero){
		this.bote += dinero;
	}
}
