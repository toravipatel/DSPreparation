package sliding_window

import kotlin.math.max

//https://leetcode.com/problems/maximum-average-subarray-i/
fun main() {

    println(findMaxAverage(arrayOf(1,12,-5,-6,50,3).toIntArray(),4))
}

fun findMaxAverage(nums: IntArray, k: Int): Double {

    if(nums.size == 1)
        return nums[0].toDouble()

    var i = 0
    var j = 0
    var size = nums.size

    var currentSum:Double = 0.0
    var maxAverageSum = Double.MIN_VALUE

    while (j < size){

        currentSum += nums[j]
        var average = (currentSum / (j-i+1))

        if(k > j - i + 1){
            j++
        }else if(j-i+1 == k){
            maxAverageSum = max(average, maxAverageSum)

            currentSum -= nums[i]

            i++
            j++
        }


    }

    return maxAverageSum

}