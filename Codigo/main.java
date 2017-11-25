

public static void main(String[] args) {

	GestorPartida gestor = GestorPartida.instancia();
	gestor.muestraMenuInicial();
	static Scanner sc = new Scanner(System.in);
	int opcion = sc.nextInt();
	switch (opcion) {
		case 1:	
			//CREAMOS TABLERO
			PartidaMonopoly partida = new PartidaMonopoly();
			//AÑADE JUGADORES
			gestor.configurarPartida(partida);
			//INICIA PARTIDA
			gestor.desarrollaPartida(partida);
			break;	
				
		case 2:
			System.out.println("Introduce el nombre de la partida que quieras cargar");
			String nombre = sc.nextString();
			PartidaMonopoly partidaCargada = gestor.cargarPartida(nombre);
			gestor.desarrollaPartida(partida);
			break;
		case default:
			System.out.printl("Poderoso caballero es Don Dinero, hasta luego!");

	}
		
	
}
