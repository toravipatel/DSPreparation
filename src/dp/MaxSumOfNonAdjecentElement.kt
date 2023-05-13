package dp

import kotlin.math.max

fun main() {

    var nums = intArrayOf(2,1,4,6,3,7)
    var result = maxSumOfNonAdjacent(nums,nums.size - 1)
    println("result is $result")


}

fun maxSumOfNonAdjacent(nums:IntArray,index:Int):Int{
    if(index == 0)
        return nums[index]
    if(index == -1)
        return 0

    var pick = nums[index] + maxSumOfNonAdjacent(nums,index - 2)
    var nonPick = 0 + maxSumOfNonAdjacent(nums,index - 1)

    return Math.max(pick,nonPick)


}

