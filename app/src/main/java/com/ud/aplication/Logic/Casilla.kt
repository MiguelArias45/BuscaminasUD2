package com.ud.aplication.Logic

class Casilla {
    private var valor = 0
    private var estado = "oculta"

    fun setEstado(estado: String) {
        this.estado = estado
    }

    fun setValor(valor: Int) {
        this.valor = valor
    }

    fun getValor(): Int {
        return valor
    }

    fun getEstado(): String {
        return estado
    }
}

