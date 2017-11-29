package monopolyclasico;
public class FabricaMonopolyClasico extends FabricaTablero{
	public Casilla vacia(String nombre){
		return new Casilla(nombre);	
	}
	public Casilla nuevaImpuesto(String nombre){
		return new Impuesto(nombre);	
	}
	
	public Casilla nuevaEdificable(String nombre ,int coste,int alquiler){
		return new Edificable(nombre ,coste,alquiler);
	}
	public Casilla nuevaNoEdificable(String nombre ,int coste,int beneficio){
		return new NoEdificable(nombre ,coste,beneficio);
	}
	public Casilla nuevaSuerte(String nombre){
		return new Suerte(nombre);
	}
	public Casilla nuevaCarcel(String nombre){
		return new Carcel(nombre);
	}
	//PARKING
	public Casilla nuevaRecompensa(String nombre){
		return new Parking(nombre);
	}
	

};
