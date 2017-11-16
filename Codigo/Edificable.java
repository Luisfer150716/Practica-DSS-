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
	
	public void accion(Jugador j){
		if(!tieneDueño){
			if(j.getDinero() >= this.valor){
				System.out.println("Esta propiedad edificable no tiene dueño , quieres comprarla?");
				Scanner entrada = new Scanner(System.in);
				int compra = entrada.nextInt();
				if(compra = 1){
					this.tieneDueño = true;
					this.Dueño = j;
					j.anadirEdificable(this);
				}
				else{
					System.out.println("Decides no comprarla!");
				}
				
			}
		}
		
		
		else{
			if(this.n_casas == 0){
				System.out.println("Tienes que pagar al jugador"+dueño.getNombre()+ "la cantidad de "+alquiler+ "euros.");	
			}
			else{
				
			System.out.println("Tienes que pagar al jugador"+dueño.getNombre()+ "la cantidad de "+alquiler*n_casas+ "euros.");
			
		}
	}
}
