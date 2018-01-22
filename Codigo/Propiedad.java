package monopolyclasico;
public class Propiedad extends Casilla{

	public int valor;
	public Jugador dueno;
	
	public Propiedad(String nombre, int valor){
		super(nombre);
		this.valor= valor;
		this.dueno= null;
	}
	public void accion(Jugador j, PartidaMonopoly p){
            System.out.println("Estas en la propiedad: "+this.getNombre());
        }

	public int getValor(){
		return this.valor;	
	}
	public Jugador getDueno(){
		return this.dueno;	
	}
	public void setDueno(Jugador j){
		this.dueno = j;	
	}
}
