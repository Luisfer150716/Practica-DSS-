import java.util.Scanner;

public class NoEdificable extends Propiedad{
	
	boolean tieneDueno;
	int pago;

	public NoEdificable(String nombre, int valor, int pago){
		super(nombre, valor);
		this.pago = pago;
		this.tieneDueno = false;
	}
	
	public void accion(Jugador j, PartidaMonopoly p){
		Scanner sc = new Scanner(System.in);
		
		if(!tieneDueno){
			if(j.getDinero() >= this.valor){
				System.out.println("Esta propiedad no edificable no tiene dueno y cuesta "+this.valor+", quieres comprarla? 1.-Si/ Resto.-No");
				int compra= sc.nextInt();
				if(compra == 1){
					this.tieneDueno= true;
					setDueno(j);
					j.anadirNoEdificable(this);
					System.out.println(j.getNombre()+" ha comprado la propiedad "+this.nombre);
					j.setDinero(j.getDinero() - this.valor);
					System.out.println(j.getNombre()+" tiene ahora de dinero: "+j.getDinero());
				}
				else{
					System.out.println("Decides no comprarla!");
				}
			}
		}
		else{
			if(getDueno().getId()!=j.getId()){
				System.out.println("Tienes que pagar "+pago+" a "+getDueno().getNombre());
				j.setDinero(j.getDinero()-pago);
				getDueno().setDinero(j.getDinero()+pago);
			}
			else{
				System.out.println("Esta propiedad no edificable es tuya!");
			
                        }
                }
        }
}
