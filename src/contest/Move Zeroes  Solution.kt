package contest

fun main() {

}

fun moveZeroes(nums: IntArray): Unit {

    var currentIndex = 0
    var nonZeroPointer = 0

    while (nonZeroPointer < nums.size){

        if(nums[nonZeroPointer] != 0)
        {
            nums[currentIndex] = nums[nonZeroPointer]
            currentIndex++
        }

        nonZeroPointer++
    }

    while (currentIndex < nums.size){
        nums[currentIndex] = 0
        currentIndex++
    }

}