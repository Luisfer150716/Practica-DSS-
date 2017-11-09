public class Parking extends CasillaMonopoly{
	int bote=0;

	public Parking(String nombre, int bote){
		super(nombre);
		this.bote = bote;
	}

	public int getBote(){
		return this.bote;
	}

	public void incremento(int dinero){
		this.bote += dinero;
	}
}