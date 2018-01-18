package monopolyclasico;
public class Propiedad extends Casilla{

	public int valor;
	public Jugador dueño;
	
	public Propiedad(String nombre, int valor){
		super(nombre);
		this.valor= valor;
		this.dueño= null;
	}
	public void accion(Jugador j, PartidaMonopoly p){
            System.out.println("Estas en la propiedad: "+this.getNombre());
        }

	public int getValor(){
		return this.valor;	
	}
	public Jugador getDueño(){
		return this.dueño;	
	}
	public void setDueño(Jugador j){
		this.dueño = j;	
	}
}
