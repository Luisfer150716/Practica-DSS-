
public class Jugador{
	private String nombre, figura;
	private int casilla_actual, dinero;
	private Propiedad[28] propiedades; 
	//private Propiedad[6] propiedadesNoEdificables; 

	public Jugador(String nombre, String figura, int casilla_actual, int dinero){
		this.nombre = nombre;
		this.figura = figura;
		this.casilla_actual = casilla_actual;
		this.dinero = dinero;
	}

	public String getNombre() {return this.nombre;}
	public String getFigura() {return this.figura;}
	public int getCasilla_actual() {return this.casilla_actual;}
	public int getDinero() {return this.dinero;}
	public Propiedad[] getPropiedad(){ return this.propiedades;}

	public void setNombre(String nombre) {this.nombre = nombre;}
	public void setFigura(String figura) {this.figura = figura;}
	public void setCasilla_actual(int casilla_actual) {this.casilla_actual = casilla_actual;}
	public void setDinero(int dinero) { this.dinero = dinero;}
	public void setPropiedades(Propiedad[] propiedades) {this.propiedades = propiedades;}

	public void lanzarDados(){
			int x = Math.floor(Math.random()*6+1);
			int y = Math.floor(Math.random()*6+1);
			System.out.println("Has sacado: "+ (x+y));

			this.casilla_actual += (x+y);
	}

	public void comprarPropiedad(Propiedad p){
		int i=1;
		while(propiedades[i] != "") {
			i++;
		}
		if(casilla_actual == 6 || casilla_actual == 13 || casilla_actual == 16 || casilla_actual == 26 || 
			casilla_actual == 29 || casilla_actual == 36)
			if(p.getValor() <= dinero)
				propiedadesNoEdificables[i] = casilla_actual;
			else System.out.println("No tienes suficiente dinero.");
		else 
			if(p.getValor() <= dinero)
				propiedadesEdificables[i] = casilla_actual;
			else System.out.println("No tienes suficiente dinero.");

		

	}


	public int consultarDinero(){
		return getDinero();
	}

	public void edificar(int n_pisos){
		int i =0;
		while (propiedadesEdificables[i] != casilla_actual || i!=23){
			i++;

		}

		if(i==23) System.out.println("No tienes esta propiedad");
		else {
			propiedadesEdificables[i].setN_casas(propiedadesEdificables[i].getN_casas() + n_pisos);
			System.out.println("Piso construido");
		}
	}

}
