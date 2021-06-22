package contest

fun main() {

    var nums = arrayOf(7,4,2,9)
    println(worstLosingStreak(nums))
}

fun worstLosingStreak(nums: Array<Int>): Int {
    // Write your code here

    var maxSoFar = nums[0]
    var maxLoss = 0
    for (i in 0..nums.size-1) {
        maxSoFar = Math.max(maxSoFar, nums[i])

        var loss = maxSoFar - nums[i]

        maxLoss = Math.max(maxLoss, loss)
    }
    return maxLoss

}