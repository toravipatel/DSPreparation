package sliding_window

import java.util.*
import kotlin.collections.HashMap

fun main() {
 //getFirstNegativeOfWindow(arrayOf(9,-3,5,-6,9,8,0,5,-7).toIntArray(),3)

    getDistinctElement(arrayOf(1,2,3,2,2,1,3).toIntArray(),k = 3).forEach { println(it) }
}

fun getDistinctElement(nums:IntArray, k:Int):IntArray{

    var i = 0
    var j = 0
    var size = nums.size
    var resultArray = IntArray(nums.size - k + 1)
    var numberMap = HashMap<Int,Int>()


    while (j < nums.size){

        var getCurrentFreqncy = numberMap.getOrDefault(nums[j] , 0)
        numberMap[nums[j]] = ++getCurrentFreqncy

        if(j-i+1 < k){
            j++
        }else if(j -i +1 ==k){

            resultArray[i] = numberMap.size

            var frq = numberMap.getOrDefault(nums[i] , 0)
            if(frq > 1)
                numberMap[nums[i]] = --frq
            else
                numberMap.remove(nums[i])

            i++
            j++
        }


    }

    return resultArray
}

fun getFirstNegativeOfWindow(nums:IntArray,k:Int){

    var i = 0
    var j = 0
    var size = nums.size

    var negativeQueue = LinkedList<Int>()

    while (j < size){

        if(nums[j] < 0){
            negativeQueue.add(nums[j])
        }

        if(j-i+1 < k){
            j++
        }else if(j -i +1 ==k){

            if(!negativeQueue.isEmpty())
                println("first negative number is ${negativeQueue.first}")

            //slide the window
            j++

            if(!negativeQueue.isEmpty() && nums[i] == negativeQueue.first)
                negativeQueue.pop()

            i++
        }
    }



}