class PartidaMonopoly{
	private int n_jugadores;
	private Jugador[] jugadores; //maximo 4 jugadores;
	private casillaMonopoly[] tablero;

	public PartidaMonopoly(int n){
		n_jugadores = n;
		jugadores = new Jugador[n];
	}
	public PartidaMonopoly tablero(casillaMonopoly[] t){
		tablero = t;
		return this;
	}
	public Partida partida(){
		return new Partida(this);
	}



	public boolean anadirJugador(Jugador j){
		for(int i = 0 ; i < n_jugadores;i++){
			if(jugadores[i] == null){
				jugadores[i] = j;
				return true;
			}
		}
		return false;
	}
	public void eliminarJugador(int i){
		jugadores[i] = null;
	}
		
	}
	public Partida guardarPartida(){

	}
	public Partida cargarPartida(){

	}
	
}