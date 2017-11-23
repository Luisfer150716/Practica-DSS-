public class Propiedad extends CasillaMonopoly{

	public int valor;
	public Jugador dueño;
	
	public Propiedad(String nombre, int valor){
		super(nombre);
		this.valor= valor;
		this.dueño= null;
	}
	public void accion(Jugador j); //NO HACE NADA , SIEMPRE SE LLAMA A EDIFICABLE O NO EDIFICABLE
	public getValor(){
		return this.valor;	
	}
	public Jugador getDueño(){
		return this.dueño;	
	}
	public void setDueño(Jugador j){
		this.dueño = j;	
	}
}
