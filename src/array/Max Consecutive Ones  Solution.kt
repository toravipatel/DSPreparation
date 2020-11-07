package array

fun findMaxConsecutiveOnes(nums: IntArray): Int {

    var max = Int.MIN_VALUE
    var currentCounter = 0

    nums.forEach {

        if(it == 1)
            currentCounter++
        else
        {
            if(currentCounter > max)
                max = currentCounter

            currentCounter = 0
        }
        if(currentCounter > max)
            max = currentCounter
    }

    return max

}

fun main() {

    var a = IntArray(1)
    a[0] = 1
    findMaxConsecutiveOnes(a)
}