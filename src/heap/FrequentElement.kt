package heap

import java.util.*
import kotlin.collections.HashMap

// https://leetcode.com/explore/learn/card/heap/646/practices/4015/

fun main() {

    topKFrequent(arrayOf<Int>(1,1,1,2,2,3).toIntArray(),2).forEach {
        println(it)
    }
}


fun topKFrequent(nums: IntArray, k: Int): IntArray {

    var numMap = HashMap<Int,Int>()

    nums.forEach{

        var currentFrequency = numMap.getOrDefault(it,0)
        numMap[it] = currentFrequency + 1

    }

    var numsQueue = PriorityQueue<Int> { t1, t2 -> numMap.get(t1)!! - numMap.get(t2)!! }

    numMap.keys.forEach{

        numsQueue.add(it)
        if(numsQueue.size > k)
            numsQueue.poll()

    }

    var numsArray = IntArray(k)

    numsQueue.forEachIndexed { index, i ->

        numsArray[index] = i

    }

    return numsArray
}