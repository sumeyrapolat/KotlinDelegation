package com.sumeyra.delegationkotlin

fun main(){

    // LAZY
    val myLazyVariable by lazy {
        println("my lazy fun is used")
        "Lazy Sumyera"
    }

    println(myLazyVariable)

}