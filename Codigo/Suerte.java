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
	
	public void accion(Jugador j){
		int a= (int)Math.floor(Math.random()*2+1);
		
		if(a==1){
                        int mueve = casillasAleatorio();
			j.setCasilla_actual(j.getCasilla_actual()+mueve);
		}
		else{
                        int dinero = dineroAleatorio();
			j.setDinero(j.getDinero() + dinero);
		}
	}
}
