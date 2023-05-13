package array

//https://leetcode.com/problems/contiguous-array/
fun main() {

    var nums = arrayOf(0 ,0, 1, 0, 0, 0, 1, 1)
    println(findMaxLength(nums.toIntArray()))
}

fun findMaxLength(nums: IntArray): Int {

    var currentStatus = 0
    var maxLength = Int.MIN_VALUE
    var resultMap = HashMap<Int,Int>()
    resultMap.put(0,-1)

    nums.forEachIndexed { index, i ->

        if(i == 1)
            currentStatus += 1
        else
            currentStatus -= 1

        if(!resultMap.containsKey(currentStatus))
            resultMap.put(currentStatus, index)
        else{

            var currentLength = index - resultMap.get(currentStatus)!!
            maxLength = Math.max(currentLength, maxLength)
        }

    }
    return maxLength
}