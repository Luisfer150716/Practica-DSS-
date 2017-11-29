package monopolyclasico;

public abstract class FabricaTablero{
	public static FabricaTablero instancia(String fabrica){
		if(_fabrica == null){
			if(fabrica == "FabricaTableroMonopoly"){
				_fabrica = new FabricaMonopolyClasico();	
			}
			
		}
		return _fabrica;
				
	}
        public abstract Casilla nuevaEdificable(String nombre ,int coste,int alquiler);
	public abstract Casilla nuevaNoEdificable(String nombre ,int coste,int beneficio);
	public abstract Casilla nuevaImpuesto(String nombre);		
	public abstract Casilla vacia(String nombre);
	public abstract Casilla nuevaSuerte(String nombre);
	public abstract Casilla nuevaCarcel(String nombre);
	public abstract Casilla nuevaRecompensa(String nombre);
		
	
	private static FabricaTablero _fabrica = null;
        protected FabricaTablero(){}         

};
