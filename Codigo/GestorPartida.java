public class GestorPartida{
	private GestorPartida();
	public static GestorPartida instancia(){
		if(_fabrica == 0){			
				_fabrica = new FabricaTablero();	
		}
		
		return _fabrica;
		
		
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
	public void muestraMenuInicial(){
		System.out.println("Elige opcion: ");
		System.out.println("1.Nueva partida");
		System.out.println("2.Cargar partida");
		System.out.println("3.Salir");
	}
	public void configuraPartida(Partida partida){
		do{
			System.out.println("Introduce numero de jugadores: ");
			int numJugadores = sc.nextInt();
			if(numJugadores < 2 || numJugadores > 4)
				System.out.println("Numero de jugadores incorrectos.");

		} while(numJugadores < 2 || numJugadores > 4)

		
		
		for(int i=1; i<=numJugadores; i++){
			System.out.println("Introduce nombre del Jugador "+i);
			String nombre = sc.nextString();
			System.out.println("Introduce figura del Jugador "+i);
			String figura = sc.nextString();
			partida.anadirJugador(new Jugador(nombre, figura, 1, 500,i));
						
		}
		int x = Math.floor(Math.random()*numJugadores);

		partida.setJugadorActual(partida.jugadores.elementAt(x));
	}
	public void desarrollaPartida(Partida partida){
		boolean seJuega=true;
		int turno = partida.getTurno();
		//int jugador = partida.getTurnoJugador();
		Jugador banca(banca, null, null, 999999);
		while(seJuega){
			System.out.println("Es el turno "+turno);
			Jugador jugadorActual = partida.getJugadorActual();
			if(jugadorActual.getCarcel())
			{
				tablero[10].accion(jugadorActual);
			}
			else
			{
				System.out.println("Tira el jugador "+jugadorActual.getNombre());
				jugadorActual.mostrarEstado();
				jugadorActual.lanzarDados();
				System.out.println(jugadorActual.getNombre()+" se ha movido a la casilla: "+jugadorActual.getCasilla_actual());
				partida.tablero[jugadorActual.getCasilla_actual()].accion(jugadorActual);
				

				if(jugadorActual.getDinero()>0){	
					partida.siguienteTurno();
										
				}

				else{
					if(jugadorActual.getEdificables.isEmpty() && jugadorActual.getNoEdificables.isEmpty()
						|| jugadorActual.bienes() + jugadorActual.getDinero() < 0){
						partida.eliminarJugador(jugadorActual);
						if(partida.getJugadores().size() == 1){
							seJuega = false;
							System.out.println("Solo queda un jugador, partida finalizada!");
						}
						
					}
					else{
						boolean deudaPagada = false;
						while(!deudaPagada){
							jugadorActual.mostrarPropiedades();
							System.out.println("Introduce 1 para hipotecar edificables, 2 para no edificables");
							int op = sc.nextInt();
							if(op == 1){
								if(!jugadorActual.getEdificables.isEmpty()){
									System.out.println("Introduce el numero de la propiedad edificable que quieras eliminar");
									int pr = sc.nextInt();
									jugadorActual.hipotecaPropiedad(true,banca,pr);	
									
								}
								else{
									System.out.println("No tienes propiedades edificables!");
								}
								
							}else{
								if(!jugadorActual.getNoEdificables().isEmpty()){
									System.out.println("Introduce el numero de la propiedad no edificable que quieras eliminar");
									int pr = sc.nextInt();
									jugadorActual.hipotecaPropiedad(false,banca,pr);	
								}
								else{
									System.out.println("No tienes propiedades no edificables!");
								}
								
							}
							if(jugadorActual.bienes() + jugadorActual.getDinero() >= 0){
								deudaPagada = true;
							}
						}

						partida.siguienteTurno();
					}



				}
			}
		}
		//FIN ALGORITMO PARTIDA
	}
	public void 


}