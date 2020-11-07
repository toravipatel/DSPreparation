package array

fun main() {

}

fun moveZeroes(nums: IntArray): Unit {

    var currentPointer = 0
    var nonZeroPointer = 0


    while (nonZeroPointer < nums.size-1){

        while (true){

            if(nums[currentPointer] != 0){
                currentPointer++
            }
            else
                break
        }

        while (true){
            if(nums[nonZeroPointer] != 0)
                break
            else
                nonZeroPointer++
        }


        var temp = nums[currentPointer]
        nums[currentPointer] = nums[nonZeroPointer]
        nums[nonZeroPointer] = temp

    }

}

fun checkIfExist(arr: IntArray): Boolean {




    var numberMap = HashMap<Int,Int>()

    arr.forEach {

        var multipleNumber = it * 2

        if(numberMap.containsKey(multipleNumber)){
            return true
        }
        else if(it%2 == 0){
            var halfnumber = it / 2

            if(numberMap.containsKey(halfnumber))
                return true
            else
                numberMap.put(it,it)
        }

    }

    return false

}