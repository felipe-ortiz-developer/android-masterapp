package com.example.maestrapp

val nombre: String = "Felipe"
val edad: Int = 29
val salario: Int = 1600000

fun main(){
    println("Mis pelotas")
    imprimirDatos(nombre, edad, salario)
}

fun imprimirDatos(nombre: String, edad: Int, salario: Int){
    println("Su nombre es: ${nombre}")
    println("Su edad es: ${edad}")
    println("Su salario es: ${salario}")
}