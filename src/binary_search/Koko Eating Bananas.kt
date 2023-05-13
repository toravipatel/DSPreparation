package binary_search

import kotlin.math.roundToInt


//https://leetcode.com/problems/koko-eating-bananas/
fun main() {

    var piles = arrayOf(3,6,7,11)
    println(minEatingSpeed(piles.toIntArray(),8))
}

fun minEatingSpeed(piles: IntArray, h: Int): Int {

    piles.sort()
    var low = 0
    var high = piles[piles.size-1]
    var minSpeed = Int.MAX_VALUE

    while (low <= high){

        var speed = (low + high )/2
        var currentSpeedHours = getRequiredHours(piles,speed)

        if(currentSpeedHours > h){
            low = speed + 1

        }else if(currentSpeedHours <= h){
            high = speed - 1
            minSpeed = Math.min(minSpeed,speed)


        }

    }

    return minSpeed
}

fun getRequiredHours(piles: IntArray,currentSpeed:Int):Int{

    var hours = 0

    piles.forEach {

        hours += Math.ceil(it/currentSpeed.toDouble()).toInt()

    }

    return hours
}

