public class Suerte extends CasillaMonopoly{

	int cantidadCasillas;
	int cantidadDinero;

	public Suerte(String nombre, int cantidadCasillas, int cantidadDinero){
		super(nombre);
		this.cantidadCasillas = cantidadCasillas;
		this.cantidadDinero = cantidadDinero;
	}
}