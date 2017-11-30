package monopolyclasico;
public class Propiedad extends Casilla{

	public int valor;
	public Jugador duenno;
	
	public Propiedad(String nombre, int valor){
		super(nombre);
		this.valor= valor;
		this.duenno= null;
	}
	public void accion(Jugador j){
            System.out.println("Estas en la propiedad: "+this.getNombre());
        }

	public int getValor(){
		return this.valor;	
	}
	public Jugador getDuenno(){
		return this.duenno;	
	}
	public void setDuenno(Jugador j){
		this.duenno = j;	
	}
}
