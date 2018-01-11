package monopolyclasico;

import java.util.Scanner;

public class Edificable extends Propiedad{
	boolean tieneDueño;
	int alquiler;
	int n_casas;
	
	public Edificable(String nombre, int valor, int alquiler){
		super(nombre, valor);
		this.alquiler = alquiler;
		this.tieneDueño = false;
		this.n_casas = 0;
	}
	public int getPisos(){
		return n_casas;	
	}
	public void accion(Jugador j){
               
            if(!tieneDueño){
			if(j.getDinero() >= this.valor){
				System.out.println("Esta propiedad edificable no tiene dueño , quieres comprarla? 1-Si Otra cosa-no");
				Scanner entrada = new Scanner(System.in);
				int compra = entrada.nextInt();
				if(compra == 1){
					this.tieneDueño = true;
					setDueño(j);
					j.anadirEdificable(this);
				}
				else{
					System.out.println("Decides no comprarla!");
				}
				
			}
		}
		
		
		else{
			if(this.getDueño().getId() == j.getId()){ //TU ERES EL DUEÑO,NO PAGAS, PUEDES CONSTRUIR
				System.out.println("Tu propiedad edificable no tiene casas , quieres construir?");
				Scanner entrada = new Scanner(System.in);
				int compra = entrada.nextInt();
				if(compra == 1){
					boolean casa = false;
					while(!casa){
						if(j.getDinero() >= this.getValor()){
							int construyeMax = j.getDinero() / this.valor;
							System.out.println("Puedes construir hasta "+j.getDinero()/this.valor);
							
							int num_cons = entrada.nextInt();
							while(num_cons < 0 || num_cons > construyeMax){
								System.out.println("Numero incorrecto ,introduce otro"); 
								num_cons = entrada.nextInt();	
							}
							this.n_casas = num_cons;
							j.setDinero(j.getDinero() - (num_cons * valor));
							j.edificar(this);
						}
						else{
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
					System.out.println("Tienes que pagar al jugador"+getDueño().getNombre()+ "la cantidad de "+alquiler+ "euros.");
					j.setDinero(j.getDinero() - alquiler);
				}
				else{
					System.out.println("Tienes que pagar al jugador"+getDueño().getNombre()+ "la cantidad de "+alquiler*n_casas+ "euros.");
					j.setDinero(j.getDinero() - alquiler*n_casas);
				}
			}
			
				
			
			
		
	}
    }
}
