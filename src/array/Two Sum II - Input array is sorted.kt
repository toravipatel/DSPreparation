package array

class `Two Sum II - Input array is sorted` {
}

fun main() {

    var data= intArrayOf(2,7,11,15)
    twoSum(data,18).forEach { println(it) }
}

fun twoSum(numbers: IntArray, target: Int): IntArray {

    var intArray = IntArray(2)

    var startPointer  = 0
    var endPointer = numbers.size-1

    while (startPointer <=endPointer){

        var sum = numbers[startPointer] + numbers[endPointer]

        if(sum == target)
        {
            intArray[0] = startPointer+1
            intArray[1]= endPointer+1
            break
        }

        if(sum> target)
            endPointer--
        else
            startPointer++



    }

    return intArray
}