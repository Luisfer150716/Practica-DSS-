
public class FabricaMonopolyClasico extends FabricaTablero{
	Casilla vacia(String nombre){
		return Casilla(nombre);	
	}
	Impuesto nuevaImpuesto(String nombre,int imp){
		return Impuesto(nombre,imp);	
	}
	
	Propiedad nuevaEdificable(String nombre ,int coste,int alquiler){
		return Propiedad(nombre ,coste,alquiler);
	}
	Propiedad nuevaNoEdificable(String nombre ,int coste,int beneficio){
		return Propiedad(nombre ,coste,beneficio);
	}
	Suerte nuevaSuerte(String nombre ,int casillas,int dinero){
		return Suerte(nombre ,casillas,recompensa);
	}
	Carcel nuevaCarcel(String nombre ,int turnos){
		return Carcel(nombre ,turnos);
	}
	//PARKING
	Recompensa nuevaRecompensa(String nombre){
		return Recompensa(nombre);
	}
	

};
