package sliding_window

fun main() {

    //println(getLongestSubArrayOfSum(arrayOf(4,1,1,1,2,3,5).toIntArray(), 5))
    print(minSubArrayLen(7, arrayOf(2,3,1,2,4,3).toIntArray()))
}

fun minSubArrayLen(target: Int, nums: IntArray): Int {

    var i = 0
    var j = 0
    var size = nums.size

    var currentSum = 0
    var windowSize = Int.MAX_VALUE

    while (j < size) {

        currentSum += nums[j]

        if (currentSum == target) {
            windowSize = Math.min(windowSize, j - i + 1)
        } else if (currentSum > target) {
            windowSize = Math.min(windowSize, j - i + 1)


            while (currentSum >= target) {
                currentSum -= nums[i]
                i++

                if(currentSum >= target)
                    windowSize = Math.min(windowSize, j - i + 1)
            }
        }

        j++
    }



    return windowSize
}

fun getLongestSubArrayOfSum(nums: IntArray, target: Int): Int {

    var i = 0
    var j = 0
    var size = nums.size

    var currentSum = 0
    var windowSize = Int.MIN_VALUE

    while (j < size) {

        currentSum += nums[j]

        if (currentSum == target) {
            windowSize = Math.max(windowSize, j - i + 1)
        } else if (currentSum > target) {

            while (currentSum > target) {
                currentSum -= nums[i]
                i++
            }
        }

        j++
    }



    return windowSize
}