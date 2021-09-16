package array

fun main() {

    var nums = arrayOf(1,2,3,4).toIntArray()

    productExceptSelf(nums).forEach {

        println(it)
    }
}

fun productExceptSelf(nums: IntArray): IntArray {

    var resultArray = IntArray(nums.size)

    // prefix production

    resultArray[0] = 1

    for (i in 1..resultArray.size-1){
        resultArray[i] = resultArray[i-1] * nums[i-1]
    }


    var R = 1

    for (i in resultArray.size-1 downTo 0){

        resultArray[i] = resultArray[i] * R
        R = R * nums[i]
    }

    return resultArray
}