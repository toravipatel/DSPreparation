package array

fun main() {

}

fun productExceptSelfWithDivision(nums: IntArray): IntArray {

    var totalMultiplicationSum = 0
    var outPutArray = IntArray(nums.size)

    nums.forEach {
        totalMultiplicationSum = totalMultiplicationSum*it
    }

    nums.forEachIndexed { index, i ->

        outPutArray[index] = totalMultiplicationSum/i

    }

    return outPutArray

}