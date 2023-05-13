package `meetings problem`

import java.util.*

// https://leetcode.com/problems/my-calendar-i/
fun main() {

}

class MyCalendar() {

    var meetingMap = TreeMap<Int,Int>()

    fun book(start: Int, end: Int): Boolean {
        var previousStartTime = meetingMap.floorKey(start)
        var nextStartTime = meetingMap.ceilingKey(start)

        System.out.println("previous start time is $previousStartTime")
        System.out.println("nextStartTime  time is $nextStartTime")

        if((previousStartTime == null || meetingMap.get(previousStartTime)!! <= start) && (nextStartTime == null || end <= nextStartTime)){
            meetingMap[start] = end
            return true
        }
        return false
    }

}