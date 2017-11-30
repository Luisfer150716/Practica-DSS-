package monopolyclasico;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class GestorPartida{
	private static GestorPartida gestor = null;
	public static GestorPartida instancia(){
		if(gestor == null){			
				gestor = new GestorPartida();	
		}
		
		return gestor;
		
		
	}
	public static void guardarPartida(Serializable datos,String nombre)throws Exception{
		try(ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(Paths.get(nombre)))){
			oos.writeObject(datos);
		}
		

	}
	public static Object cargarPartida(String nombre) throws IOException, ClassNotFoundException{
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
	public void configurarPartida(PartidaMonopoly partida){
                Scanner sc = new Scanner(System.in);
                int numJugadores = 0;
		do{
			System.out.println("Introduce numero de jugadores: ");
			numJugadores = sc.nextInt();
			if(numJugadores < 2 || numJugadores > 4)
				System.out.println("Numero de jugadores incorrectos.");

		} while(numJugadores < 2 || numJugadores > 4);

		
		
		for(int i=1; i<=numJugadores; i++){
			System.out.println("Introduce nombre del Jugador "+i);
			String nombre = sc.next();
			System.out.println("Introduce figura del Jugador "+i);
			String figura = sc.next();
			partida.anadirJugador(new Jugador(nombre, figura, 1, 500,i));
						
		}
		int x = (int)Math.floor(Math.random()*numJugadores);

		partida.setJugadorActual(partida.getJugadores().elementAt(x));
	}
	public void desarrollaPartida(PartidaMonopoly partida){
		Scanner sc = new Scanner(System.in);
		boolean seJuega=true;
		int turno = partida.getTurno();
		//int jugador = partida.getTurnoJugador();
		Jugador banca = new Jugador("banca", null, 0, 999999, 10);
		while(seJuega){
			System.out.println("Es el turno "+turno);
			Jugador jugadorActual = partida.getJugadorActual();
			if(jugadorActual.getCarcel())
			{
				partida.tablero[10].accion(jugadorActual);
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
					if(jugadorActual. getPropiedadesEdificables().isEmpty() && jugadorActual. getPropiedadesNoEdificables().isEmpty()
						||  jugadorActual.getDinero() < 0){
						partida.eliminarJugador(jugadorActual.getId());
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
								if(!jugadorActual.getPropiedadesEdificables().isEmpty()){
									System.out.println("Introduce el numero de la propiedad edificable que quieras eliminar");
									int pr = sc.nextInt();
									jugadorActual.hipotecaPropiedad(true,banca,pr);	
									
								}
								else{
									System.out.println("No tienes propiedades edificables!");
								}
								
							}else{
								if(!jugadorActual.getPropiedadesNoEdificables().isEmpty()){
									System.out.println("Introduce el numero de la propiedad no edificable que quieras eliminar");
									int pr = sc.nextInt();
									jugadorActual.hipotecaPropiedad(false,banca,pr);	
								}
								else{
									System.out.println("No tienes propiedades no edificables!");
								}
								
							}
							if(jugadorActual.getDinero() >= 0){
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
}


