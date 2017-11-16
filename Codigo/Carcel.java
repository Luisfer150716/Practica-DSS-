public class Carcel extends CasillaMonopoly{
	int turnos = new int[4];
	boolean visita = new boolean[4];

	public Carcel(String nombre, int turnos, boolean visita){
		super(nombre);
		this.turnos = turnos;
		this.visita = visita;
	}
	public void accion(Jugador j){
		if(!j.getCarcel()){
			System.out.println("Estas de visita!!");	
		}
		else{
			System.out.println("Estas en la carcel, te quedan "+turnos[j.getId()]+" turnos");
			turnos[j.getId()]--;
			if(turnos[j.getId()]==0){
				j.setCarcel(false);	
			}
		}
	}
	
}
