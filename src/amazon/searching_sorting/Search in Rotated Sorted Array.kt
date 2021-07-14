package amazon.searching_sorting

fun main() {

    println(search(intArrayOf(3,1),1))

}

// 5 6 7 8 9 1 2 3 4

//8 9 1 2 3 4 5 6 7
fun search(nums: IntArray, target: Int): Int {


    var start = 0
    var end = nums.size - 1

    while (start <= end){

        var mid = start + (end - start) / 2

        if(target == nums[mid])
            return mid

        if(nums[start] <= nums[mid]){

            if(target >= nums[start] && target < nums[mid])
                end = mid - 1
            else
                start = mid + 1
        }
        else{
            if(target > nums[mid] && target <= nums[end]){
                start = mid + 1
            }
            else{
                end = mid -1
            }
        }



    }


    return -1
}