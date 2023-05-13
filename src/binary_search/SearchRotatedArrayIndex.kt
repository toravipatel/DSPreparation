package binary_search

fun main() {

    var numsArray = arrayOf(1, 2, 3, 4 ,4,4,4,4,4,4,6).toIntArray()
    //println(getFirstOccuranceOfNumber(numsArray, 4))

    var rotatedArray = arrayOf(11,12,13,14,15,16,1,2,3).toIntArray()
    println(searchRotatedArrayIndex(rotatedArray))
}

fun getFirstOccuranceOfNumber(nums:IntArray, target:Int):Int{

    var start = 0
    var end = nums.size - 1

    var resultIndex = -1
    while (start <= end){

        var mid = start + (end - start)/ 2
        if(nums[mid] == target)
        {
            resultIndex = mid
            end = mid - 1
        }else if(nums[mid] > target){
            end = mid - 1
        }else{
            start = mid + 1
        }

    }

    return resultIndex
}

fun searchRotatedArrayIndex(nums:IntArray):Int{

    var start = 0
    var end = nums.size - 1


    while (start <= end){

        var mid = start + (end - start) / 2

        if(nums[mid] < nums[(mid + 1)%(nums.size - 1)] && nums[mid] < nums[(mid+ nums.size - 1)%(nums.size)]){
            return mid + 1
        }else if(nums[mid] > nums[start] && nums[mid] > nums[end]){
            start = mid + 1
        }else
        {
            end = mid - 1
        }
    }


    return -1
}