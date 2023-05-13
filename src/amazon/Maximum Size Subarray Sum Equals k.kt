package amazon


//https://leetcode.com/problems/maximum-size-subarray-sum-equals-k/
fun main() {


    print(maxSubArrayLen(arrayOf(-2,-1,2,1).toIntArray(),1))
}

fun maxSubArrayLen(nums: IntArray, k: Int): Int {

    if(nums.isEmpty())
        return 0

    var prefixSum = 0
    var maxLength = Int.MIN_VALUE
    var prefixMap = HashMap<Int,Int>()

    nums.forEachIndexed { index, i ->

        prefixSum += i
        var valueToSearch = prefixSum - k
        if(prefixSum == k){
            maxLength = Math.max(maxLength, index + 1)
        }


        if(prefixMap.containsKey(valueToSearch))
        {
            maxLength = Math.max(maxLength, index - prefixMap.getOrDefault(valueToSearch,0) )
        }else{
            if(!prefixMap.containsKey(prefixSum))
                prefixMap[prefixSum] = index
        }

    }


    return maxLength
}