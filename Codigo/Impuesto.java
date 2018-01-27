public class Impuesto extends Casilla{
	int cantidad;

	public Impuesto(String nombre){
		super(nombre);
		this.cantidad = 150;
	}
        
    
        public void accion(Jugador j,PartidaMonopoly p){
            System.out.println("Te toca pagar impuestos, pagas: "+cantidad);
            j.setDinero(j.getDinero() - cantidad);
        }

        public void setCantidad(int c){this.cantidad = c;}
        public int getCantidad(){return this.cantidad;}

   
}