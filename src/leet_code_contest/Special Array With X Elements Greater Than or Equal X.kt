package leet_code_contest

fun main() {

    var data = listOf<Int>(3,9,7,8,3,8,6,6)

    println(specialArray(data.toTypedArray().toIntArray()))

}

fun specialArray(nums: IntArray): Int {

    nums.sort()

    for (i in 0..nums[nums.size-1])
    {

        var result = doBinarySearch(nums,i)
        if(result > -1){
            return result
        }
    }


    return -1
}

fun doBinarySearch(nums: IntArray,searchElement:Int):Int{
    var lowIndex = 0
    var highIndex = nums.size-1
    var midElement  = 0
    while(true){

        if(lowIndex>highIndex){
            println("Element not found")
            return if((nums.size - lowIndex) == searchElement ) return searchElement else return -1

        }

        midElement = lowIndex + (highIndex-lowIndex)/2

        if(nums.get(midElement) ==  searchElement){
           /* println("Element found $searchElement")
            return if((nums.size - midElement) == searchElement ) return searchElement else return -1*/

            highIndex = midElement-  1

        }
        else if(nums.get(midElement) > searchElement)
        {
            highIndex = midElement-  1
        }
        else{
            lowIndex = midElement+1
        }

    }

}