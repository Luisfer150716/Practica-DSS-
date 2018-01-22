public class Suerte extends Casilla{

    public Suerte(String nombre){
        super(nombre);
    }

    public int casillasAleatorio(){
        int cAleatorio = (int)Math.floor(Math.random()*(-5)+(5));
        return cAleatorio;
    }

    public int dineroAleatorio(){
        int dAleatorio = (int)((Math.floor(Math.random()*(-200)+200)));
        return dAleatorio;
    }
    
    public void accion(Jugador j,PartidaMonopoly p){
        int a= (int)Math.floor(Math.random()*2+1);
        
        if(a==1){
                        
                        int mueve = casillasAleatorio();
            //PARA TABLERO GRAFICO
            TableroGrafico t = p.getTableroGrafico();
            t.mueveJugadorTableroGrafico(j,mueve);
            //
                        System.out.println("Te mueves "+mueve+" casillas");
                        int siguienteCasilla = j.getCasillaActual() + mueve;
                        if(siguienteCasilla < 0){
                            int casillaFinal = 39 + siguienteCasilla +1;
                            System.out.println("Ahora estás en la casilla "+casillaFinal);
                            j.setCasillaActual(casillaFinal);
                        }
                        else{                     
                            j.setCasillaActual(siguienteCasilla);
                        }
        }
        else{
                        int dinero = dineroAleatorio();
                        j.setDinero(j.getDinero() + dinero);
                        if(j.getDinero() < 0){
                            System.out.println("Recibes una multa de "+dinero);
                            System.out.println("Tienes una deuda de "+j.getDinero());
                            if(p.sigueJugando(j, dinero) == false){
                                p.eliminarJugador(j.getId(),"No tienes dinero ni propiedades que hipotecar");
                            }
                            else{
                                int valorEdificables = j.sumaValorPropiedades();
                                if((valorEdificables + j.getDinero()) < 0){
                                    p.eliminarJugador(j.getId(),"El valor de tus propiedades no es suficiente para pagar tus deudas");
                                }
                                else{
                                    j.pagaDeuda();
                                    System.out.println("Te has quedado con "+j.getDinero()+" de dinero y con las siguientes propiedades: ");
                                    j.mostrarPropiedades();
                                }
                             
                            }
                        }else{
                            System.out.println("Te toca la lotería, has ganado "+dinero);
                            j.setDinero(j.getDinero() + dinero);
                        }
                       
        }
    }
}
