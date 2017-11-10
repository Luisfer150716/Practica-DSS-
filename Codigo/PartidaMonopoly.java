class PartidaMonopoly{
	private int n_jugadores;
	private Jugador[] jugadores; //maximo 4 jugadores;
	private static casillaMonopoly[] tablero = new casillaMonopoly[40];
	private long duracionPartida ;

	public PartidaMonopoly(int n){
		this.n_jugadores = n;
		this.jugadores = new Jugador[n];
	}
	public void construyeTablero(){
		tablero[0] = new CasillaMonopoly("Salida");
		tablero[1] = new Edificable("Ronda de valencia",60,10);
		tablero[2] = new Suerte("Caja de comunidad 1");
		tablero[3] = new Edificable("Plaza lavapies",60,15);
		tablero[4] = new Impuesto(200);
		tablero[5] = new NoEdificable("Estacion de Goya",200,50);
		tablero[6] = new Edificable("Glorieta Cuatro Caminos",100,20);
		tablero[7] = new Suerte("Suerte 1");
		tablero[8] = new Edificable("Avenida Reina Victoria",100,30);
		tablero[9] = new Edificable("Calle Bravo Murillo",120,40);
		tablero[10] = new Carcel(0,true);
		tablero[11] = new Edificable("Glorieta de Bilbao",140,50);
		tablero[12] = new NoEdificable("Compañia de electricidad",150,50);
		tablero[13] = new Edificable("Calle Alberto Aguilera",140,60);
		tablero[14] = new Edificable("Calle Fuencarral",160,80);
		tablero[15] = new NoEdificable("Estacion de las Delicias",200,50);
		tablero[16] = new Edificable("Avenida Felipe Segundo",160,60);
		tablero[17] = new Suerte("Caja de comunidad 2");
		tablero[18] = new Edificable("Calle Velazquez",180,80);
		tablero[19] = new Edificable("Calle Serrano",200,0);
		tablero[20] = new Parking("Parking");
		tablero[21] = new Edificable("Avenida de America",220, 100);
		tablero[22] = new Suerte("Suerte 2");
		tablero[23] = new Edificable("Calle Maria de Molina",220,110);
		tablero[24] = new Edificable("Calle Cea Bermudez",240,120);
		tablero[25] = new NoEdificable("Estacion de Mediodia",200,50);
		tablero[26] = new Edificable("Avenida de los Reyes Catolicos",260,150);
		tablero[27] = new Edificable("Calle Bailen",260,160);
		tablero[28] = new NoEdificable("Compañia de agua",150,50);
		tablero[29] = new Edificable("Plaza de España",260,170);
		tablero[30] = new CasillaMonopoly("Ve a la carcel");
		tablero[31] = new Edificable("Puerta del Sol",300,180);
		tablero[32] = new Edificable("Calle Alcala",300,190);
		tablero[33] = new Suerte("Caja comunidad 3");
		tablero[34] = new Edificable("Gran Via",320,200);
		tablero[35] = new NoEdificable("Estacion del Norte",200,50);
		tablero[36] = new Suerte("Suerte 3");
		tablero[37] = new Edificable("Paseo de la Castellana",350,220);
		tablero[38] = new CasillaMonopoly("Impuesto",200);
		tablero[39] = new Edificable("Paseo del Prado",400,250);
		
	}
	public PartidaMonopoly duracion(long d){
		this.duracionPartida = d;
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
