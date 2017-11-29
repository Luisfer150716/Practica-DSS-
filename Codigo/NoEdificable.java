package monopolyclasico;
import java.util.Scanner;

public class NoEdificable extends Propiedad{
	
	boolean tieneDueño;
	int pago;

	public NoEdificable(String nombre, int valor, int pago){
		super(nombre, valor);
		this.pago = pago;
		this.tieneDueño = false;
	}
	
	public void accion(Jugador j){
		Scanner sc = new Scanner(System.in);
		
		if(!tieneDueño){
			if(j.getDinero() >= this.valor){
				System.out.println("Esta propiedad no edificable tiene dueño, quieres comprarla? 1.-Si/ 2.-No");
				int compra= sc.nextInt();
				if(compra == 1){
					this.tieneDueño= true;
					setDueño(j);
					j.anadirNoEdificable(this);
				}
				else{
					System.out.println("Decides no comprarla!");
				}
			}
		}
		else{
			if(getDueño().getId()!=j.getId()){
				System.out.println("Tienes que pagar "+pago+" a "+getDueño().getNombre());
				j.setDinero(j.getDinero()-pago);
				getDueño().setDinero(j.getDinero()+pago);
			}
			else{
				System.out.println("Esta propiedad no edificable es tuya!");
			
                        }
                }
        }
}
