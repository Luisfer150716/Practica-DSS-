//DE MOMENTO NO TIENE UTILIDAD ESTA CLASE
/*
class Partida{
	private final int n_jugadores; //obligatorio para cualquier juego
	private final Jugador[] jugadores; // "" 				 ""
	private final casillaMonopoly[] tablero; //para un caso particular;
	private final double dineroBanca = Double.POSITIVE_INFINITY;
	private final long duracionPartida ; // para partida con tiempo
	private final long tiempoTranscurrido;
	private Partida(BuilderPartida builderp){
		this.tablero = builderp.tablero;
		this.n_jugadores = builderp.n_jugadores
		jugadores = new Jugador[n_jugadores];
		this.jugadores = builderp.jugadores;
		this.duracionPartida = builderp.duracionPartida;

	}
	public int getNJugadores(){return this.n_jugadores;}
	public Jugador[] getJugadores(){return this.jugadores;}
	public casillaMonopoly[] getTablero(){return this.tablero;}
	public long duracionPartida(){return this.duracionPartida;}
	public long tiempoTranscurrido(){return  //implementar tiempo actual - tiempo inicio;}
};
