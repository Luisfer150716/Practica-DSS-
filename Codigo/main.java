/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopolyclasico;
import java.io.IOException;
import java.util.Scanner;

public class main{
    public static void main(String[] args) throws IOException, ClassNotFoundException {
            FabricaTablero fabrica = FabricaTablero.instancia("FabricaMonopolyClasico");
            GestorPartida gestor =  GestorPartida.instancia();
            
            //GestorPartida gestor = gestor.instancia();
            gestor.muestraMenuInicial();
            Scanner sc = new Scanner(System.in);
            int opcion = sc.nextInt();
            switch (opcion) {
                    case 1:	
                            //CREAMOS TABLERO
                            TableroGrafico tablero = new TableroGrafico();
                            PartidaMonopoly partida = new PartidaMonopoly(fabrica,tablero);
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
    

