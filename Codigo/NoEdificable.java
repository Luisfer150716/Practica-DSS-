package monopolyclasico;
import java.util.Scanner;

public class NoEdificable extends Propiedad{
	
	boolean tieneDuenno;
	int pago;

	public NoEdificable(String nombre, int valor, int pago){
		super(nombre, valor);
		this.pago = pago;
		this.tieneDuenno = false;
	}
	
	public void accion(Jugador j){
		Scanner sc = new Scanner(System.in);
		
		if(!tieneDuenno){
			if(j.getDinero() >= this.valor){
				System.out.println("Esta propiedad no edificable tiene duenno, quieres comprarla? 1.-Si/ 2.-No");
				int compra= sc.nextInt();
				if(compra == 1){
					this.tieneDuenno= true;
					setDuenno(j);
					j.anadirNoEdificable(this);
				}
				else{
					System.out.println("Decides no comprarla!");
				}
			}
		}
		else{
			if(getDuenno().getId()!=j.getId()){
				System.out.println("Tienes que pagar "+pago+" a "+getDuenno().getNombre());
				j.setDinero(j.getDinero()-pago);
				getDuenno().setDinero(j.getDinero()+pago);
			}
			else{
				System.out.println("Esta propiedad no edificable es tuya!");
			
                        }
                }
        }
}
