package com.example.kotlinexercise.classes

fun main () {
    addFish()
}

fun addFish(){
    var aquaruim = Aquaruim()
    aquaruim.addFish(20,10, "sensitive" , 0)
    aquaruim.addFish(200,10, "sensitive" ,0)
    aquaruim.addFish(1000,10, "sensitive" ,0)
    aquaruim.addFish(100,10, "sensitive" ,1000)
}