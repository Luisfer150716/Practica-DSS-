public class Carcel extends Casilla{
	private int[] turnos = new int[4];
	boolean[] visita = new boolean[4];

	public Carcel(String nombre){
		super(nombre);
                for(int i = 0 ; i < 4;i++){
                    this.visita[i] = true;
                }
		
	}
	public void accion(Jugador j, PartidaMonopoly p){
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
