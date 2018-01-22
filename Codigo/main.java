import java.io.IOException;
import java.util.Scanner;

public class main{
    public static void main(String[] args) throws IOException, ClassNotFoundException {
            //FabricaTablero fabrica = FabricaTablero.instancia("FabricaMonopolyClasico");
            FabricaTablero fabrica = FabricaTablero.getFabrica();

            //CREAMOS TABLERO
            TableroGrafico t = new TableroGrafico();
            
            GestorPartida gestor =  GestorPartida.instancia();
            //GestorPartida gestor = gestor.instancia();
            gestor.muestraMenuInicial();
            Scanner sc = new Scanner(System.in);
            int opcion = sc.nextInt();
            switch (opcion) {
                    case 1:	
                            PartidaMonopoly partida = new PartidaMonopoly(fabrica, t);
                            //AÑADE JUGADORES
                            gestor.configurarPartida(partida);
                            //INICIA PARTIDA
                            gestor.desarrollaPartida(partida);
                            break;	

                    case 2:
                            System.out.println("Introduce el nombre de la partida que quieras cargar");
                            String nombre = sc.next();
                            Object partidaCargada = new PartidaMonopoly(fabrica, t);
                            partidaCargada = gestor.cargarPartida(nombre);
                            gestor.desarrollaPartida((PartidaMonopoly) partidaCargada);
                            break;
                    default:
                            System.out.println("Poderoso caballero es Don Dinero, hasta luego!");

            }
    }

}
    

