

public static void main(String[] args) {

								
							
	
	/*Scanner sc = new Scanner(System.in);
	System.out.println("Introduce numero de jugadores: ");
	int numJugadores = sc.nextInt();
	Jugador[numJugadores] jugadores;

	System.out.println("Comienza la partida");
	System.out.println("-------------------");
	System.out.println("Jugador " +jugadores[1].getNombre()+" tira los dados");
	jugadores[1].lanzarDados();
	System.out.println(jugadores[1].getNombre()+" se ha movido a la casilla: "+jugadores[1].getCasilla_actual());
	//System.out.println("Que desea realizar: ");
	if(tablero[jugadores[1].getCasilla_actual()] == )
	System.out.println("1.");*/

	static Scanner sc = new Scanner(System.in);
	System.out.println("Elige opcion: ");
	System.out.println("1.Nueva partida");
	System.out.println("2.Cargar partida");
	System.out.println("3.Salir");
	int opcion = sc.nextInt();

	switch (opcion) {
		case 1:	do{
					System.out.println("Introduce numero de jugadores: ");
					int numJugadores = sc.nextInt();
					if(numJugadores < 2 || numJugadores > 4)
						System.out.println("Numero de jugadores incorrectos.");

				} while(numJugadores < 2 || numJugadores > 4)

				PartidaMonopoly partida = new PartidaMonopoly(numJugadores);
				partida.construyeTablero();
				for(int i=1; i<=numJugadores; i++){
					System.out.println("Introduce nombre del Jugador "+i);
					String nombre = sc.nextString();
					System.out.println("Introduce figura del Jugador "+i);
					String figura = sc.nextString();
					partida.jugadores.add(i,new Jugador(nombre, figura, 1, 500);
					partida.jugadores.elementAt(i, this.setId(i);
					
				}

				boolean seJuega=true;
				int turno = 0;
				int jugador = 1;
				Jugador banca(banca, null, null, 999999);
				while(seJuega){
					System.out.println("Es el turno "+turno);
					if(partida.jugadores.elementAt(jugador).getCarcel()){
						tablero[10].accion(partida.jugadores.elementAt(jugador));
					}else{
						System.out.println("Tira el jugador "+jugador);
						System.out.println("Dinero: " +partida.jugadores.elementAt(jugador).getDinero());
						System.out.println("Casilla actual: "+partida.jugadores.elementAt(jugador).getCasilla_actual());
						System.out.println("Propiedades edificables: ");
						for(int j = 0; j <partida.jugadores.elementAt(jugador).propiedadesEdificables.size(); j++){
							System.out.println(partida.jugadores.elementAt(jugador).propiedadesEdificables.elementAt(j).getNombre());
							}
						System.out.println("Propiedades no edificables: ");
						for(int j = 0; j <partida.jugadores.elementAt(jugador).propiedadesNoEdificables.size(); j++){
							System.out.println(partida.jugadores.elementAt(jugador).propiedadesNoEdificables.elementAt(j).getNombre());
							}

						System.out.println("Jugador " +partida.jugadores[jugador].getNombre()+" tira los dados");
						partida.jugadores.elementAt(jugador).lanzarDados();
						System.out.println(partida.jugadores.elementAt(jugador).getNombre()+" se ha movido a la casilla: "+partida.jugadores[jugador].getCasilla_actual());

						partida.tablero[partida.jugadores.elementAt(jugador).getCasilla_actual()].accion(partida.jugadores.elementAt(jugador));
						}

					if(partida.jugadores.elementAt(jugador).getDinero()>0){	
						jugador++;
						if(jugador >numJugadores)
							jugador = 1;
						turno++;
					}

					else{
						if(partida.jugadores.elementAt(jugador).propiedadesEdificables.isEmpty() && partida.jugadores.elementAt(jugador).propiedadesNoEdificables.isEmpty()){
							partida.eliminarJugador(jugador);
						}
						else{
							mostrarPropiedades(partida.jugadores.elementAt(jugador));
							int pe= sc.nextInt();

							selectEdificable()
						}



						///for(int j=0; j<partida.jugadores[jugador].propiedadesEdificables.length;j++){
							///if(partida.jugadores[jugador].propiedadesEdificables[j]
						}
					}
				}




		case 2:
		default : break;
	}


}
