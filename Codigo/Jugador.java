import java.util.Vector;
public class Jugador{
	private String nombre, figura;
	private int casilla_actual, dinero;
	private int id;
	private boolean estasCarcel;
	private Vector<Edificable> propiedadesEdificables = new Vector<Edificable>(); 
	private Vector<NoEdificable> propiedadesNoEdificables = new Vector<NoEdificable>();

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
		System.out.println("Propiedades edificables: ");
		for(int j = 0; j <this.propiedadesEdificables.size(); j++){
			System.out.println(j+": "+this.propiedadesEdificables.elementAt(j).getNombre());
		}
		System.out.println("Propiedades no edificables: ");
		for(int j = 0; j <this.propiedadesNoEdificables.size(); j++){
			System.out.println(j+": "+this.propiedadesNoEdificables.elementAt(j).getNombre());
		}
	}
	public String getNombre() {return this.nombre;}
	public String getFigura() {return this.figura;}
	public int getCasilla_actual() {return this.casilla_actual;}
	public int getDinero() {return this.dinero;}
	public boolean getCarcel(){return this.estasCarcel;}
	public int getId(){return this.id;}
	public Vector<Edificable> getPropiedadesEdificables(){ return this.propiedadesEdificables;}
	public Vector<NoEdificable> getPropiedadesNoEdificables(){ return this.propiedadesNoEdificables;}
	public void setNombre(String nombre) {this.nombre = nombre;}
	public void setFigura(String figura) {this.figura = figura;}
	public void setCasilla_actual(int casilla_actual) {this.casilla_actual = casilla_actual;}
	public void setDinero(int dinero) { this.dinero = dinero;}
	public void setId(int id){this.id=id;}
	public void setCarcel(boolean estasCarcel){this.estasCarcel = estasCarcel;}
	public void setPropiedadesEdificables(Vector<Edificable> propiedades) {this.propiedadesEdificables = propiedades;}
	public void setPropiedadesNoEdificables(Vector<NoEdificable> propiedades) {this.propiedadesNoEdificables = propiedades;}
	public void lanzarDados(){
			int x = (int)Math.floor(Math.random()*6+1);
			int y = (int)Math.floor(Math.random()*6+1);
			System.out.println("Has sacado: "+ (x+y));

			if(this.casilla_actual+(x+y)>39){
				this.dinero+=200;
			}

			this.casilla_actual = (this.casilla_actual +(x+y))%39;

	}
	
	public int sumaValorPropiedades(){
		int suma= 0;

		for(int i=0; i<propiedadesEdificables.size();i++){
			suma+= propiedadesEdificables.elementAt(i).getValor();
		}

		for(int i=0; i<propiedadesEdificables.size();i++){
			suma+= propiedadesNoEdificables.elementAt(i).getValor();
		}

		return suma;
	}
	
	/*No hacemos uso de estos metodos
	
	public void comprarPropiedadNoEdificable(NoEdificable p){
		//NO EDIFICABLES		
		if(casilla_actual == 6 || casilla_actual == 13 || casilla_actual == 16 || casilla_actual == 26 || 
			casilla_actual == 29 || casilla_actual == 36)
			if(p.getValor() <= dinero)
				propiedadesNoEdificables.add(p);
			else System.out.println("No tienes suficiente dinero.");
	}

	public void comprarPropiedadEdificable(Edificable p){
		//EDIFICABLES
		if(!(casilla_actual == 6 || casilla_actual == 13 || casilla_actual == 16 || casilla_actual == 26 || 
			casilla_actual == 29 || casilla_actual == 36))
			if(p.getValor() <= dinero)
				propiedadesEdificables.add(p);
			else System.out.println("No tienes suficiente dinero.");		

	}
	*/

	public int consultarDinero(){
		return getDinero();
	}

	public void edificar(Edificable p, int pisos){
		
		boolean encontrado = false;
		
		for(int i = 0 ; i < propiedadesEdificables.size();i++){
			if(propiedadesEdificables.elementAt(i).getNombre() == p.getNombre()){
				propiedadesEdificables.elementAt(i).setPisos(pisos);
				encontrado = true;
			}
		}
		if(encontrado){
			System.out.println("Se ha edificado correctamente, ahora el jugador "+this.getNombre()+" tiene "+p.getPisos()+
                                " pisos en la propiedad "+p.getNombre());
		}
		else{
			System.out.println("No se pudo edificar");
		}	
	}

	public void anadirEdificable(Edificable propiedad){
		propiedadesEdificables.add(propiedad);
    }
		
	public void anadirNoEdificable(NoEdificable propiedad){
		propiedadesNoEdificables.add(propiedad);
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
				banca.anadirNoEdificable(propiedadesNoEdificables.elementAt(i));
				propiedadesNoEdificables.remove(i);
			}
		}
	}
	public void borrarEdificable(String nombreCasilla){
		boolean encontrado = false;
		for(int i= 0; i<propiedadesEdificables.size(); i++){
			if(propiedadesEdificables.elementAt(i).getNombre().equals(nombreCasilla)){
				propiedadesEdificables.remove(i);
				System.out.println("Casilla "+nombreCasilla+" en posesion de la banca");
				encontrado = true;
			}
		}
		if(!encontrado){
			System.out.println("Casilla no encontrada, no se puede borrar");
		}
	}

	public void borrarNoEdificable(String nombreCasilla){
		boolean encontrado = false;
		for(int i= 0; i<propiedadesNoEdificables.size(); i++){
			if(propiedadesNoEdificables.elementAt(i).getNombre().equals(nombreCasilla)){
				propiedadesNoEdificables.remove(i);
				System.out.println("Casilla "+nombreCasilla+" en posesion de la banca");
				encontrado = true;
			}
		}
		if(!encontrado){
			System.out.println("Casilla no encontrada, no se puede borrar");
		}
	}
	
	public void pagaDeuda(){
            Scanner sc = new Scanner(System.in);
            boolean deudaPagada = false;
            while(!deudaPagada){
                mostrarPropiedades();
                System.out.println("Introduce 1 para hipotecar edificables, 2 para no edificables");
                int op = sc.nextInt();
                if(op == 1){
                        if(!getPropiedadesEdificables().isEmpty()){
                                System.out.println("Introduce el numero de la propiedad edificable que quieras eliminar");
                                int pr = sc.nextInt();
                                hipotecaPropiedad(true,pr);	

                        }
                        else{
                                System.out.println("No tienes propiedades edificables!");
                        }

                }else{
                        if(!getPropiedadesNoEdificables().isEmpty()){
                                System.out.println("Introduce el numero de la propiedad no edificable que quieras eliminar");
                                int pr = sc.nextInt();
                                hipotecaPropiedad(false,pr);	
                        }
                        else{
                                System.out.println("No tienes propiedades no edificables!");
                        }

                }
                if(getDinero() >= 0){
                        deudaPagada = true;
                }
            }
        }
}
