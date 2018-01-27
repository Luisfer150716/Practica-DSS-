import java.util.Scanner;

public class Edificable extends Propiedad{
	boolean tieneDueno;
	int alquiler;
	int n_casas;
	
	public Edificable(String nombre, int valor, int alquiler){
		super(nombre, valor);
		this.alquiler = alquiler;
		this.tieneDueno = false;
		this.n_casas = 0;
	}
	public int getPisos(){
		return n_casas;
	}

	public void setPisos(int i){
		this.n_casas +=i;
	}

	public void accion(Jugador j, PartidaMonopoly p){
               
            if(!tieneDueno){
			if(j.getDinero() >= this.valor){
				System.out.println("Esta propiedad edificable no tiene dueno y cuesta "+this.valor+" , quieres comprarla? 1-Si Otra cosa-no");
				Scanner entrada = new Scanner(System.in);
				int compra = entrada.nextInt();
				if(compra == 1){
					this.tieneDueno = true;
					setDueno(j);
					j.anadirEdificable(this);
					j.setDinero(j.getDinero() - this.valor);
					System.out.println(j.getNombre()+" ha comprado la propiedad "+this.nombre);
					System.out.println(j.getNombre()+" tiene ahora de dinero: "+j.getDinero());
				}
				else{
					System.out.println("Decides no comprarla!");
				}
				
			}
		}
		
		
		else{
			if(this.getDueno().getId() == j.getId()){ //TU ERES EL DUEnO,NO PAGAS, PUEDES CONSTRUIR
				System.out.println("Tu propiedad edificable no tiene casas , quieres construir? 1.-Si / 2.-No");
				Scanner entrada = new Scanner(System.in);
				int compra = entrada.nextInt();
				if(compra == 1){
					boolean casa = false;
					while(!casa){
						if(j.getDinero() >= this.getValor()){
							int construyeMax = j.getDinero() / this.valor;
							System.out.println("Puedes construir hasta "+j.getDinero()/this.valor +" ¿cuantas casas quieres?");
							
							int num_cons = entrada.nextInt();
							while(num_cons < 0 || num_cons > construyeMax){
								System.out.println("Numero incorrecto ,introduce otro"); 
								num_cons = entrada.nextInt();	
							}
							j.setDinero(j.getDinero() - (num_cons * valor));
							j.edificar(this, num_cons);
							casa = true;
						}
						else{
							System.out.println("No tienes suficiente dinero");
							casa = true;	
						}
						
					}
				}
				else{
					System.out.println("Decides no construir!");
				}
			}
			else{
				
				if(this.n_casas == 0){
					System.out.println("Tienes que pagar al jugador "+getDueno().getNombre()+ " la cantidad de "+alquiler+ "euros.");
					j.setDinero(j.getDinero() - alquiler);
				}
				else{
					System.out.println("Tienes que pagar al jugador "+getDueno().getNombre()+ " la cantidad de "+alquiler*n_casas+ "euros.");
					j.setDinero(j.getDinero() - alquiler*n_casas);
				}
			}
			
				
			
			
		
	}
    }
}
