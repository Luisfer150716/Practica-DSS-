import java.io.serializable;
class PartidaMonopoly implements Serializable{
	private int n_jugadores;
	private Jugador[] jugadores; //maximo 4 jugadores;
	private static casillaMonopoly[] tablero = new casillaMonopoly[40];
	private long duracionPartida ;

	public PartidaMonopoly(int n){
		this.n_jugadores = n;
		this.jugadores = new Jugador[n];
	}
	public void construyeTablero(){
		FabricaMonopolyClasico fabricaMonopoly;
		tablero[0] = fabricaMonopoly.vacia("Salida");
		tablero[1] = fabricaMonopoly.nuevaEdificable("Ronda de valencia",60,10);
		tablero[2] = fabricaMonopoly.nuevaSuerte("Caja de comunidad 1");
		tablero[3] = fabricaMonopoly.nuevaEdificable("Plaza lavapies",60,15);
		tablero[4] = fabricaMonopoly.nuevaImpuesto("Impuesto 1",200);
		tablero[5] = fabricaMonopoly.nuevaNoEdificable("Estacion de Goya",200,50);
		tablero[6] = fabricaMonopoly.nuevaEdificable("Glorieta Cuatro Caminos",100,20);
		tablero[7] = fabricaMonopoly.nuevaSuerte("Suerte 1");
		tablero[8] = fabricaMonopoly.nuevaEdificable("Avenida Reina Victoria",100,30);
		tablero[9] = fabricaMonopoly.nuevaEdificable("Calle Bravo Murillo",120,40);
		tablero[10] = fabricaMonopoly.nuevaCarcel(0,true);
		tablero[11] = fabricaMonopoly.nuevaEdificable("Glorieta de Bilbao",140,50);
		tablero[12] = fabricaMonopoly.nuevaNoEdificable("Compañia de electricidad",150,50);
		tablero[13] = fabricaMonopoly.nuevaEdificable("Calle Alberto Aguilera",140,60);
		tablero[14] = fabricaMonopoly.nuevaEdificable("Calle Fuencarral",160,80);
		tablero[15] = fabricaMonopoly.nuevaNoEdificable("Estacion de las Delicias",200,50);
		tablero[16] = fabricaMonopoly.nuevaEdificable("Avenida Felipe Segundo",160,60);
		tablero[17] = fabricaMonopoly.nuevaSuerte("Caja de comunidad 2");
		tablero[18] = fabricaMonopoly.nuevaEdificable("Calle Velazquez",180,80);
		tablero[19] = fabricaMonopoly.nuevaEdificable("Calle Serrano",200,0);
		tablero[20] = fabricaMonopoly.nuevaRecompensa("Parking");
		tablero[21] = fabricaMonopoly.nuevaEdificable("Avenida de America",220, 100);
		tablero[22] = fabricaMonopoly.nuevaSuerte("Suerte 2");
		tablero[23] = fabricaMonopoly.nuevaEdificable("Calle Maria de Molina",220,110);
		tablero[24] = fabricaMonopoly.nuevaEdificable("Calle Cea Bermudez",240,120);
		tablero[25] = fabricaMonopoly.nuevaNoEdificable("Estacion de Mediodia",200,50);
		tablero[26] = fabricaMonopoly.nuevaEdificable("Avenida de los Reyes Catolicos",260,150);
		tablero[27] = fabricaMonopoly.nuevaEdificable("Calle Bailen",260,160);
		tablero[28] = fabricaMonopoly.nuevaNoEdificable("Compañia de agua",150,50);
		tablero[29] = fabricaMonopoly.nuevaEdificable("Plaza de España",260,170);
		tablero[30] = fabricaMonopoly.vacia("Ve a la carcel");
		tablero[31] = fabricaMonopoly.nuevaEdificable("Puerta del Sol",300,180);
		tablero[32] = fabricaMonopoly.nuevaEdificable("Calle Alcala",300,190);
		tablero[33] = fabricaMonopoly.nuevaSuerte("Caja comunidad 3");
		tablero[34] = fabricaMonopoly.nuevaEdificable("Gran Via",320,200);
		tablero[35] = fabricaMonopoly.nuevaNoEdificable("Estacion del Norte",200,50);
		tablero[36] = fabricaMonopoly.nuevaSuerte("Suerte 3");
		tablero[37] = fabricaMonopoly.nuevaEdificable("Paseo de la Castellana",350,220);
		tablero[38] = fabricaMonopoly.nuevaImpuesto("Impuesto 2",200);
		tablero[39] = fabricaMonopoly.nuevaEdificable("Paseo del Prado",400,250);
		
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
	public static void guardarPartida(Serializable datos,String nombre)throws Exception{
		try(ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(Paths.get(nombre)))){
			oos.writeObject(datos);
		}
		

	}
	public static Object cargarPartida(String nombre){
		try(ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(Paths.get(nombre)))){
			return ois.readObject();
		}

	}
	
}
