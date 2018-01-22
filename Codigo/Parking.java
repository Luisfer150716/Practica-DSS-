public class Parking extends Casilla{
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
	
	public void accion(Jugador j, PartidaMonopoly p){		
		j.setDinero(j.getDinero()+bote);
		bote=0;
	}
}
