package com.ud.aplication.Logic


object Operaciones {
    fun mostrarCerosAdyacentes(f: Int, c: Int, tablero: Array<Array<Casilla1>>) {
        tablero[f][c].setEstado("levantada")
        for (ft in (f - 1)..(f + 1)) {
            for (ct in (c - 1)..(c + 1)) {
                if ((ft >= 0) && (ct >= 0) && (ft < tablero.size) && (ct < tablero[0].size) && (ft != f || ct != c)) {
                    if (tablero[ft][ct].getEstado() != "levantada") {
                        tablero[ft][ct].setEstado("levantada")
                        if (tablero[ft][ct].getValor() == 0) {
                            mostrarCerosAdyacentes(ft, ct, tablero)
                        }
                    }
                }
            }
        }
    }

    fun mostrarMinas(tablero: Array<Array<Casilla1>>) {
        for (i in tablero.indices) {
            for (j in tablero[i].indices) {
                if (tablero[i][j].getValor() == 100) {
                    tablero[i][j].setEstado("mina reventada")
                }
            }
        }
    }
}

