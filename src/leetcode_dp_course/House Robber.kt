package leetcode_dp_course

import leetcode.stringproblem.numJewelsInStones

fun main() {

}

val memo = HashMap<Int,Int>()


fun robDP(index:Int,nums: IntArray):Int{

    if(index == 0)
        return nums[index]

    if(index == 1){
        return Math.max(nums[0],nums[1])
    }

    if(!memo.containsKey(index))
    {
        var result = Math.max(robDP(index-1,nums), memo.get(index-2)!! + nums[index])
        memo.put(index, result)
    }


    return memo[index]!!
}

fun rob(nums: IntArray): Int {

    robDP(nums.size-1, nums)
    return memo.get(nums.size - 1)!!
}