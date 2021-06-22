package amazon.array_string

fun main() {

    println(firstMissingPositive(arrayOf(1).toIntArray()))
}

fun firstMissingPositive(nums: IntArray): Int {

    for (i in nums.indices){

        var charData = "dig1 8 1 5 1"
        charData.split(" ",limit = 2)


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