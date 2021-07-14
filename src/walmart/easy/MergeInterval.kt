package walmart.easy

import java.util.*
import kotlin.collections.ArrayList

fun main() {

    //val array = Array<IntArray>()
    //array[0] = IntArray(2, )

    //merge(Array<IntArray()>())

}

fun merge(intervals: Array<IntArray>): Array<IntArray> {

    val finalArray = ArrayList<IntArray>()

    Arrays.sort(intervals, kotlin.Comparator { o1, o2 ->
        o1[0] - o2[0]
    })

    finalArray.add(intervals[0])
    for (i in 1 until intervals.size){

        var lastPushedItem = finalArray.last()
        if(lastPushedItem[1] > intervals[i][0]){
            //lastPushedItem[1] = Math.max(intervals[i][1],lastPushedItem[1])
            //finalArray.add(i-1,lastPushedItem)
            finalArray[i-1][1] = Math.max(intervals[i][1],lastPushedItem[1])
        }
        else
        {
            finalArray.add(intervals[i])
        }
    }


    return finalArray.toTypedArray()

}