import java.io.Serializable;

public class TableroGrafico implements Serializable{
    public static String[][] tableroGrafico = new String[23][56];
    public TableroGrafico(){
        for(int i = 0 ; i < 23 ; i++){
            for(int j = 0 ; j < 56;j++){
                //PRIMERA Y ULTIMA FILA ENTERA A "#"
                if(i == 0 || i == 22){
                    tableroGrafico[i][j] = "#";
                }
                else{
                    //FILAS  BORDE CAJA INTERIOR
                    if(i== 2|| i == 20){
                        
                            tableroGrafico[i][j] = "#";
                        
                    }else{
                        //RESTO FILAS
                            if(i == 1 || i == 21){
                                if(j % 5 == 0){
                                tableroGrafico[i][j] = "#";
                                }
                            }
                            else{
                                if(j == 0  || j == 5 || j == 50 || j == 55){
                                    tableroGrafico[i][j] = "#";
                                }
                                else{
                                    if( i % 2 == 0){
                                        if(j <=5 || j >= 50 ){
                                            tableroGrafico[i][j] ="#";
                                        }
                                        
                                    }
                                }
                            }
                           
                        }
                    }
                }
            }
        //HUECOS VACIOS
        for(int i = 0 ; i < 23 ; i++){
            for(int j = 0 ; j <56;j++){
                if(tableroGrafico[i][j] != "#"){
                    tableroGrafico[i][j] = " ";
                }
            }
                
        }
    }
    void mueveJugadorTableroInferior(Jugador j,int casillas){
        if(casillas > 0){
            if(j.getTableroCol() - (5*casillas) >= j.getColLimiteIzq()){            
                j.setTableroCol(j.getTableroCol() -(5*casillas));
            }
            else{
                   int diferenciaCasillas = j.getTableroCol() - (5*casillas);
                   int subeCasillas = 0;
                   while(diferenciaCasillas < 0){
                       diferenciaCasillas+=5;
                       subeCasillas++;
                       
                   }
                   j.setTableroCol(j.getColLimiteIzq());
                   mueveJugadorTableroIzquierdo(j,subeCasillas);
                   
                   
            }
        }
        else{
            if(casillas < 0){
                //AL SER NEGATIVA RETROCEDES CASILLAS, AVANZAS DE COLUMNA
                 if(j.getTableroCol() - (5*casillas) <= j.getColLimiteDch()){            
                    j.setTableroCol(j.getTableroCol() -(5*casillas));
                  }
            else{
                   int diferenciaCasillas = j.getTableroCol() - (5*casillas);
                   int subeCasillas = 0;
                   while(diferenciaCasillas != j.getColLimiteDch()){
                       diferenciaCasillas-=5;
                       subeCasillas--;
                       
                   }
                   j.setTableroCol(j.getColLimiteDch());
                   mueveJugadorTableroDerecho(j,subeCasillas);
                                      
               }
            }
        }
     
            
    }
    
    void mueveJugadorTableroIzquierdo(Jugador j,int casillas){
        if(casillas > 0){
            if(j.getTableroFila() - (2*casillas) >= j.getFilaLimiteSuperior()){            
                j.setTableroFila(j.getTableroFila() -(2*casillas));
            }
            else{
                   int diferenciaCasillas = j.getTableroFila() - (2*casillas);
                   int subeCasillas = 0;
                   while(diferenciaCasillas != j.getFilaLimiteSuperior()){
                       diferenciaCasillas +=2;
                       subeCasillas++;
                                              
                   }
                   j.setTableroFila(j.getFilaLimiteSuperior());
                   mueveJugadorTableroSuperior(j,subeCasillas);
                   
                   
            }
        }
        else{
            if(casillas < 0){
                //AL SER NEGATIVA RETROCEDES CASILLAS, AVANZAS DE COLUMNA
                 if(j.getTableroFila() - (2*casillas) <= j.getFilaLimiteInferior()){            
                    j.setTableroFila(j.getTableroFila() -(2*casillas));
                  }
            else{
                   
                   int diferenciaCasillas = j.getTableroFila() - (2*casillas);
                   System.out.println("la differencia es "+diferenciaCasillas);
                   int subeCasillas = 0;
                   while(diferenciaCasillas != j.getFilaLimiteInferior()){
                       diferenciaCasillas -=2;
                       System.out.println("la differencia dentro del bucle es "+diferenciaCasillas);
                       subeCasillas--;
                       
                   }
                   j.setTableroFila(j.getFilaLimiteInferior());
                   mueveJugadorTableroInferior(j,subeCasillas);
                                      
               }
            }
        }
     
            
    }
    
