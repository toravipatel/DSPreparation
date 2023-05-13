package sorting

//merge sort implementation
fun main() {

    var number = intArrayOf(4,1,2,8,10,12,14,13,14,9)
    mergeSort(number, 0 , number.size - 1)
    println("sorted array is")
    number.forEach {
        println(it)
    }
}

fun mergeSort(nums:IntArray, start:Int, end:Int){

    if(start < end){

        var mid = (start + end)/2
        println("value of mid is #$mid")
        mergeSort(nums, start, mid)
        mergeSort(nums, mid+1, end)
        mergeArray(nums, start, mid, end)

    }

}

fun mergeArray(nums: IntArray, start: Int, mid: Int, end: Int) {

    var i = start
    var j = mid+1

    var resultArray = IntArray(end-start + 1)
    var k = 0
    while (i <= mid && j <=end){

        if(nums[i] < nums[j]){
            resultArray[k] = nums[i]
            i++
        }else{
            resultArray[k] = nums[j]
            j++
        }
        k++
    }

    if(i<=mid){

        while (i<=mid){
            resultArray[k] = nums[i]
            i++
            k++
        }

    }

    if(j<=end){

        while (j<=end){
            resultArray[k] = nums[j]
            j++
            k++
        }

    }

    //copy temp array data to actual array of nums

    //resetting k as 0 and copying all the values to actual array. K can not go out of bound as we are just managing
    // start and end index of actual array.
    k = 0

    for (l in start..end){
        nums[l] = resultArray[k]
        k++
    }

}
