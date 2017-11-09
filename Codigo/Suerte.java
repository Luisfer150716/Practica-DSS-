public class Suerte extends CasillaMonopoly{

	public Suerte(String nombre){
		super(nombre);
	}

	public void aleatorio(){
		int a= Math.floor(Math.random()*2+1;

		if(a==1){casillasAleatorio();}
		else{dineroAleatorio();}
	}

	public int casillasAleatorio(){
		int cAleatorio = Math.floor(Math.random()*5+1);
		return cAleatorio;
	}

	public int casillasAleatorio(){
		int dAleatorio = Math.floor(Math.random()*(-200)+200));
		return dAleatorio;
	}
}