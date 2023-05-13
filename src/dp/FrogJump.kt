package dp

import java.util.*

var cost = Int.MAX_VALUE
fun main() {

    var nums = intArrayOf(10,30,60,30,10,50)
    //getMinCost(nums, 0, 0)
    //println("result is $cost")

    //var result = getMinCostWithTopToBottom(nums, nums.size - 1,IntArray)

    //println("answer is $result")

    //with dynamic programming

    //var dp = IntArray(nums.size)
    //Arrays.fill(dp,-1)
    //getMinCostWithTopToBottomWithDynamicProgramming(nums, nums.size - 1, dp)
    //println("result with dynamic programming is ${dp[dp.size-1]}")

    var resultWithKJump = getMinCostWithTopToBottomWithKJumps(nums,nums.size - 1, 2)
    println("result with k jump is $resultWithKJump")
}


fun getMinCostWithTopToBottomWithDynamicProgramming(nums:IntArray, n:Int,dp:IntArray):Int{
    if(n == 0)
        return 0

    if(dp[n] != -1)
        return dp[n]

    var firstJump = Math.abs(nums[n] - nums[n-1]) + getMinCostWithTopToBottom(nums,n-1)
    var secondJump = Int.MAX_VALUE
    if(n > 1)
        secondJump = Math.abs(nums[n] - nums[n-2]) + getMinCostWithTopToBottom(nums,n-2)

    dp[n] =  Math.min(firstJump,secondJump)
    return dp[n]


}


fun getMinCostWithTopToBottomWithKJumps(nums:IntArray, n:Int,k:Int):Int{
    if(n == 0)
        return 0

    var ans = Int.MAX_VALUE

    for(i in 1..k){

        if(n-i >= 0)
        {
            var energyRequired = Math.abs(nums[n] - nums[n-i]) + getMinCostWithTopToBottomWithKJumps(nums,n-i,k)
            ans = Math.min(ans, energyRequired)
        }

    }

    return ans




}

fun getMinCostWithTopToBottom(nums:IntArray, n:Int):Int{
    if(n == 0)
        return 0

    var firstJump = Math.abs(nums[n] - nums[n-1]) + getMinCostWithTopToBottom(nums,n-1)
    var secondJump = Int.MAX_VALUE
    if(n > 1)
        secondJump = Math.abs(nums[n] - nums[n-2]) + getMinCostWithTopToBottom(nums,n-2)

    return Math.min(firstJump,secondJump)


}

//pure recursive way startig from index 0 to till last index n. Get all the results and store the minimum one.
fun getMinCost(nums:IntArray, n:Int, currentCost:Int){
    if(n == nums.size - 1){
        cost = Math.min(cost, currentCost)
        return

    }

    getMinCost(nums, n+1, currentCost + Math.abs(nums[n] - nums[n+1]))
    if(n < nums.size - 2)
        getMinCost(nums, n+2, currentCost+Math.abs(nums[n] - nums[n+2]))
}