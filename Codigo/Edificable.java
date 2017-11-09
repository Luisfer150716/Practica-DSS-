public class Edificable extends Propiedad{

	int alquiler;
	int n_casas;

	public Edificable(String nombre, int valor, int alquiler, int n_casas){
		super(nombre, valor);
		this.alquiler = alquiler;
		this.n_casas = n_casas;
	}
}