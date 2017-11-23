

public class FabricaTablero{
	public static FabricaTablero instancia(String fabrica){
		if(_fabrica == 0){
			if(fabrica == "FabricaTableroMonopoly"){
				_fabrica = new FabricaTableroMonopoly();	
			}
			else{
				_fabrica = new FabricaTablero();	
			}
		}
		return _fabrica;
		
		
	}
	public Casilla vacia(String nombre);
	public Casilla nuevaSuerte(String nombre,int casillas,int dinero,);
	public Casilla nuevaCarcel(String nombre,int turnos);
	public Casilla nuevaRecompensa(String nombre,int premio);
		
	protected:
		FabricaTablero();
	private:
		static FabricaTablero _fabrica = 0;
	
	

};
