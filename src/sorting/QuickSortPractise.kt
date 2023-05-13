package sorting

fun main() {

    var number = intArrayOf(4,1,2,8,10,12,14,13,14,9)

    doQuickSort(number,0,number.size-1)
    //println(findKthLargest(number,6))
    number.forEach {
        println(it)
    }

}

fun doQuickSort(nums:IntArray, low:Int, high:Int){
    if(low < high){
        var pivot = doParition(nums,low,high)
        doQuickSort(nums, low, pivot-1)
        doQuickSort(nums, pivot+1, high)
    }


}

fun doParition(nums: IntArray, low: Int,high: Int):Int{

    var pivot = nums[low]

    var start = low
    var end = high


    while(start < end){

        while(start <= end && nums[start] <= pivot)
            start++

        while (start <= end && nums[end] > pivot)
            end--

        if(start <= end){
            //do swap index data
            var temp = nums[start]
            nums[start] = nums[end]
            nums[end] = temp
        }






    }

    var endTemp = nums[end]
    nums[end] = pivot
    nums[low] = endTemp

    println("pivot index is $end")
    nums.forEach { print(it) }
    println("----------")

    return end

}