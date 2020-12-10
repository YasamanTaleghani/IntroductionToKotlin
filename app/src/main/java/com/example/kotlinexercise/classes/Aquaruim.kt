package com.example.kotlinexercise.classes

class Aquaruim {
    var width: Int = 20
    var height: Int = 40
    var length: Int = 10
    val volumMax: Int = width*height*length
    var volum = 10000
    val numMaxFish = 0.1 * volumMax
    val numMinPlant = 0.1 * volumMax
    val numMaxPlant = 0.5 * volumMax
    var numPlant: Int = 100
    var myFish = Fish("nonsensitive",0)
    var clearness: Double = 1- ((numMaxFish-myFish.num)/numMaxFish)

    fun clearWater(){
        clearness = 1.0
    }

    fun FishCapacityCheck(fish: Int) = fish + myFish.num < numMaxFish
    fun WaterVolumCheck(water: Int) = water + volum < volumMax
    fun PlantNumCheck(plant: Int): Boolean {
        return plant>numMinPlant && plant<numMaxPlant
    }

    fun FishSensitivityCheck(): Boolean {
        return myFish.type.equals("sensitive")
    }

    fun isWaterClear(): Boolean{
        return !(numPlant < numMinPlant || clearness<0.5)
    }

    fun ClearnessForSensitiveFishes(): Boolean{
        return FishSensitivityCheck() && isWaterClear()
    }

    fun canAddFish(numAddedFish: Int, numAddedPlant: Int, fishType: String = "nonsensitive" ,
                   waterVolumAdded: Int = 0): Boolean{
        return when {
            FishCapacityCheck(numAddedFish) -> true
            PlantNumCheck(numAddedPlant) -> true
            WaterVolumCheck(waterVolumAdded) -> true
            ClearnessForSensitiveFishes() -> true
            else -> false
        }
    }


    fun addFish(numAddedFish: Int, numAddedPlant: Int, fishType: String = "nonsensitive"
                , waterVolumAdded: Int = 0) {
        if (canAddFish(numAddedFish, numAddedPlant, fishType , waterVolumAdded)){
            myFish.num += numAddedFish
            numPlant += numAddedPlant
            volum += waterVolumAdded
            println("Total number of Fishes are: ${myFish.num} & "
                    + "Total number of Plants are: $numPlant & "
                    + "Total water volume is: $volum .")
        } else {
            clearWater()
            println("Can not add any other Fishes. Add some Water to aquarium.")
        }

    }

}