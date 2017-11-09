public class Edificable extends Propiedad{

	int alquiler;
	int n_casas;

	public Edificable(String nombre, int valor, int alquiler){
		super(nombre, valor);
		this.alquiler = alquiler;
		this.n_casas = 0;
	}
}