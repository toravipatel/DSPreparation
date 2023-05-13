package array


//https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
fun main() {

    findDisappearedNumbers(arrayOf(4,3,2,7,8,2,3,1).toIntArray()).forEach {

        println(it)
    }

    var s = "abcdefg"
    var result = s.substring(2)
    println(result)
}

fun swapNumber(nums:IntArray,startNumber:Int, endNumber:Int){

    var temp = nums[startNumber]
    nums[startNumber] = nums[endNumber]
    nums[endNumber] = temp


}

fun findDisappearedNumbers(nums: IntArray): List<Int> {

    var resultList = ArrayList<Int>()


    for(i in 0..nums.size-1){


        while(i != nums[i] - 1){


            if(nums[i] == nums[nums[i] - 1])
                break

            swapNumber(nums, i , nums[i]-1)

        }



    }


    for(i in 0..nums.size-1){


        if(i != nums[i] - 1)
            resultList.add(i+1)

    }



    return resultList


}