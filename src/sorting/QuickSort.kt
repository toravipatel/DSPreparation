package sorting

fun main() {



    var number = intArrayOf(5,3,6,1,9,8)
    quickSort(number,0,5)
    //println(findKthLargest(number,6))
    number.forEach {
        println(it)
    }

}

fun findKthLargest(nums: IntArray, k: Int): Int {

    quickSortKthNumber(nums,0,nums.size-1,k)
    return answer
}

var answer = 0

fun quickSortKthNumber(nums: IntArray, low: Int, high: Int,k:Int) {
    if (low < high) {
        var pivot = doPartition(nums, low, high)
        if(pivot == k)
        {
            answer = nums[pivot-1]
        }
        else if(pivot > k){
            quickSortKthNumber(nums, low, pivot - 1,k)
        }else{
            quickSortKthNumber(nums, pivot + 1, high,k)
        }

    }
}

fun quickSort(nums: IntArray, low: Int, high: Int) {
    if (low < high) {
        var pivot = doPartition(nums, low, high)
        quickSort(nums, low, pivot - 1)
        quickSort(nums, pivot + 1, high)
    }
}

fun doPartition(nums: IntArray, low: Int, high: Int): Int {

    var pivot = nums[low]
    var start = low
    var end = high

    while (start < end) {
        while (start <= end && nums[start] <= pivot)
            start++

        while (end >= start && nums[end] > pivot) {
            end--
        }

        if (start < end) {
            var temp = nums[start]
            nums[start] = nums[end]
            nums[end] = temp
        }
    }

    var temp = nums[end]
    nums[end] = nums[low]
    nums[low] = temp


    return end
}
