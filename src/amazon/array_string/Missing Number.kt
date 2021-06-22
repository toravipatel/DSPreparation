package amazon.array_string

class `Missing Number` {
}

fun main() {



}

fun missingNumber(nums: IntArray): Int {

    var missing = nums.size

    for (i in nums.indices)
    {
        missing = missing xor i xor nums[i]

    }

    return missing
}