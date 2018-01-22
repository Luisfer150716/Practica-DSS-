package monopolyclasico;
public class Casilla implements Serializable{

	String nombre;
	int id;
	
	public Casilla(String nombre){
		this.nombre = nombre;
	}
	
	public String getNombre(){
		return this.nombre;
	}
        
	public void accion(Jugador j, PartidaMonopoly p){
            
        }
}
