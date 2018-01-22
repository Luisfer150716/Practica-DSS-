package monopolyclasico;

import java.io.Serializable;
import java.util.Vector;


class PartidaMonopoly implements Serializable{
	private int turnoActual ;
	private int turnoJugador;
	private Jugador jugadorActual;
	private int num_jugadores;
        private int num_jugadores_actual = 0;
	private static Vector<Jugador> jugadores = new Vector<Jugador>(); //maximo 4 jugadores;
	public static Casilla[] tablero = new Casilla[40];
	private long duracionPartida ;
        FabricaTablero fabricaMonopoly;
	TableroGrafico tableroGrafico

	public PartidaMonopoly(FabricaTablero f,TableroGrafico t){
		turnoActual = 1;
                this.fabricaMonopoly = f;
		this.tableroGrafico = t;
		this.construyeTablero();
               
		
	}
	public void construyeTablero(){
		
		tablero[0] = new Casilla("Salida");
		tablero[1] = fabricaMonopoly.nuevaEdificable("Ronda de valencia",60,10);
		tablero[2] = fabricaMonopoly.nuevaSuerte("Caja de comunidad 1");
		tablero[3] = fabricaMonopoly.nuevaEdificable("Plaza lavapies",60,15);
		tablero[4] = fabricaMonopoly.nuevaImpuesto("Impuesto 1");
		tablero[5] = fabricaMonopoly.nuevaNoEdificable("Estacion de Goya",200,50);
		tablero[6] = fabricaMonopoly.nuevaEdificable("Glorieta Cuatro Caminos",100,20);
		tablero[7] = fabricaMonopoly.nuevaSuerte("Suerte 1");
		tablero[8] = fabricaMonopoly.nuevaEdificable("Avenida Reina Victoria",100,30);
		tablero[9] = fabricaMonopoly.nuevaEdificable("Calle Bravo Murillo",120,40);
		tablero[10] = fabricaMonopoly.nuevaCarcel("Carcel");
		tablero[11] = fabricaMonopoly.nuevaEdificable("Glorieta de Bilbao",140,50);
		tablero[12] = fabricaMonopoly.nuevaNoEdificable("Compannia de electricidad",150,50);
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
		tablero[28] = fabricaMonopoly.nuevaNoEdificable("Compannia de agua",150,50);
		tablero[29] = fabricaMonopoly.nuevaEdificable("Plaza de Espanna",260,170);
		tablero[30] = fabricaMonopoly.vacia("Ve a la carcel");
		tablero[31] = fabricaMonopoly.nuevaEdificable("Puerta del Sol",300,180);
		tablero[32] = fabricaMonopoly.nuevaEdificable("Calle Alcala",300,190);
		tablero[33] = fabricaMonopoly.nuevaSuerte("Caja comunidad 3");
		tablero[34] = fabricaMonopoly.nuevaEdificable("Gran Via",320,200);
		tablero[35] = fabricaMonopoly.nuevaNoEdificable("Estacion del Norte",200,50);
		tablero[36] = fabricaMonopoly.nuevaSuerte("Suerte 3");
		tablero[37] = fabricaMonopoly.nuevaEdificable("Paseo de la Castellana",350,220);
		tablero[38] = fabricaMonopoly.nuevaImpuesto("Impuesto 2");
		tablero[39] = fabricaMonopoly.nuevaEdificable("Paseo del Prado",400,250);
		
	}
	public PartidaMonopoly duracion(long d){
		this.duracionPartida = d;
		return this;
	}
	public PartidaMonopoly partida(){
		return new PartidaMonopoly(fabricaMonopoly);
	}

	public int getTurno(){
		return this.turnoActual;
	}

	public void anadirJugador(Jugador j){
            jugadores.add(this.num_jugadores_actual,j);
            this.num_jugadores_actual++;
            
		                    
		
		
	}
	public void eliminarJugador(int i,String motivo){
                System.out.println("El jugador "+i+" ha sido eliminado de la partida");
                System.out.println(motivo);
		jugadores.remove(i);
	}
	public void setJugadorActual(Jugador j){
		this.jugadorActual = j;
	}

	public Jugador getJugadorActual(){
		return this.jugadorActual;
	}
	public void siguienteTurno(){
		if(jugadores.elementAt(turnoJugador+1) == null){
			turnoJugador = 0;
		}
		else{
			turnoJugador++;
		}
		this.jugadorActual = jugadores.elementAt(turnoJugador);
	}
		
	public void mostrarPropiedades(Jugador j){
		System.out.println("Propiedades Edificables en tu posesion: ");
		for(int i=0; i<j.getPropiedadesEdificables().size(); i++){
			System.out.println("	"+i+" - Propiedad: "+j.getPropiedadesEdificables().elementAt(i).getNombre()+" - Valor: "+j.getPropiedadesEdificables().elementAt(i).getValor());
		}
		System.out.println("Propiedades No edificables en tu posesion: ");
		for(int k=0; k<j.getPropiedadesNoEdificables().size();k++){
			System.out.println("	"+k+" - Propiedad: "+j.getPropiedadesNoEdificables().elementAt(k).getNombre()+" - Valor: "+j.getPropiedadesNoEdificables().elementAt(k).getValor());
		}
	}
	
	public Vector<Jugador> getJugadores(){
		return this.jugadores;
	}
        public void setNumJugadores(int x){
            this.num_jugadores = x;
        }
	
        public boolean sigueJugando(Jugador j,int multa){
            if(j.getPropiedadesEdificables().isEmpty() && 
               j.getPropiedadesNoEdificables().isEmpty() && 
               j.getDinero()- multa < 0){
                
                return false;
                
            }
            return true;
        }
	public TableroGrafico getTablero(){
		return this.tableroGrafico;	
	}
	
	public void mueveJugadorTableroGrafico(Jugador j,int casillas){
		int casillaActual = j.getCasillaActual();
		if(casillaActual >= 0 &&  casillaActual <= 10){
			tableroGrafico.borraCasillaTablero(j.getTableroFila(),j.getTableroCol());
			tableroGrafico.mueveJugadorTableroInferior(j,casillas);
			tableroGrafico.escribeCasillaTablero(j.getTableroFila(),j.getTableroCol(),j.getTexto());
		}
		else{
			if(casillaActual >= 10 && casillaActual <= 20){
				tableroGrafico.borraCasillaTablero(j.getTableroFila(),j.getTableroCol());
				tableroGrafico.mueveJugadorTableroIzquierdo(j,casillas);
				tableroGrafico.escribeCasillaTablero(j.getTableroFila(),j.getTableroCol(),j.getTexto());
			}
			else{
				if(casillaActual >= 20 && casillaActual <= 30){
					tableroGrafico.borraCasillaTablero(j.getTableroFila(),j.getTableroCol());
					tableroGrafico.mueveJugadorTableroSuperior(j,casillas);	
					tableroGrafico.escribeCasillaTablero(j.getTableroFila(),j.getTableroCol(),j.getTexto());
				}
				else{
					if(casillaActual >=30 && casillaActual <= 40){
						tableroGrafico.borraCasillaTablero(j.getTableroFila(),j.getTableroCol());
						tableroGrafico.mueveJugadorTableroDerecho(j,casillas);
						tableroGrafico.escribeCasillaTablero(j.getTableroFila(),j.getTableroCol(),j.getTexto());
					}
				}
					
			}
		}
	}
	
}
