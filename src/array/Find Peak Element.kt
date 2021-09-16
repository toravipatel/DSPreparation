package array

//https://leetcode.com/explore/challenge/card/july-leetcoding-challenge-2021/609/week-2-july-8th-july-14th/3812/
fun main() {

    println(findPeakElement(intArrayOf(2,1)))
}

fun findPeakElement(nums: IntArray): Int {

    var start = 0
    var end = nums.size - 1

    while (start < end){

        var mid = (start + end ) /2

        if(mid> 0 && mid < nums.size - 1){

            if(nums[mid] < nums[mid +1])
                start = mid +1
            else
                end = mid

        }else if(mid == 0){

            if(nums[mid] < nums[mid+1])
                return 1
            else
                return 0

        }else if(mid == nums.size-1){

            if(nums[mid] > nums[mid-1])
                return mid
            else
                return mid - 1

        }

    }

    return start
}