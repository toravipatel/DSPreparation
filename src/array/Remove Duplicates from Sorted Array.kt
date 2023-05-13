package array

//https://leetcode.com/problems/remove-duplicates-from-sorted-array/
fun main() {

    var nums = arrayOf(1,1,2).toIntArray()
    println(removeDuplicates(nums))

}

fun removeDuplicates(nums: IntArray): Int {

    var current = 1
    var start = 0

    while (current < nums.size){

        if(nums[current]  != nums[current - 1])
        {
            start++
            nums[start]  = nums[current]
        }

        current++
    }

    return start + 1
}