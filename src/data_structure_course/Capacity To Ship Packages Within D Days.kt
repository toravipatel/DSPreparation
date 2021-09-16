package data_structure_course

import kotlin.math.max

fun main() {

    var weights = arrayOf(1,2,3,4,5,6,7,8,9,10)
    println(shipWithinDays(weights.toIntArray(),5))

}

fun shipWithinDays(weights: IntArray, days: Int): Int {

    var maxWeight = 0
    var totalWeight = 0

    weights.forEach {
        totalWeight += it

        maxWeight = Math.max(maxWeight, it)
    }

    if(days == weights.size-1)
        return maxWeight

    var low = maxWeight
    var high = totalWeight
    var ans = -1

    while (low <= high){

        var mid = low + (high-low)/2

        if(isPossible(weights,mid,days)){
            ans = mid
            high = mid - 1
        }else{
            low = mid +1
        }

    }

    return ans
}

fun isPossible(weights: IntArray, mid: Int, days: Int): Boolean {

    var sum = 0
    var count = 1
    weights.forEach {
        sum += it

        if(sum > mid){
            count ++
            sum = it
        }
    }

    return count <= days
}


