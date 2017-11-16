public class Suerte extends CasillaMonopoly{

	public Suerte(String nombre){
		super(nombre);
	}

	public int casillasAleatorio(){
		int cAleatorio = Math.floor(Math.random()*(-5)+(5));
		return cAleatorio;
	}

	public int dineroAleatorio(){
		int dAleatorio = Math.floor(Math.random()*(-200)+200));
		return dAleatorio;
	}
	
	public void accion(Jugador j){
		int a= Math.floor(Math.random()*2+1);
		
		if(a==1){
			j.setCasilla_actual(this.getCasilla_actual+=casillasAleatorio());
		}
		else{
			j.setDinero(this.getDinero()+=dineroAleatorio());
		}
	}
}
