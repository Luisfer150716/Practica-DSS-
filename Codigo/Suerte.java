package monopolyclasico;
public class Suerte extends Casilla{

	public Suerte(String nombre){
		super(nombre);
	}

	public int casillasAleatorio(){
		int cAleatorio = (int)Math.floor(Math.random()*(-5)+(5));
		return cAleatorio;
	}

	public int dineroAleatorio(){
		int dAleatorio = (int)((Math.floor(Math.random()*(-200)+200)));
		return dAleatorio;
	}
	
	public void accion(Jugador j,PartidaMonopoly p){
		int a= (int)Math.floor(Math.random()*2+1);
		
		if(a==1){
                        
                        int mueve = casillasAleatorio();
                        if(j.getCasilla_actual() + mueve < 0){
                            System.out.println("Te mueves a la casilla 0");
                            j.setCasilla_actual(0);
                        }
                        else{
                            
                        
                        System.out.println("Te mueves "+mueve+" casillas");
			j.setCasilla_actual(j.getCasilla_actual()+mueve);
                        }
		}
		else{
                        int dinero = dineroAleatorio();
                        if(j.getDinero() + dinero < 0){
                            if(p.sigueJugando(j,dinero) == false){
                                p.eliminarJugador(j.getId(),"No tienes dinero ni propiedades que hipotecar");
                            }
                            else{
                                //sumar valor todas propiedades
                                //comprobar suma > deuda
                                // si suma < deuda eliminar jugador
                                //si no empezar a hipotecar hasta pagar deuda
                            }
                        }else{
                            System.out.println("Recibes/pierdes "+dinero+" dinero");
                            j.setDinero(j.getDinero() + dinero);
                        }
                       
		}
	}
}
