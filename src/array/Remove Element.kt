package array

fun main() {

    var myArray = IntArray(1)
    myArray[0]=2

    println(removeElementTest(myArray,`val` = 3))


}

fun removeElementTest(nums: IntArray, `val`: Int): Int {
    var startPointer = 0
    var endPointer = nums.size


    while (startPointer < endPointer){


        if(nums[startPointer] == `val`){

            while (endPointer>startPointer){
                if(nums[endPointer] == `val`){
                    endPointer--
                    continue
                }
                break
            }

            var temp = nums[startPointer]
            nums[startPointer] = nums[endPointer]
            nums[endPointer] = temp


        }

        startPointer++


    }


    return endPointer
}