    void mueveJugadorTableroSuperior(Jugador j,int casillas){
        if(casillas > 0){
            if(j.getTableroCol() + (5*casillas) <= j.getColLimiteDch()){            
                j.setTableroCol(j.getTableroCol() +(5*casillas));
            }
            else{
                   int diferenciaCasillas = j.getTableroCol() + (5*casillas);
                   int subeCasillas = 0;
                   while(diferenciaCasillas != j.getColLimiteDch()){
                       diferenciaCasillas-=5;
                       subeCasillas++;
                       
                   }
                   j.setTableroCol(j.getColLimiteDch());
                   mueveJugadorTableroDerecho(j,subeCasillas);
                   
                   
            }
        }
        else{
            if(casillas < 0){
                //AL SER NEGATIVA RETROCEDES CASILLAS, AVANZAS DE COLUMNA
                 if(j.getTableroCol() + (5*casillas) >= j.getColLimiteIzq()){            
                    j.setTableroCol(j.getTableroCol() + (5*casillas));
                 }
                else{
                   int diferenciaCasillas = j.getTableroCol() + (5*casillas);
                   int subeCasillas = 0;
                   while(diferenciaCasillas != j.getColLimiteIzq()){
                       diferenciaCasillas+=5;
                       subeCasillas--;
                       
                   }
                   j.setTableroCol(j.getColLimiteIzq());
                   mueveJugadorTableroIzquierdo(j,subeCasillas);
                                      
               }
            }
        }
     
            
    }
    
    void mueveJugadorTableroDerecho(Jugador j,int casillas){
        if(casillas > 0){
            if(j.getTableroFila() + (2*casillas) <= j.getFilaLimiteInferior() ){            
                j.setTableroFila(j.getTableroFila() + (2*casillas));
            }
            else{
                   int diferenciaCasillas = j.getTableroFila() + (2*casillas);
                   int subeCasillas = 0;
                   while(diferenciaCasillas != j.getFilaLimiteInferior()){
                       diferenciaCasillas -= 2;
                       subeCasillas++;
                       
                   }
                   j.setTableroFila(j.getFilaLimiteInferior());
                   mueveJugadorTableroInferior(j,subeCasillas);
                   
                   
            }
        }
        else{
            if(casillas < 0){
                //AL SER NEGATIVA RETROCEDES CASILLAS, AVANZAS DE COLUMNA
                 if(j.getTableroFila() + (2*casillas) >= j.getFilaLimiteSuperior()){            
                    j.setTableroFila(j.getTableroFila() + (2*casillas));
                  }
            else{
                   int diferenciaCasillas = j.getTableroFila() + (2*casillas);
                   int subeCasillas = 0;
                   while(diferenciaCasillas != j.getFilaLimiteSuperior()){
                       diferenciaCasillas += 2;
                       subeCasillas--;
                       
                   }
                   j.setTableroFila(j.getFilaLimiteSuperior());
                   mueveJugadorTableroSuperior(j,subeCasillas);
                                      
               }
            }
        }
     
            
    }
    
    public void muestraTablero(){
        for(int i = 0 ; i < 23 ; i++){
            for(int j = 0 ; j <56;j++){
                System.out.print(tableroGrafico[i][j]);
            }
            System.out.println();
        }
    }
    
    public void mueveJugadorTableroGrafico(Jugador j,int casillas){
		int casillaActual = j.getCasillaActual();
		if(casillaActual >= 0 &&  casillaActual <= 10){
			borraCasillaTablero(j.getTableroFila(),j.getTableroCol());
			mueveJugadorTableroInferior(j,casillas);
			escribeCasillaTablero(j.getTableroFila(),j.getTableroCol(),j.getTexto());
		}
		else{
			if(casillaActual >= 10 && casillaActual <= 20){
				borraCasillaTablero(j.getTableroFila(),j.getTableroCol());
				mueveJugadorTableroIzquierdo(j,casillas);
				escribeCasillaTablero(j.getTableroFila(),j.getTableroCol(),j.getTexto());
			}
			else{
				if(casillaActual >= 20 && casillaActual <= 30){
					borraCasillaTablero(j.getTableroFila(),j.getTableroCol());
					mueveJugadorTableroSuperior(j,casillas);	
					escribeCasillaTablero(j.getTableroFila(),j.getTableroCol(),j.getTexto());
				}
				else{
					if(casillaActual >=30 && casillaActual <= 40){
						borraCasillaTablero(j.getTableroFila(),j.getTableroCol());
						mueveJugadorTableroDerecho(j,casillas);
						escribeCasillaTablero(j.getTableroFila(),j.getTableroCol(),j.getTexto());
					}
				}
					
			}
		}
	}
    
    public void borraCasillaTablero(int fila ,int col){
        tableroGrafico[fila][col] = " ";   
    }
    public void escribeCasillaTablero(int fila,int col,String letra){
        tableroGrafico[fila][col] = letra;
    }
   
    
    
}
