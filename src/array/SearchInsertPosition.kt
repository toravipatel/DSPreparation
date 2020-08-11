package array

fun main() {

    var data = intArrayOf(2,3,5,6)
    println(searchInsert(data,4))

}

fun searchInsert(nums: IntArray, target: Int): Int {


    var lowIndex = 0
    var highIndex = nums.size-1
    var midElement  = 0
    while(true){

        if(lowIndex>highIndex){
            println("Element not found")
            break

        }
        midElement = lowIndex + (highIndex-lowIndex)/2

        if(nums.get(midElement) ==  target){
            println("Element found")
            return midElement
        }
        else if(nums.get(midElement) > target)
        {
            highIndex = midElement-  1
        }
        else{
            lowIndex = midElement+1
        }
    }


    lowIndex--
    highIndex++

    if(highIndex>nums.size-1)
        return highIndex
    else if(lowIndex<0)
        return 0
    else
    {

        for( i in lowIndex..highIndex){
            if(nums[i] < target)
                continue
            else
                return i
        }

    }
    return 0

}