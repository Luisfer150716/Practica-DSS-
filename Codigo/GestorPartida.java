import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.io.*;

public class GestorPartida{
	private static GestorPartida gestor = null;
	public static GestorPartida instancia(){
		if(gestor == null){			
				gestor = new GestorPartida();	
		}
		
		return gestor;
		
		
	}
	public static void guardarPartida(Serializable datos,String nombre)throws Exception{
		/*try(ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(Paths.get(nombre)))){
			oos.writeObject(datos);
		}*/
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombre));
		oos.writeObject(datos);
		oos.close();
		
	}
	public static Object cargarPartida(String nombre) throws IOException, ClassNotFoundException{
		/*try(ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(Paths.get(nombre)))){
			return ois.readObject();
		}*/
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nombre));
		return ois.readObject();
	}
	
	public void muestraMenuInicial(){
		System.out.println("Elige opcion: ");
		System.out.println("1.Nueva partida");
		System.out.println("2.Cargar partida");
		System.out.println("3.Salir");
	}
	public void configurarPartida(PartidaMonopoly partida){
                Scanner sc = new Scanner(System.in);
		Scanner g = new Scanner(Sistem.in);
                int numJugadores = 0;
		do{
			System.out.println("Introduce numero de jugadores: ");
			numJugadores = sc.nextInt();
			if(numJugadores < 2 || numJugadores > 4)
				System.out.println("Numero de jugadores incorrectos.");

		} while(numJugadores < 2 || numJugadores > 4);

		partida.setNumJugadores(numJugadores);
		//RECORDATORIO: TABLERO 23X56; J1 EMPIEZA EN F21 C51 ; J2 F21 C52;J3 F21 C53;J4 F21 C54
		int fila = 21;
		int col = 51;
		int colLimiteIzq = 1;
		int colLimiteDch = 51;
		TableroGrafico t = partida.getTableroGrafico();
		String[] textoJugador = new String[4];
		int textoPosicion = 0;
		textoJugador[0] = "1";
		textoJugador[1] = "2";
		textoJugador[2] = "3";
		textoJugador[3] = "4";
		for(int i=1; i<=numJugadores; i++){
			System.out.println("Introduce nombre del Jugador "+i);
			String nombre = sc.next();
			System.out.println("Introduce figura del Jugador "+i);
			String figura = sc.next();
			partida.anadirJugador(new Jugador(nombre, figura, 0, 500,i,fila,col,colLimiteIzq,colLimiteDch,textoJugador[textoPosicion]));
			t.escribeCasillaTablero(fila,col,textoJugador[textoPosicion]);
			textoPosicion++;
			colLimiteIzq++;
			colLimiteDch++;
						
		}
		int x = (int)Math.floor(Math.random()*numJugadores);
                System.out.println("Empieza el jugador numero "+(x+1));
		partida.setJugadorActual(partida.getJugadores().elementAt(x));
		partida.setTurnoJugador(x);
	}
	public void desarrollaPartida(PartidaMonopoly partida){
		Scanner sc = new Scanner(System.in);
		boolean seJuega=true;
		int turno = partida.getTurno();
		//int jugador = partida.getTurnoJugador();
		TableroGrafico t = partida.getTableroGrafico();
		while(seJuega){
			t.muestraTablero();
			turno = partida.getTurno();
			System.out.println("Es el turno "+turno);
			partida.siguienteTurnoPartida();
			Jugador jugadorActual = partida.getJugadorActual();
			if(jugadorActual.getCarcel())
			{
				partida.tablero[10].accion(jugadorActual, partida);
			}
			else {
				System.out.println("Tira el jugador "+jugadorActual.getNombre());
				jugadorActual.mostrarEstado();
				System.out.println("Deseas guardar la partida y salir? 1-si 2-no ");
				int guardar = g.nextInt();
				if(guardar == 1){
					System.out.println("Introduce nombre para la partida guardada ");
					String nombrePartida = sc.nextLine();
					try{
						guardarPartida(partida,nombrePartida);
					}catch(Exception e){}
					System.exit(1);
				}
				else
				{
					System.out.println("Tira el jugador "+jugadorActual.getNombre());
					jugadorActual.mostrarEstado();
					jugadorActual.lanzarDados(t);
					System.out.println(jugadorActual.getNombre()+" se ha movido a la casilla: "+jugadorActual.getCasillaActual());
	                                System.out.println(partida.tablero[jugadorActual.getCasillaActual()].getNombre());
					partida.tablero[jugadorActual.getCasillaActual()].accion(jugadorActual, partida);
					

					if(jugadorActual.getDinero() >=0){	
						partida.siguienteTurno();
											
					}

					else{
						if(jugadorActual.getPropiedadesEdificables().isEmpty() && jugadorActual.getPropiedadesNoEdificables().isEmpty()){
							partida.eliminarJugador(jugadorActual.getId(),"No tienes dinero ni propiedades");
							if(partida.getJugadores().size() == 1){
								seJuega = false;
								System.out.println("Solo queda un jugador");
								partida.siguienteTurnoPartida();
								System.out.println("Ha ganado el jugador "+partida.getJugadores().firstElement().getNombre()+", partida finalizada!");
							}
							
						}
						else
						{
							jugadorActual.pagaDeuda();
						}

							partida.siguienteTurno();
						}
					}
			}
		}
		//FIN ALGORITMO PARTIDA
	}
}
