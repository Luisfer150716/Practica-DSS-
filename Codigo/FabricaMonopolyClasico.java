
public class FabricaMonopolyClasico extends FabricaTablero{
	Propiedad nuevaEdificable(int coste,int beneficio,int alquiler){
		return Propiedad(coste,beneficio,alquiler);
	}
	Propiedad nuevaNoEdificable(int coste,int beneficio){
		return Propiedad(coste,beneficio);
	}
	Suerte nuevaSuerte(int casillas,int dinero){
		return Suerte(casillas,recompensa);
	}
	Carcel nuevaCarcel(int turnos){
		return Carcel(turnos);
	}
	//PARKING
	Recompensa nuevaRecompensa(int premio){
		return Recompensa(premio);
	}
	

};