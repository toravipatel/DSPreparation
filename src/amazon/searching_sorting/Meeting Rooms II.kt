package amazon.searching_sorting

import java.util.*

fun main() {

}

fun minMeetingRooms(intervals: Array<IntArray>): Int {


    if(intervals.size == 0)
        return 0

    var roomAllocator = PriorityQueue<Int>(kotlin.Comparator { o1, o2 ->
        o1 - o2
    })

    Arrays.sort(intervals, kotlin.Comparator { o1, o2 ->
        o1[0] - o2[0]
    })

    roomAllocator.add(intervals[0][1])

    for (i in 1..intervals.size-1){

        if(intervals[i][0] >= roomAllocator.peek())
        {
            roomAllocator.poll()
        }

        roomAllocator.add(intervals[i][1])

    }


    return roomAllocator.size
}