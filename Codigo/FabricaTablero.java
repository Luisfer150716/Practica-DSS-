public abstract class FabricaTablero{
        public final static String F_T_M = "FabricaTableroMonopoly";
	/*public static FabricaTablero instancia(String fabrica){
		if(_fabrica == null){
			if(fabrica == F_T_M){
				_fabrica = new FabricaMonopolyClasico();	
			}
			
		}
		return _fabrica;
				
	}*/
        public static FabricaMonopolyClasico getFabrica(){
            return new FabricaMonopolyClasico();
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
