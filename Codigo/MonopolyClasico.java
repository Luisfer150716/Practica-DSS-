/*import java.io.IOException;
import java.util.Scanner;
/**
 *
 * @author Usuario
 
public class MonopolyClasico {

    /**
     * @param args the command line arguments
     
    

    public static void main(String[] args) throws IOException, ClassNotFoundException {
            FabricaMonopolyClasico fabrica = new FabricaMonopolyClasico();
            GestorPartida gestor = GestorPartida.instancia();
            gestor.muestraMenuInicial();
            Scanner sc = new Scanner(System.in);
            int opcion = sc.nextInt();
            switch (opcion) {
                    case 1:	
                            //CREAMOS TABLERO
                            PartidaMonopoly partida = new PartidaMonopoly(fabrica);
                            //AÑADE JUGADORES
                            gestor.configurarPartida(partida);
                            //INICIA PARTIDA
                           gestor.desarrollaPartida(partida);
                            break;	

                    case 2:
                            System.out.println("Introduce el nombre de la partida que quieras cargar");
                            String nombre = sc.next();
                            Object partidaCargada = new PartidaMonopoly(fabrica);
                            partidaCargada = gestor.cargarPartida(nombre);
                            gestor.desarrollaPartida((PartidaMonopoly) partidaCargada);
                            break;
                    default:
                            System.out.println("Poderoso caballero es Don Dinero, hasta luego!");

            }
    }
}
*/