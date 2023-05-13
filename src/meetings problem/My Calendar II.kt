package `meetings problem`

import java.util.AbstractList

//https://leetcode.com/problems/my-calendar-ii/
fun main() {

    arrayOf(1,2).toIntArray()
}

class MyCalendarTwo {

    var calenderList:AbstractList<IntArray>
    var conflictList:AbstractList<IntArray>

    constructor(){
        calenderList = ArrayList()
        conflictList = ArrayList()
    }

    fun book(start: Int, end: Int): Boolean {
        conflictList.forEach{
            if(it[0] < end && it[1] > start)
                return false
        }

        calenderList.forEach {
            if(it[0] < end && it[1] > start) {
                conflictList.add(arrayOf(Math.max(start, it[0]), Math.min(end,it[1])).toIntArray())
            }
        }

        calenderList.add(arrayOf(start,end).toIntArray())
        return true
    }
}


