package array


fun main() {

    val data = intArrayOf(2,3,4,5,2,8,2,4)
    println(removeElement(data,4))




}

fun removeElement(nums: IntArray, dataValue: Int): Int {

  /*  var startPointer = 0
    var endPointer = nums.size-1
    var swapCouter = 0
    var size = nums.size

    while(startPointer<endPointer){

        while (nums[startPointer] != dataValue && startPointer<endPointer){
            startPointer++
        }

        while (nums[endPointer] == dataValue && endPointer>startPointer){
            endPointer--
        }

        if(startPointer>endPointer)
            break

        var temp = nums[startPointer]
        nums[startPointer] = nums[endPointer]
        nums[endPointer] = temp
        swapCouter++
        size--

        if(startPointer<endPointer)
            break

        }


    return nums.size- swapCouter*/


    var i = 0
    var n = nums.size
    while (i < n) {
        if (nums[i] == dataValue) {
            nums[i] = nums[n - 1]
            // reduce array size by one
            n--
        } else {
            i++
        }
    }
    return n
}
