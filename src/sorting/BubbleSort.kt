package sorting

fun main() {

    var nums = intArrayOf(64, 34, 25, 12, 22, 11, 90)
    bubbleSort(nums)
    nums.forEach {
        println(it)
    }

}

fun bubbleSort(nums:IntArray){

    for (i in 0..nums.size-1){

        for (j in 0..nums.size - i - 2){

            if(nums[j] > nums[j+1]){

                var temp = nums[j]
                nums[j] = nums[j+1]
                nums[j+1] = temp

            }

        }

    }


}