class Partida{
	private int n_jugadores; //obligatorio para cualquier juego
	private Jugador[] jugadores; // "" 				 ""
	private casillaMonopoly[] tablero; //para un caso particular;
	private double dineroBanca = Double.POSITIVE_INFINITY;
	private long duracionPartida ; // para partida con tiempo
	private long tiempoTranscurrido;
	private Partida(BuilderPartida builderp){
		this.tablero = builderp.getTablero();
		this.n_jugadores = builderp.getNJugadores();
		jugadores = new Jugador[n_jugadores];
		this.jugadores = builderp.getJugadores();
		this.duracionPartida = builderp.getDuracion();

	}
};