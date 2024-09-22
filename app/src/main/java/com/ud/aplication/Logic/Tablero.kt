package com.ud.aplication.Logic

class Tablero {
    public companion object {
        var tablero: Array<Array<Casilla>>? = null

        fun inicializarTablero(f: Int, c: Int) {
            tablero = Array(f) { Array(c) { Casilla() } }
        }

        fun generarMinas(f: Int, c: Int, m: Int) {
            for (contador in 0 until m) {
                var ft: Int
                var ct: Int
                do {
                    ft = (0 until f).random()
                    ct = (0 until c).random()
                } while (tablero!![ft][ct].getValor() == 100)

                tablero!![ft][ct].setValor(100)
                for (ft2 in (ft - 1)..(ft + 1)) {
                    for (ct2 in (ct - 1)..(ct + 1)) {
                        if (ft2 in 0 until f && ct2 in 0 until c && tablero!![ft2][ct2].getValor() != 100) {
                            tablero!![ft2][ct2].setValor(tablero!![ft2][ct2].getValor() + 1)
                        }
                    }
                }
            }
        }

        fun getTablero(f: Int, c: Int, m: Int): Array<Array<Casilla>> {
            if (tablero == null) {
                inicializarTablero(f, c)
                generarMinas(f, c, m)
            }
            return tablero!!
        }
    }
}


