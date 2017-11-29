package monopolyclasico;
import java.util.Vector;
public class Jugador{
	private String nombre, figura;
	private int casilla_actual, dinero;
	private int id;
	private boolean estasCarcel;
	private Vector<Propiedad> propiedadesEdificables; 
	private Vector<Propiedad> propiedadesNoEdificables; 

	public Jugador(String nombre, String figura, int casilla_actual, int dinero,int id){
		this.nombre = nombre;
		this.figura = figura;
		this.casilla_actual = casilla_actual;
		this.dinero = dinero;
		this.id = id;
	}
	public void mostrarEstado(){
		System.out.println("Dinero: " +this.dinero);
		System.out.println("Casilla actual: "+casilla_actual);
		mostrarPropiedades();
		
	}
	public void mostrarPropiedades(){
		for(int j = 0; j <this.propiedadesEdificables.size(); j++){
			System.out.println(this.propiedadesEdificables.elementAt(j).getNombre());
		}
		System.out.println("Propiedades no edificables: ");
		for(int j = 0; j <this.propiedadesNoEdificables.size(); j++){
			System.out.println(this.propiedadesNoEdificables.elementAt(j).getNombre());
		}
	}
	public String getNombre() {return this.nombre;}
	public String getFigura() {return this.figura;}
	public int getCasilla_actual() {return this.casilla_actual;}
	public int getDinero() {return this.dinero;}
	public boolean getCarcel(){return this.estasCarcel;}
	public int getId(){return this.id;}
	public Vector<Propiedad> getPropiedadesEdificables(){ return this.propiedadesEdificables;}
	public Vector<Propiedad> getPropiedadesNoEdificables(){ return this.propiedadesNoEdificables;}
	public void setNombre(String nombre) {this.nombre = nombre;}
	public void setFigura(String figura) {this.figura = figura;}
	public void setCasilla_actual(int casilla_actual) {this.casilla_actual = casilla_actual;}
	public void setDinero(int dinero) { this.dinero = dinero;}
	public void setId(int id){this.id=id;}
	public void setCarcel(boolean estasCarcel){this.estasCarcel = estasCarcel;}
	public void setPropiedadesEdificables(Vector<Propiedad> propiedades) {this.propiedadesEdificables = propiedades;}
	public void setPropiedadesNoEdificables(Vector<Propiedad> propiedades) {this.propiedadesNoEdificables = propiedades;}
	public void lanzarDados(){
			int x = (int)Math.floor(Math.random()*6+1);
			int y = (int)Math.floor(Math.random()*6+1);
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

	public void edificar(Edificable p){
		
		boolean encontrado = false;
		
		for(int i = 0 ; i < propiedadesEdificables.size();i++){
			if(propiedadesEdificables.elementAt(i).getNombre() == p.getNombre()){
				propiedadesEdificables.add(i,p);
				encontrado = true;
			}
		}
		if(encontrado){
			System.out.println("Se ha edificado correctamente, ahora el jugador"+this.getNombre()+" tiene "+p.getPisos()+
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
			if(propiedadesEdificables.elementAt(i) == null){
				propiedadesEdificables.add(i,propiedad) ;
				colocada = true;
			}
			i++;
		}
        }
		
	public void anadirNoEdificable(NoEdificable propiedad){
		boolean colocada = false;
		int i = 0;
		while(!colocada || i >27){
			if(propiedadesNoEdificables.elementAt(i) == null){
				propiedadesNoEdificables.add(i,propiedad) ;
				colocada = true;
			}
			i++;
		}
        }
	public void hipotecaPropiedad(boolean edificable,Jugador banca,int i){
		if(edificable){
			if(propiedadesEdificables.elementAt(i) != null){
				this.dinero = this.dinero + propiedadesEdificables.elementAt(i).getValor();
				System.out.println("Ya no posees la propiedad "+propiedadesEdificables.elementAt(i).getNombre());
				banca.anadirEdificable(propiedadesEdificables.elementAt(i));
				propiedadesEdificables.remove(i);
			}
		}
		else{
			if(propiedadesNoEdificables.elementAt(i) != null){
				this.dinero = this.dinero + propiedadesNoEdificables.elementAt(i).getValor();
				System.out.println("Ya no posees la propiedad "+propiedadesNoEdificables.elementAt(i).getNombre());
				banca.anadirEdificable(propiedadesNoEdificables.elementAt(i));
				propiedadesNoEdificables.remove(i);
			}
		}
	}
	public void borrarEdificable(int i){
		if(propiedadesEdificables.elementAt(i) == null){
			System.out.println("No existe dicho  edificable");
		}
		else{

			propiedadesEdificables.remove(i);
			System.out.println("Propiedad eliminada. Ahora esta en posesion de la banca");
		}
	}
	public void borrarNoEdificable(int i){
		if(propiedadesNoEdificables.elementAt(i) == null){
			System.out.println("No existe dicho no edificable");
		}
		else{
			propiedadesNoEdificables.remove(i);
			System.out.println("Propiedad eliminada. Ahora esta en posesion de la banca");
		}
		
	}
}
