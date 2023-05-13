package string

import java.util.*
import kotlin.collections.HashMap

//https://leetcode.com/problems/sort-array-by-increasing-frequency/
fun main() {

    var nums = arrayOf(1,1,2,2,2,3)
    frequencySort(nums.toIntArray()).forEach {

        println(it)
    }
}

fun frequencySort(s: String): String {

    var numberMap = HashMap<Char,Int>()

    s.forEach {
        var frequency = numberMap.getOrDefault(it,0)
        numberMap.put(it,++frequency)
    }

    var sortedMap = numberMap.entries.sortedWith(kotlin.Comparator {
            o1, o2 -> o2.value - o1.value
    })

    var resultArray = StringBuffer(s.length)
    var i = 0
    sortedMap.forEach {

        for (j in 0..it.value-1)
        {
            resultArray.append(it.key)

        }

    }

    //return resultArray

    return resultArray.toString()
}

fun frequencySort(nums: IntArray): IntArray {

    var numberMap = HashMap<Int,Int>()

    nums.forEach {
        var frequency = numberMap.getOrDefault(it,0)
        numberMap.put(it,++frequency)
    }

    var sortedMap = numberMap.entries.sortedWith(kotlin.Comparator {
            o1, o2 -> if(o1.value != o2.value)
                        o1.value - o2.value
                    else
                        o2.key - o1.key
    })

    var resultArray = IntArray(nums.size)
    var i = 0
    sortedMap.forEach {


    }
    sortedMap.forEach {

        for (j in 0..it.value-1)
        {
            resultArray[i] = it.key
            i++
        }

    }

    return resultArray
}