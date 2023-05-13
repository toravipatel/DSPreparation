package array

// https://leetcode.com/problems/subarray-sum-equals-k/

fun main() {

}

fun subarraySum(nums: IntArray, k: Int): Int {

    var prefixSumMap = HashMap<Int,Int>()
    prefixSumMap.put(0,1)

    var prefixSum = 0
    var resultCount = 0

    for (i in 0..nums.size){

        prefixSum  =+ nums[i]
        resultCount =+ prefixSumMap.getOrDefault(prefixSum - k, 0)
        prefixSumMap.put(prefixSumMap.getOrDefault(prefixSum-k,0),0)

    }


    return resultCount
}