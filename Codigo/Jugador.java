
public class Jugador{
	private String nombre, figura;
	private int casilla_actual, dinero;
	private int id;
	private boolean estasCarcel;
	private Vector<Propiedad> propiedadesEdificables; 
	private Vector<Propiedad> propiedadesNoEdificables; 

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
	public boolean getCarcel(){return this.estasCarcel;}
	public Propiedad[] getPropiedadesEdificables(){ return this.propiedadesEdificables;}
	public Propiedad[] getPropiedadesNoEdificables(){ return this.propiedadesNoEdificables;}
	public void setNombre(String nombre) {this.nombre = nombre;}
	public void setFigura(String figura) {this.figura = figura;}
	public void setCasilla_actual(int casilla_actual) {this.casilla_actual = casilla_actual;}
	public void setDinero(int dinero) { this.dinero = dinero;}
	public void setId(int id){this.id=id;}
	public void setCarcel(boolean){this.estasCarcel = estasCarcel;}
	public void setPropiedadesEdificables(Propiedad[] propiedades) {this.propiedadesEdificables = propiedades;}
	public void setPropiedadesNoEdificables(Propiedad[] propiedades) {this.propiedadesNoEdificables = propiedades;}
	public void lanzarDados(){
			int x = Math.floor(Math.random()*6+1);
			int y = Math.floor(Math.random()*6+1);
			System.out.println("Has sacado: "+ (x+y));

			this.casilla_actual += (x+y);
	}

	public void comprarPropiedad(Propiedad p){
		//NO EDIFICABLES		
		if(casilla_actual == 6 || casilla_actual == 13 || casilla_actual == 16 || casilla_actual == 26 || 
			casilla_actual == 29 || casilla_actual == 36)
			if(p.getValor() <= dinero)
				propiedadesNoEdificables.add(casilla_actual);
			else System.out.println("No tienes suficiente dinero.");
		//EDIFICABLES
		else 
			if(p.getValor() <= dinero)
				propiedadesEdificables.add(casilla_actual);
			else System.out.println("No tienes suficiente dinero.");

		

	}


	public int consultarDinero(){
		return getDinero();
	}

	public void edificar(Propiedad p){
		int i = 0; 
		boolean encontrado = false;
		
		for(int i = 0 ; i < propiedadesEdificables.size();i++){
			if(propiedadesEdificables.elementAt(i).getNombre() == p.getNombre){
				propiedadesEdificables.add(i,p);
				encontrado = true;
			}
		}
		if(encontrada){
			System.out.println("Se ha edificado correctamente, ahora el jugador"+this.getName()+" tiene "+p.getPisos()
					   " en la propiedad "+p.getNombre());
		}
		else{
			System.out.println("No se pudo edificar");
		}
			

		
		
	}
	public void anadirEdificable(Edificable propiedad){
		boolean colocada = false;
		int i = 0;
		while(!colocada || i >27){
			if(propiedadesEdificables[i] == null){
				propiedadesEdificables[i] = propiedad;
				colocada = true;
			}
			i++;
		}
		
	public void anadirNoEdificable(NoEdificable propiedad){
		boolean colocada = false;
		int i = 0;
		while(!colocada || i >27){
			if(propiedadesNoEdificables[i] == null){
				propiedadesNoEdificables[i] = propiedad;
				colocada = true;
			}
			i++;
		}
			
	}
	
	public void borrarEdificable(int i){
		propiedadesEdificables.remove(i);
	}
	public void borrarNoEdificable(int i){
		propiedadesNoEdificables.remove(i);
	}
}
