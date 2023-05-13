package array

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashSet

//https://leetcode.com/problems/third-maximum-number/description/
fun main() {

    var nums = intArrayOf(1,2,2,5,3,5)
    print(thirdMax(nums))

    "ArrayList<Int>().toA"

}

fun thirdMax(nums: IntArray): Int {

    var numQueue = PriorityQueue<Int>()
    var numSet = HashSet<Int>()

    for(i in 0..nums.size - 1){

        if(numSet.contains(nums[i]))
            continue


        if(numQueue.size < 3)
        {
            numQueue.add(nums[i])
            numSet.add(nums[i])
            continue
        }

        if(numQueue.size == 3){

            println("peek value is ${numQueue.peek()}")

            if(numQueue.peek() < nums[i]){
                numSet.remove(numQueue.poll())

                println("peek value after removal is ${numQueue.peek()}")
                numQueue.add(nums[i])
                numSet.add(nums[i])
            }
        }
    }

    if(numQueue.size == 3)
    {

        /* while(numQueue.size != 1)
        {
            numQueue.poll()
        }

         println("final queue size after removal ${numQueue.size}")*/

        return numQueue.poll()
    }



    return numQueue.peek()

}