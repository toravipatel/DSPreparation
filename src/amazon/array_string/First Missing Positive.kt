package amazon.array_string

fun main() {

    println(firstMissingPositive(arrayOf(1,4,5).toIntArray()))
}

fun firstMissingPositive(nums: IntArray): Int {

    for (i in nums.indices){

        var correctPosition = nums[i] - 1
        while (nums[i] >= 0 && nums[i] <= nums.size && nums[i]!=nums[correctPosition] ){

            var temp = nums[correctPosition]
            nums[correctPosition] = nums[i]
            nums[i] = temp

            correctPosition = nums[i] - 1

        }
    }

    nums.forEachIndexed { index, i ->

        if(index+1 != i)
            return index+1

    }


    return nums.size
}