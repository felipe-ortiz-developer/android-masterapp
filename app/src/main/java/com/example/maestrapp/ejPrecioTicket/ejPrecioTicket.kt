package com.example.maestrapp.ejPrecioTicket



fun main(){
    val niño = 5
    val adulto = 28
    val senior = 87

    val esLunes = true

    println("Hoy es Lunes?: ${esLunes}")
    println("El precio para la 1ra persona agendada de $niño es \$${ticketPrice(niño, esLunes)}.")
    println("El precio para la 2da persona agendada de $adulto es \$${ticketPrice(adulto, esLunes)}.")
    println("El precio para la 3ra persona agendada de $senior es \$${ticketPrice(senior, esLunes)}.")
}

fun ticketPrice(tipo: Int, esLunes: Boolean): Int{
    return when (tipo){
        in 0..12 -> 15
        in 13..60 -> if(esLunes) 25 else 30
        in 61..100 -> 20
        else -> -1 // los when necesitan un else
    }
}
