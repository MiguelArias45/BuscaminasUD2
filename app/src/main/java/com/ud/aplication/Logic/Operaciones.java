package com.ud.aplication.Logic;

public class Operaciones {

    //f y c son la fila y la columna seleccionada por el usuario
    public static void mostrarCerosAdyacentes(int f, int c, Casilla[][] tablero){
        tablero[f][c].setEstado("levantada");
        for (int ft = (f-1); ft <= (f+1); ft++){
            for (int ct = (c-1); ct <= (c+1);ct++){
                if ((ft>=0) && (ct>=0) && (ft< tablero.length) && (ct<tablero[0].length) && ( (ft!=f) ||(ct!=c))){
                    if (tablero[ft][ct].getEstado() != "levantada"){
                        tablero[f][c].setEstado("levantada");
                        if (tablero[ft][ct].getValor() == 0){
                            mostrarCerosAdyacentes(ft,ct,tablero);
                        }
                    }
                }
            }
        }
    }

    /*
     * Cuando el jugador pierde se tienen que mostrar
     * */

    public static void mostrarMinas (Casilla[][] tablero){
        for (int i =0; i< tablero.length;i++){
            for (int j=0; j<tablero[0].length;j++){
                if(tablero[i][j].getValor()==100){
                    tablero[i][j].setEstado("mina reventada");
                }
            }
        }
    }

}

